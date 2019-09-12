# BDC Java Client Library

This library is a wrapper around the [BDC API](https://developer.bill.com/hc/en-us/articles/211360686-API-Mechanics)


# Status

The BDC Java Client Library is currently **Under Development**

Meaning– please expect frequent changes and check the release notes for what's changed.

# Conventions
##DataTypes and their uses:
BigDecimal - all dollar/monetary amounts
BigInteger - all non-string identifiers
String - all dates (plan to use LocalDate in the future)

# Contributing
## Testing
Documentation of current testing structure can be found under ExampleTest.java and BDDTests.java
Tests can be run in bulk by right clicking on the folder test/java and selecting run. Tests will run properly in
Gradle or IntelliJ, but to see formatted output correctly on bulk runs, please use Intellij

## Requirements
Please make sure that the Lombok plugin is installed for Intellij

