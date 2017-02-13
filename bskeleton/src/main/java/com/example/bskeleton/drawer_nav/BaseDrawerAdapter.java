package com.example.bskeleton.drawer_nav;

import android.view.View;

import com.example.bskeleton.android.recyclers.BaseAdapter;

import java.util.List;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-03
 */

public abstract class BaseDrawerAdapter<I extends BaseDrawerItem, V extends View> extends BaseAdapter<I, V> {
    private static final String TAG = "BaseDrawerAdapter";

    protected int selectedTabId;

    public void setDrawerAdapterData(List<I> items, @DrawerUtils.DrawerTab int selectedTabId) {
        setDataSet(items);
        this.selectedTabId = selectedTabId;
    }

    public void setSelectedTabId(@DrawerUtils.DrawerTab int selectedTabId) {
        this.selectedTabId = selectedTabId;
        notifyDataSetChanged();
    }
}