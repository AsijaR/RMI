/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekatrmi;

import java.io.Serializable;

/**
 *
 * @author Asija
 */
public class Korisnik implements Serializable {
	public String brojRacuna,Ime,Prezime;
	public int Stanje;
        
	Korisnik(String s1, String s2, String s3,int i){
		this.Ime = s1;
		this.Prezime = s2;
		this.brojRacuna = s3;
		this.Stanje = i;
	}
	Korisnik(){}
	public void setBrRacuna(String brR) {this.brojRacuna=brR;}
	public String getBrRacuna() {return this.brojRacuna;}
	
	public void setIme(String i) {this.Ime=i;}
	public String getIme() {return this.Ime;}
	
	public void setPrezime(String p) {this.Prezime=p;}
	public String getPrezime() {return this.Prezime;}
	
	public void setStanje(int s) {this.Stanje=s;}
	public int getStanje() {return this.Stanje;}

}