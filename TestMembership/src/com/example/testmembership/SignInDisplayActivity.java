package com.example.testmembership;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInDisplayActivity extends Activity {
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";


	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_display);
        final EditText pseudo = (EditText) findViewById(R.id.user_pseudo);
        final EditText age = (EditText) findViewById(R.id.user_age);
        final EditText email = (EditText) findViewById(R.id.user_email);
	    final EditText pass = (EditText) findViewById(R.id.user_password);
	    final Button signinButton = (Button) findViewById(R.id.create_account);
		final Context context = this;




	    signinButton.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View v) {
	    	final String loginTxt = email.getText().toString();
	    	final String passTxt = pass.getText().toString();
	    	final int ageText = Integer.parseInt(age.getText().toString());
	    	final String pseudoText = pseudo.getText().toString();

    		//Si un des deux champs est vide, alors on affiche l'erreurs

	    	if (loginTxt.equals("") || passTxt.equals("")) {
	    		Toast.makeText(SignInDisplayActivity.this,R.string.email_or_password_empty,
	    		Toast.LENGTH_SHORT).show();
	    		return;
	    	}

	    	// On d�clare le pattern que l�on doit v�rifier
	    	Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	    	// On d�clare un matcher, qui comparera le pattern avec la
	    	// string pass�e en argument
	    	Matcher m = p.matcher(loginTxt);
	    	// Si l�adresse mail saisie ne correspond au format d�une
	    	// adresse mail on un affiche un message � l'utilisateur
	    	if (!m.matches()) 
	    	{
	    	        // Toast est une classe fournie par le SDK Android
	    		// pour afficher les messages (indications) � l'intention de   
	                    // l'utilisateur. Ces messages ne poss�dent pas d'interaction avec l'utilisateur
	    		// Le premier argument repr�sente le contexte, puis
	    		// le message et � la fin la dur�e d'affichage du Toast (constante 
	                    // LENGTH_SHORT ou LENGTH_LONG). Sans oublier d'appeler la m�thode
	                    //show pour afficher le Toast
	    		Toast.makeText(SignInDisplayActivity.this, R.string.email_format_error,
	    	        Toast.LENGTH_SHORT).show();
	    			return;
	    	}
	    	
	    	//Cr�ation d'une instance de ma classe LivresBDD
		    UtilisateursBDD utilisateurBdd = new UtilisateursBDD(context);

	 
	        //Cr�ation d'un livre
	    	Utilisateur utilisateur = new Utilisateur(ageText, pseudoText, loginTxt);
	 
	        //On ouvre la base de donn�es pour �crire dedans
	        utilisateurBdd.open();
	        //utilisateurBdd.insertUtilisateur(utilisateur);
	        
	        Utilisateur utilisateurFromBdd = utilisateurBdd.getUtilisateurWithPseudo(utilisateur.getPseudo());
	        //Si un livre est retourn� (donc si le livre � bien �t� ajout� � la BDD)
	        if(utilisateurFromBdd != null){
	        	//On affiche les infos du livre dans un Toast
	        	Toast.makeText(context, "Ce pseudo existe d�j�!", Toast.LENGTH_LONG).show();
	        	
	        }
	        else
	        {
	        	//On ins�re le livre que l'on vient de cr�er
	        	utilisateurBdd.insertUtilisateur(utilisateur);
	        	utilisateurBdd.close();

	    		Intent intent = new Intent(SignInDisplayActivity.this,LoginDisplayActivity.class);
	    		intent.putExtra(EXTRA_LOGIN, loginTxt);
	    		intent.putExtra(EXTRA_PASSWORD, passTxt);
	    		startActivity(intent);
	        }
	    }});
       
    }
}