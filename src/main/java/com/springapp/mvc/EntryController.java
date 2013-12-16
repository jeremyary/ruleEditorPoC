package com.springapp.mvc;

import org.jary.rules.ruleTypes.RuleType;
import org.jary.rules.service.RuleBuilderService;
import org.jary.rules.service.RuleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * app's sole controller
 *
 * @author jary
 * @since Dec/11/2013
 */
@Controller
public class EntryController {

    @Autowired
    RuleModelService ruleModelService;

    @Autowired
    RuleBuilderService ruleBuilderService;

    @Autowired
    Map<String, RuleType> ruleTypeMap;

    /**
     * entry point of app, shows editor UI
     *
     * @param model
     * @return String editor jsp
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap model) {

        model.addAttribute("ruleTypeMap", ruleTypeMap);
        return "editor";
    }

    /**
     * process a rule submittal
     *
     * @param params map of info about rule, including ruleType and other needed info
     * @param model
     * @return String success jsp
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(@RequestParam Map<String, String> params, ModelMap model) {

        model.addAttribute("result", ruleBuilderService.build(params));
        return "success";
    }

    /**
     * fetch markup for a ruleType's ruleStage html
     *
     * @param targetType rule type needed for editor display
     * @param model
     * @return String success jsp
     */
    @RequestMapping(value = "/rulemarkup", method = RequestMethod.POST)
    public String ruleMarkup(@RequestParam("ruleType") String targetType, ModelMap model) {

        for (RuleType ruleType : ruleTypeMap.values()) {
            if (ruleType.getClass().getSimpleName().equalsIgnoreCase(targetType)) {
                model.addAttribute("result", ruleType.getMarkup());
                return "success";
            }
        }
        throw new IllegalArgumentException("ruleType " + targetType + " not found.");
    }
}