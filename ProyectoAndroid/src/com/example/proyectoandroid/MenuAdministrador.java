package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuAdministrador extends Activity {

   private ImageView imgControlAsistencia,imgMenuUsuario,imgMiembro;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_administrador);
		
		imgControlAsistencia=(ImageView)findViewById(R.id.imgAsistencia);
		imgMenuUsuario=(ImageView)findViewById(R.id.imgUsuario);
		imgMiembro=(ImageView)findViewById(R.id.imgMiembros);
		
		
		imgMiembro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inten=new Intent();
				inten.setClass(MenuAdministrador.this,AddMiembro.class);
				startActivity(inten);
			}
		});
		
		imgMenuUsuario.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inten=new Intent();
				inten.setClass(MenuAdministrador.this,AddUsuario.class);
				startActivity(inten);
			}
		});
		
		imgControlAsistencia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inten=new Intent();
				inten.setClass(MenuAdministrador.this,ControlPersonal.class);
				startActivity(inten);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_administrador, menu);
		return true;
	}

}
