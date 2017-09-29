package com.jesus.test.catalog.models.appModel;

/**
 * Created by jaas1 on 9/27/2017.
 */

public class ImPrice {
    String label;
    private Attributes attributes;

    /*****************************Getters & Setters**************************************/
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    /*****************************Atributos**************************************/
        public class Attributes {
            private String amount;
            private String currency;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }
    }
}
