# Annotation-Based Rule Model w/Graphical Editor

Proof of Concept intended to demonstrate the usage of annotations and reflection to mark properties of the data model via getter methods as eligible rule elements for
display within a graphical editor. There are class-level & property-level annotations that each allow (in/ex)clusion of the class and individual properties
to specific editors (defaults to all) as found in [@RuleEditorEnum](RuleEditorEnum.java).

See annotations [@RuleModel](RuleModel.java) & [@RuleModelExclusion](RuleModelExclusion.java).

Example model class:

    @RuleModel({ RuleEditorEnum.ALL })

    public class Example {

        @RuleModelExclusion({ RuleEditorEnum.ALL })
        private String notIncluded;

        private String skipsOnlyOne;

        private Boolean thisOneIncludedInAllEditors;

        /* getters for properties */
    }