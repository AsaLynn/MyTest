package com.zxn.mytest;

import android.app.Application;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

public class MyApplication extends Application {

    private DbManager db;

    public DbManager getDb() {
        return db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initMap();
        initFresco();
        initXUtils();
        initMob();
    }

    private void initMob() {
        MobSDK.init(this);
    }

    private void initXUtils() {
        x.Ext.init(this);
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //设置数据库名，默认xutils.db
                .setDbName("mytest.db")
                //设置数据库的版本号
                .setDbVersion(1)
                //设置数据库打开的监听
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                //设置数据库更新的监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    }
                })
                //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table) {
                        Log.i("MyApplication", "onTableCreated：--->" + table.getName());
                    }
                });
        //设置是否允许事务，默认true
        //.setAllowTransaction(true)
        db = x.getDb(daoConfig);
    }

    private void initFresco() {

        Fresco.initialize(this);
    }

    private void initMap() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }
}
