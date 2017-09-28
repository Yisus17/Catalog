package com.jesus.test.catalog.models.appModel;


import com.google.gson.annotations.SerializedName;

/**
 * Created by jaas1 on 9/27/2017.
 */

public class Id {
    private String label;
    private Attributes attributes;

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

    private class Attributes {
        @SerializedName("im:id")
        private String imId;

        @SerializedName("im:bundleId")
        private String imBundleId;

        public String getImId() {
            return imId;
        }

        public void setImId(String imId) {
            this.imId = imId;
        }

        public String getImBundleId() {
            return imBundleId;
        }

        public void setImBundleId(String imBundleId) {
            this.imBundleId = imBundleId;
        }
    }
}
