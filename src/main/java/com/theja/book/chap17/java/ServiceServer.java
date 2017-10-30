package com.theja.book.chap17.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceServer extends Remote {
    Object[] getServiceList() throws RemoteException;

    Service getService(Object var1) throws RemoteException;
}
