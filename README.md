# BDC Java Client Library

Status: **Under Development**
This library is a wrapper around the [BDC API](https://developer.bill.com/hc/en-us/articles/211360686-API-Mechanics)

# Installation guide

Download the jar file and add it as an external dependency to your project.

## Requirements

Please make sure that the Lombok plugin is installed for Intellij with annotation

# Usage

## Conventions
### DataTypes and their uses:
BigDecimal - all dollar/monetary amounts
BigInteger - all non-string identifiers
String - all dates (plan to use LocalDate in the future)

## Setup: Things to do **first**

Set your credentials on the BDC class. Once set, you will never need to enter them again.

```java
BDC.devKey = "***********";
BDC.userName = "JohnDoe@gmail.com";
BDC.password = "************";
BDC.setApiBase(BDC.Env.Sandbox)
```

## Login & MFA authenticate

First you need to get an organization ID

```java
SessionLoginRequestParams params = SessionLoginRequestParams.builder()
        .with($ -> {
            $.orgId = TestEnv.orgId;
            $.mfaId = TestEnv.mfaId;
            $.deviceId = TestEnv.deviceId;
        }).build();
Session.login(params);
```

# Technologies used

## Library

Lombok:
https://projectlombok.org/
https://opensource.org/licenses/mit-license.php

Lombok annotation processor:
https://github.com/franzbecker/gradle-lombok/blob/master/LICENSE

GSON:
https://github.com/google/gson/blob/master/LICENSE

## Testing

Junit:
https://github.com/junit-team/junit5/blob/master/LICENSE.md

Mockito:
https://github.com/mockito/mockito/blob/release/3.x/LICENSE

JavaFaker:
https://github.com/DiUS/java-faker/blob/master/LICENSE

# License
