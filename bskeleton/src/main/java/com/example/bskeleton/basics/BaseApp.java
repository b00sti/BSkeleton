package com.example.bskeleton.basics;

import android.app.Application;
import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-15
 */

public abstract class BaseApp<P extends RealmMigration> extends Application {
    private static final String TAG = "BaseApp";
    private static BaseApp instance;

    public static BaseApp getInstance() {
        return instance;
    }

    protected abstract RealmConfig setRealmConfigParams();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRealmConfiguration();
    }

    private void initRealmConfiguration() {
        int schemaVersion = setRealmConfigParams().getSchemaVersion();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(setRealmConfigParams().getDataBaseName() + ".realm")
                .schemaVersion(schemaVersion)
//                .deleteRealmIfMigrationNeeded()
                .migration(setRealmConfigParams().getRealmMigration())
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}

class RealmConfig<P extends RealmMigration> {
    private String dataBaseName;
    private P realmMigration;
    private int schemaVersion;

    public RealmConfig(@NonNull String dataBaseName, @NonNull P realmMigration, int schemaVersion) {
        this.dataBaseName = dataBaseName;
        this.realmMigration = realmMigration;
        this.schemaVersion = schemaVersion;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public P getRealmMigration() {
        return realmMigration;
    }

    public void setRealmMigration(P realmMigration) {
        this.realmMigration = realmMigration;
    }

    public int getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }
}
