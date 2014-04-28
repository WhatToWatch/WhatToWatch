package com.example.myfirstapp;

public class Administrateur extends Utilisateur{
	
	public Administrateur(String pseudo , String motdepasse){
		super(pseudo, motdepasse);
	}
	
	public boolean accepteFilm(Film film){
		film.accepet();
		return true;
	}
	
	public boolean accepteMotCle(Motcle mot){
		mot.accepet();
		return true;
	}
}
