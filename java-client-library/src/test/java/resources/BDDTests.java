package resources;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.Session;
import com.bill.java.api.param.SessionLoginRequestParams;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public abstract class BDDTests {
    Faker faker = new Faker();
    Random rand = new Random();


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

    public String genNumAsString(int start, int end) {
        return String.valueOf(new Random().ints(1, start, end + 1).toArray()[0]);
    }

    // Length can't be longer than 19
    public String genNumAsString(int len) {
        return String.valueOf(faker.number().randomNumber(len, true));
    }

    public String genFutureDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(faker.date().future(10, TimeUnit.DAYS));
    }

    public Boolean genBool() {
        return rand.nextInt(1) == 1;
    }

    public String genFName() {
        return faker.name().firstName();
    }

    public String genLName() {
        return faker.name().lastName();
    }

    public String genFullName() {
        return genFName() + " " + genLName();
    }

    public String genCompanyName() {
        return faker.company().name();
    }

    public String genAddress1() {
        return faker.address().streetAddress();
    }

    public String genAddress2() {
        return faker.address().secondaryAddress();
    }

    public String genAddress4() {
        return faker.address().streetAddressNumber();
    }

    public String genAddress3() {
        return faker.address().buildingNumber();
    }

    public String genCity() {
        return faker.address().city();
    }

    public String genState() {
        return faker.address().stateAbbr();
    }

    public String genZip() {
        return faker.address().zipCode();
    }

    public String genCountry() {
        return faker.address().countryCode();
    }

    public String genEmail() {
        return faker.internet().emailAddress();
    }

    public String genPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String genDescription() {
        return faker.lorem().paragraph(2);
    }

    public void login() throws BDCException, IOException {
        login(1);
    }
    
    public void login(Integer user) throws BDCException, IOException {
        if( user == 2){
            BDC.devKey = TestEnv.devKey2;
            BDC.userName = TestEnv.userName2;
            BDC.password = TestEnv.password2;
            BDC.setApiBase(BDC.Env.SANDBOX);

            SessionLoginRequestParams params = SessionLoginRequestParams.builder()
                    .with($ -> {
                        $.orgId = TestEnv.orgId2;
                        $.mfaId = TestEnv.mfaId2;
                        $.deviceId = TestEnv.deviceId2;
                    }).build();
            Session.login(params);
        } else {
            BDC.devKey = TestEnv.devKey;
            BDC.userName = TestEnv.userName;
            BDC.password = TestEnv.password;
            BDC.setApiBase(BDC.Env.SANDBOX);

            SessionLoginRequestParams params = SessionLoginRequestParams.builder()
                    .with($ -> {
                        $.orgId = TestEnv.orgId;
                        $.mfaId = TestEnv.mfaId;
                        $.deviceId = TestEnv.deviceId;
                    }).build();
            Session.login(params);
        }

    }
}
