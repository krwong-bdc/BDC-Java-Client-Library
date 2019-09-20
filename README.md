## Disclaimer

This Java client library can only be used at the Hackrice-Hackathon.

You may not, directly or indirectly: copy or distribute, use commercially for the benefit of a third party, reverse engineer, disassemble, decompile, attempt to discover the source code or structure, sequence and organization of, or remove any proprietary notices from, the Client Library.

# BDC Java Client Library

Status: **Under Development**  
This library is a Java wrapper around the [BDC API](https://developer.bill.com/hc/en-us/articles/211360686-API-Mechanics)

### Library

- [Lombok](https://projectlombok.org/) v1.18.8
- [Lombok annotation processor](https://github.com/franzbecker/gradle-lombok/blob/master/LICENSE) v3.1.0
- [GSON](https://github.com/google/gson/blob/master/LICENSE) v2.8.5

### Testing

- [Junit](https://github.com/junit-team/junit5/blob/master/LICENSE.md) v5.5.1
- [Mockito](https://github.com/mockito/mockito/blob/release/3.x/LICENSE) v2.+
- [JavaFaker](https://github.com/DiUS/java-faker/blob/master/LICENSE) v1.0.1

### Deployment

- [Gradle](https://docs.gradle.org/current/userguide/gradle_wrapper.html) v5.6.2
- [Gradle Shadow](https://github.com/johnrengelman/shadow) v5.1.0

#Documentation
- [BDC API developer docs](https://developer.bill.com/hc/en-us/categories/201195646)  
- [Java Client Library docs](https://krwong-bdc.github.io/BDC-Java-Client-Library/)

# Before you begin

1. [Sign up](https://developer.bill.com/hc/en-us/requests/new?ticket_form_id=154803) for the API Developer Key and create a developer account (Organization). A Sales Specialist will review the request and reach out to discuss your objectives.
2. Once API access is provisioned, you receive an email with the following details:
   - Organization ID
   - Developer Key
   - API Endpoint URL

# Installation guide

Download the [.jar](https://github.com/krwong-bdc/BDC-Java-Client-Library/releases/tag/0.0.1) and add it as a dependency to your project.

## Gradle instructions

1. Make a ./libs folder in the project root
2. Add the [.jar](https://github.com/krwong-bdc/BDC-Java-Client-Library/releases/tag/0.0.1) to the folder
3. Add the dependency to your build.gradle

```java
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    ...
}
```

## Testing Requirements

If you are extending the client library and need to run the included tests, please make sure that the Lombok plugin is installed for Intellij with annotation processing turned on in the compilation settings.

# Conventions

## DataTypes and their uses:

- BigDecimal - all dollar/monetary amounts
- BigInteger - all non-string identifiers
- String - all dates (plan to use LocalDate in the future)

# Usage

## 1) Setup (Things to do **first**)

Set your credentials on the BDC class. Once set, you will never need to enter them again.

```java
BDC.userName = "JDoe@gmail.com";
BDC.password = "************";
BDC.devKey = "***********";
//API Base should be set to Sandbox unless you are in live production
BDC.setApiBase(BDC.Env.Sandbox)
```

## 2) Getting started with Authentication

Authenticating through the client library is done by calling the Session#login(SessionLoginRequestParams) method. This method returns a Session object. However, it also sets the request credentials on the Auth class to effectively authenticate subsequent calls made through the client library.

Attempting to call a method within the Client Library before authenticating, will result in a Session Invalid Error.

```java
SessionLoginRequestParams params = SessionLoginRequestParams.builder()
        .with($ -> {
            //Org Id can be retrieved through a call to Session#ListOrgs()
            $.orgId = TestEnv.orgId;
            $.mfaId = TestEnv.mfaId;
            $.deviceId = TestEnv.deviceId;
        }).build();

Session.login(params);
```

## 3) Workflow

> Note:
> Almost all requests require an `ApiRequestParam` extended object  
> Almost all objects are required to be built using the Builder Pattern

An example workflow may look like this:

```java
CustomerCreateParams params = CustomerCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.name = "iPhone Supplier";
                        $.shortName = "iSupp";
                        $.companyName = "Phone Depot";
                        $.contactFirstName = "Brook";
                        $.contactLastName = "Lynan";
                        $.accNumber = "777";
                    }).build());

Customer newCustomer = Customer.create(params);
```

## 4) Custom Requests

As the client library does not currently cover all the Bill.com Developer platform APIs, you may find you need to implement your own requests

You can easily extend the library by extending the `ApiResource` and `ApiResourceParams` classes.
Extending the library requires [GSON](https://github.com/google/gson/blob/master/LICENSE) v2.8.5 (Included in the library if you are using the release [.jar](https://github.com/krwong-bdc/BDC-Java-Client-Library/releases/tag/0.0.1))

## Example

### 1) Extending the ApiResourceParams class:

> Note how the SerializedNames and the class structure below match how the [Bill](https://developer.bill.com/hc/en-us/articles/208155326-Bill) create endpoint expects to receive request data.

```java
import com.google.gson.annotations.SerializedName;
...

public class BillCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    public BillCreateRequestParams(Params params) { this.params = params; }

    public static class Params {
        @SerializedName("entity")
        private String entity = "Bill";

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("vendorId")
        private String vendorId;

        @SerializedName("invoiceNumber")
        private String invoiceNumber;

        @SerializedName("invoiceDate")
        private String invoiceDate;

        @SerializedName("dueDate")
        private String dueDate;

        @SerializedName("glPostingDate")
        private String glPostingDate;

        @SerializedName("description")
        private String description;

        @SerializedName("poNumber")
        private String poNumber;

        @SerializedName("billLineItems")
        private List<Bill.BillLineItem> billLineItems;

        Params(String isActive,
               String vendorId,
               String invoiceNumber,
               String invoiceDate,
               String dueDate,
               String glPostingDate,
               String description,
               String poNumber,
               List<Bill.BillLineItem> billLineItems){
            this.isActive = isActive;
            this.vendorId = vendorId;
            this.invoiceNumber = invoiceNumber;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.glPostingDate = glPostingDate;
            this.description = description;
            this.poNumber = poNumber;
            this.billLineItems = billLineItems;
        }
    }

}
```

### Extending and using the ApiResource class:

> Note how the SerializedNames and the class structure map to the response data from an API Read request

```java
public class Bill extends ApiResource {
    @SerializedName("entity")
    public String entity;

    @SerializedName("id")
    public String id;

    @SerializedName("isActive")
    public String isActive;

    @SerializedName("vendorId")
    public String vendorId;

    @SerializedName("invoiceNumber")
    public String invoiceNumber;

    @SerializedName("approvalStatus")
    public String approvalStatus;

    @SerializedName("invoiceDate")
    public String invoiceDate;

    @SerializedName("dueDate")
    public String dueDate;

    @SerializedName("glPostingDate")
    public String glPostingDate;

    @SerializedName("amount")
    public BigDecimal amount;

    @SerializedName("scheduledAmount")
    public BigDecimal scheduledAmount;

    @SerializedName("paidAmount")
    public String paidAmount;

    @SerializedName("dueAmount")
    public BigDecimal dueAmount;

    @SerializedName("paymentStatus")
    public String paymentStatus;

    @SerializedName("description")
    public String description;

    @SerializedName("poNumber")
    public String poNumber;

    @SerializedName("createdTime")
    public String createdTime;

    @SerializedName("updatedTime")
    public String updatedTime;

    @SerializedName("payFromBankAccountId")
    public String payFromBankAccountId;

    @SerializedName("payFromChartOfAccountId")
    public String payFromChartOfAccountId;

    @SerializedName("billLineItems")
    public List<BillLineItem> billLineItems;

    /**
     * The ApiResource class has a variety of `#create` methods that will automatically make API requests with your set credentials.
     * Please see the example below for how to use your custom classes to make a request:
     */
    public static Bill get(BillCreateRequestParams billGetRequestParams) throws BDCException, IOException {
        if(billGetRequestParams == null) {
            throw new NullPointerException("BillGetRequestParams required");
        }
        return create("/Crud/Create/Bill.json", billGetRequestParams, Bill.class);
    }

```
