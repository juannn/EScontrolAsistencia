package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
//import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnAceptar,btnCancelar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAceptar=(Button)findViewById(R.id.btnAceptar);
		btnCancelar=(Button)findViewById(R.id.btnCancelar);
		
btnCancelar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText nom=(EditText)findViewById(R.id.txtNombreUsuario);
				EditText pas=(EditText)findViewById(R.id.txtPass);

			nom.setText("");
			pas.setText("");
			
			
			}
		});
		
		btnAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText nom=(EditText)findViewById(R.id.txtNombreUsuario);
				EditText pas=(EditText)findViewById(R.id.txtPass);
			String nombreUsuario=nom.getText().toString();
			String password=pas.getText().toString();
			
			
			
			if(nombreUsuario.equals("Juan")||password.equals("123456")){
            
			Builder dialog=new Builder(MainActivity.this);
	        dialog.setTitle("Mensaje");
	        dialog.setMessage("Bienvenido\nSeñor Administrador");
	        dialog.setNeutralButton("Aceptar", null);
	        dialog.show();
			
	        nom.setText("");
			pas.setText("");
	        
			Intent inten=new Intent();
			inten.setClass(MainActivity.this,MenuAdministrador.class);
			startActivity(inten);
			}
			else{		

				Builder dialog=new Builder(MainActivity.this);
	            dialog.setTitle("Error!");
	            dialog.setMessage("El usuario no existe \npara mas informacion Comunicarse \ncon el Administrador");
	            dialog.setNeutralButton("ok", null);
	            dialog.show();
			}
			
			

			}
		});
		
	}

	  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
