package com.example.myfirstapp;

import android.R.string;

public class Motcle {
	boolean accepte;
	Film film;
	string mot;
	
	public Motcle( string mot , Film film){
		this.film=film;
		this.mot=mot;
		this.accepte=false;
	}
	
	public void accepeter(){
		this.accepte=true;
	}
}
