package interfaces;

import org.junit.jupiter.api.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public abstract class BDDTests {
    @Target({ TYPE, METHOD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Initializers.class)
    public @interface InitialBehaviors {}

    @Target({ TYPE, METHOD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Behaviors.class)
    public @interface Interface {}

    @Target({ TYPE, METHOD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayNameGeneration(Conditions.class)
    public @interface Condition {}

//    IndicitiveSentences will be used for the second level of tests (i.e. Instance and Class Methods)
    static public class Behaviors extends DisplayNameGenerator.ReplaceUnderscores {
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
