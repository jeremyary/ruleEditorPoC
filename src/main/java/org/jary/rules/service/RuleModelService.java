package org.jary.rules.service;

import org.jary.rules.enums.RuleEditorEnum;
import org.jary.rules.RuleElement;
import org.jary.rules.annotations.RuleModel;
import org.jary.rules.annotations.RuleModelExclusion;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * service to collect rule elements via annotation scan and return list for editor consumption
 * based on annotated configuration of {@link RuleModel} & {@link RuleModelExclusion}
 *
 * @author jary
 * @since Dec/11/2013
 */
@Component
public class RuleModelService {

    /**
     * package path to lowest level inclusion of all rule model object types
     */
    private final static String MODEL_PACKAGE = "org.jary.rules.model";

    /**
     * gather collection of rule elements for condition entry within editor
     *
     * @param targetEditor rule editor we'd like to populate
     * @return List of rule elements for editor
     */
    public List<RuleElement> getRuleElements(RuleEditorEnum targetEditor) {

        List<RuleElement> elements = new ArrayList<RuleElement>();

        for (BeanDefinition bd : findAllBeanDefinitions()) {

            try {
                Class<? extends Object> clazz = Class.forName(bd.getBeanClassName());
                RuleModel annotation = clazz.getAnnotation(RuleModel.class);

                // model should match rule editor of interest or ALL
                List<RuleEditorEnum> editors = Arrays.asList(annotation.value());
                if (editors.contains(targetEditor) || editors.contains(RuleEditorEnum.ALL)) {
                    elements.addAll(findAllIncludedProperties(clazz, targetEditor));
                }

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return elements;
    }

    /**
     * scan model package looking for class-level {@link RuleModel} annotation for rule element inclusion
     *
     * @return Set of Bean Definitions of annotated classes
     */
    private Set<BeanDefinition> findAllBeanDefinitions() {

        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(RuleModel.class));
        return scanner.findCandidateComponents(MODEL_PACKAGE);
    }

    /**
     * find all properties with read methods that aren't excluded via annotation
     *
     * @param clazz        parent class type
     * @param targetEditor rule editor we'd like to populate
     * @return List of rule elements from clazz for editor consumption
     */
    private List<RuleElement> findAllIncludedProperties(Class<? extends Object> clazz, RuleEditorEnum targetEditor) {

        List<RuleElement> elements = new ArrayList<RuleElement>();

        try {
            // read out properties available to the editor
            for (PropertyDescriptor property : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {

                // don't want to expose class type and it's implicit, so no model annotation can be added
                if (!property.getDisplayName().equals("class")) {

                    // if we have an exclusion, we need to make sure it applies to the relevant editor (or all)
                    RuleModelExclusion exclusion = property.getReadMethod().getAnnotation(RuleModelExclusion.class);
                    if (exclusion == null ||
                            (!Arrays.asList(exclusion.value()).contains(targetEditor) &&
                                    !Arrays.asList(exclusion.value()).contains(RuleEditorEnum.ALL))) {

                        elements.add(new RuleElement(property.getDisplayName(),
                                property.getPropertyType(), property.getReadMethod(), clazz));
                    }
                }
            }
        } catch (IntrospectionException ex) {
            ex.printStackTrace();
        }
        return elements;
    }
}