package com.example.myfirstapp;



public class Utilisateur {
	String pseudo;
	String motdepasse;
	int age;
	char sexe;
	String adressemail;
	String[] genre;
	Film[] vue;
	Film[] envie;
	
	private int nvue;
	private int nenvie;
	private int ngenre;
	
	private int maxvue = 100;
	private int maxenvie = 100;
	private int maxgenre = 100;
	
	public Utilisateur(String pseudo , String motdepasse){
		this.pseudo=pseudo;
		this.motdepasse=motdepasse;
		vue = new Film[maxvue];
		envie= new Film[maxenvie];
		genre = new String[maxgenre];
		nvue=0;
		nenvie=0;
		ngenre=0;
		upDateFromDB();
	}
	
	public void changeAge(int age){
		this.age=age;
	}
	
	
	public void changeSexe(char s){
		this.sexe=s;
	}
	
	public void changeEmail(String newAdd){
		this.adressemail=newAdd;
	}
	
	private void upDateFromDB(){
		
	}
	
	public void suggereToUtilisateur(){
			
	}
	
	public void proposeFilm(){
			
	}
	
	public void modifieProfile(){
		
	}
	
	public void coteFilm(){
		
	}
	
	public void envoieMailMDP(){
		
	}
	
	public void AddEvalToList(){
		
	}
	
	public void addSuggestion(){
		
	}
	
	public void pushEval(){
		
	}
	
	public void SuggereToUtilisateur(){
		
	}
	
	public void Suggest(){
		
	}
	
	public void SeeFilm(Film film){
		vue[nvue]=film;
		nvue++;
	}
	
	public void addEnvie(Film film){
		envie[nenvie]=film;
		nenvie++;
	}
	
	public void addGenre(String genre){
		this.genre[ngenre]=genre;
		ngenre++;
	}
}
