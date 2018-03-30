package com.example.user06.serveraidlservice;

import android.os.RemoteException;

import com.example.aidllib.ISimpleAidlInterface;

/**
 * Created by Anjan Debnath on 3/30/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class SimpleServiceImpl extends ISimpleAidlInterface.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a-b;
    }
}
