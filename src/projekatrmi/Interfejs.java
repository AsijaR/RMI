/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekatrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
 import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Asija
 */
public interface Interfejs extends Remote{
      public Korisnik getKorisnik() throws RemoteException;
      public int Uplati(Korisnik k, int uplata) throws RemoteException;
      public int Isplati(Korisnik k, int isplata) throws RemoteException;
}
