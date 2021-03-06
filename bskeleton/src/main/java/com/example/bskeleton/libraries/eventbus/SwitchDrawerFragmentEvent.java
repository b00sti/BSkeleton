package com.example.bskeleton.libraries.eventbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.bskeleton.drawer_nav.DrawerUtils;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-03
 */

@SuppressWarnings("unused")
public class SwitchDrawerFragmentEvent {

    @DrawerUtils.DrawerTab private int drawerSelectedTabId = DrawerUtils.TAB_NO;
    private Fragment targetFragment;
    private Fragment topTargetFragment;
    private Bundle extras;

    public SwitchDrawerFragmentEvent(Fragment targetFragment, @DrawerUtils.DrawerTab int drawerSelectedTabId) {
        this.targetFragment = targetFragment;
        this.drawerSelectedTabId = drawerSelectedTabId;
    }

    public SwitchDrawerFragmentEvent(Fragment targetFragment, @DrawerUtils.DrawerTab int drawerSelectedTabId, Bundle extras) {
        this.targetFragment = targetFragment;
        this.drawerSelectedTabId = drawerSelectedTabId;
        this.extras = extras;
    }

    public SwitchDrawerFragmentEvent(@DrawerUtils.DrawerTab int drawerSelectedTabId, Fragment targetFragment, Fragment topTargetFragment) {
        this.drawerSelectedTabId = drawerSelectedTabId;
        this.targetFragment = targetFragment;
        this.topTargetFragment = topTargetFragment;
    }

    public Fragment getTopTargetFragment() {
        return topTargetFragment;
    }

    public void setTopTargetFragment(Fragment topTargetFragment) {
        this.topTargetFragment = topTargetFragment;
    }

    public Fragment getTargetFragment() {
        return targetFragment;
    }

    @DrawerUtils.DrawerTab
    public int getDrawerItemSelected() {
        return drawerSelectedTabId;
    }

    public Bundle getExtras() {
        return extras;
    }
}
