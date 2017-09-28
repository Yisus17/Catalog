package com.jesus.test.catalog.models.appModel;

/**
 * Created by jaas1 on 9/27/2017.
 */

public class ImContentType {
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    private class Attributes {
        String term;
        String label;

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }


    }

}
