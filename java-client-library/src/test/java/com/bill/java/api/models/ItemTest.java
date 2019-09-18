package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.ItemCreateRequestParams;
import com.bill.java.api.param.ItemGetRequestParams;
import com.bill.java.api.param.ItemUpdateRequestParams;
import com.bill.java.api.param.ListRequestParams;
import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("@Item")
class ItemTest extends BDDTests {

    private String entity = "Item";
    private String id;
    private String isActive;
    private String name;
    private String type;
    private String description;
    private BigDecimal price;
    private Integer percentage;
    private String parentItemId;
    private Boolean hasPurInfo;
    private String expenseAccount;
    private String purDescription;
    private BigDecimal purCost;
    private String chartOfAccountId;
    private Boolean taxable;
    private String shortName;
    private String mergedIntoId;


    private String itemId;

    @BeforeEach
    void setup() throws Exception {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;

        login();

        isActive = genNumAsString(1, 2);
        name = genFullName();
        type = String.valueOf(genNumAsString(0, 13));
        description = genDescription();
        price = BigDecimal.valueOf(new Random().nextInt(40000), 2);
        purDescription = genDescription() ;
        taxable = genBool();
        shortName = genFName();

        ItemCreateRequestParams params = ItemCreateRequestParams.builder()
                .with($ -> {
                    $.isActive = isActive;
                    $.name = name;
                    $.type = type;
                    $.description = description;
                    $.price = price;
                    $.purDescription = purDescription;
                    $.taxable = taxable;
                    $.shortName = shortName;
                }).build();

        Item item = Item.create(params);

        itemId = item.getId();
    }

    @Interface
    class list {
        @FunctionalTest
        void should_fetch_a_list() {
            assertDoesNotThrow(() -> {
                ListRequestParams params = ListRequestParams.builder()
                        .with($ -> {
                            $.start = 0;
                            $.max = 10;
                        }).build();
                Item.list(params);
            });
        }
    }

    @Interface
    class create {
        @FunctionalTest
        void should_create_an_item_with_passed_params() throws Exception {
            ItemCreateRequestParams params = ItemCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.name = name;
                        $.type = type;
                        $.description = description;
                        $.price = price;
                        $.purDescription = purDescription;
                        $.taxable = taxable;
                        $.shortName = shortName;
                    }).build();

            Item item = Item.create(params);
            checkValues(item);
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Item.create(ItemCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_sepcified_item() throws Exception {
            ItemGetRequestParams params = ItemGetRequestParams.builder()
                    .with($ -> {
                        $.id = itemId;
                    }).build();
            Item item = Item.get(params);
            assertAll(() -> assertEquals(itemId, item.getId()));
        }
        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Item.get(ItemGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update {
        @FunctionalTest
        void should_update_item_with_given_params() throws Exception {
            ItemUpdateRequestParams params = ItemUpdateRequestParams.builder()
                    .with($ -> {
                        $.id = itemId;
                        $.isActive = isActive;
                        $.name = name;
                        $.type = type;
                        $.description = description;
                        $.price = price;
                        $.purDescription = purDescription;
                        $.taxable = taxable;
                        $.shortName = shortName;
                    }).build();

            Item item = Item.update(params);

            checkValues(item);
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Item.update(ItemUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update1 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            ItemGetRequestParams params = ItemGetRequestParams.builder()
                    .with($ -> {
                        $.id = itemId;
                    }).build();
            Item item = Item.get(params);

            item.setIsActive(isActive);
            item.setName(name);
            item.setType(type);
            item.setDescription(description);
            item.setPrice(price);
            item.setPurDescription(purDescription);
            item.setPurCost(purCost);
            item.setTaxable(taxable);
            item.setShortName(shortName);

            item = Item.update(item);

            checkValues(item);
        }
    }

    void checkValues(Item item) {
        assertAll(() -> {
           assertEquals(isActive, item.getIsActive());
           assertEquals(name, item.getName());
           assertEquals(type, item.getType());
           assertEquals(description, item.getDescription());
           assertEquals(price, item.getPrice());
           assertEquals(purDescription, item.getPurDescription());
           assertEquals(taxable, item.getTaxable());
           assertEquals(shortName, item.getShortName());
        });
    }
}