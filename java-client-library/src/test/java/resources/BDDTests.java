package resources;

import org.junit.jupiter.api.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public abstract class BDDTests {

    /** This Tag denotes a functional test and tester should be wary of dependencies within the test subject*/
    @Target(METHOD)
    @Retention(RUNTIME)
    @Tag("functional")
    @Test
    public @interface FunctionalTest{}

    /** This Tag denotes a functional test and tester should be wary of dependencies within the test subject*/
    @Target(METHOD)
    @Retention(RUNTIME)
    @Disabled
    @Tag("functional")
    @Test
    public @interface DisabledFunctionalTest{}

    /** Note from Keith: Made this to note to self what kinds of things I want to test for when I have time to implement */
    @Target(METHOD)
    @Retention(RUNTIME)
    @Disabled
    @Test
    public @interface DisabledTest{}

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Initializers.class)
    public @interface InitialBehaviors {}

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Methods.class)
    public @interface Interface {}

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Behaviors.class)
    public @interface Behavior {}

    @Target({ TYPE, METHOD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Conditions.class)
    public @interface Condition {}

//    IndicitiveSentences will be used for the second level of tests (i.e. Instance and Class Methods)
    static public class Methods extends DisplayNameGenerator.ReplaceUnderscores {
//      Non-nested classes should be Methods
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

//        Nested classes should be conditional indicators
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return "#" + super.generateDisplayNameForNestedClass(nestedClass);
        }

//        Methods should be behavioral indicators
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }


    static public class Behaviors extends DisplayNameGenerator.ReplaceUnderscores {
        //      Non-nested classes should be Methods
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        //        Nested classes should be conditional indicators
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            String name = super.generateDisplayNameForNestedClass(nestedClass);
            return name.replace('_', ' ') + ':';
        }

        //        Methods should be behavioral indicators
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }

    static public class Initializers extends DisplayNameGenerator.ReplaceUnderscores {
        //      Non-nested classes should be Methods
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        //        Nested classes should be conditional indicators
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return "--" + super.generateDisplayNameForNestedClass(nestedClass) + "--";
        }

        //        Methods should be behavioral indicators
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }

    static public class Conditions extends DisplayNameGenerator.ReplaceUnderscores {
        //      Non-nested classes should be Methods
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        //        Nested classes should be conditional indicators
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + ":";
        }

        //        Methods should be behavioral indicators
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }
}