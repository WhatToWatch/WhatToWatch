package com.example.myfirstapp;

import android.R.string;

public class Cinema {
	string localite;
	string nom;
	int[] position;
	
	public Cinema(){
		
	}
	
	public Seance getSeance(){
		return new Seance();
	}
	
	public int getDistance(){
		return 42;
	}
}
