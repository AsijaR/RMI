/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
 import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asija
 */
public class BankomatMetode extends UnicastRemoteObject implements Interfejs{
        Korisnik k;
        
   public BankomatMetode() throws RemoteException {
        super();
        k = new Korisnik("Asija","Ramovic","8880",500);
        System.out.println("Dodat je novi korisnik, konektovani ste na server");
    }


			
  @Override
    public int Uplati(Korisnik k, int uplata) throws RemoteException {
     return k.Stanje+=uplata;
    }

    @Override
    public int Isplati(Korisnik k, int isplata) throws RemoteException {
         return k.Stanje-=isplata;
    }
    
    @Override public Korisnik getKorisnik() throws RemoteException{
        return this.k;
    }
	
}
