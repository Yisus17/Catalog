package com.jesus.test.catalog.models;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by jaas1 on 9/27/2017.
 */

public class Feed {

    private ArrayList<App> entry;

    public ArrayList<App> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<App> entry) {
        this.entry = entry;
    }
}
