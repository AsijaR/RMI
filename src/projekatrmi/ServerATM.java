/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekatrmi;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 *
 * @author Asija
 */
public class ServerATM {
     public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {
            BankomatMetode bm= new BankomatMetode();
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(2000);
           r.rebind("BankomatMetode", bm);
            System.out.println("SERVER se pokrenuo, ceka se korisnik");
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
}
