package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class NuevoUsuario extends Activity {

	private CheckBox checkAdmin,checkLider;
	private Button btnAceptar,btnCancelar;
//	BaseDeDatos sql =new BaseDeDatos(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_usuario);
		
    checkLider=(CheckBox)findViewById(R.id.checkLider);
    checkAdmin=(CheckBox)findViewById(R.id.checkAdministrador);
   	btnAceptar=(Button)findViewById(R.id.btnAceptar);
   	
   	btnAceptar.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//String res=sql.ListaRol();
			//Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
		}
	});
	
	checkLider.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			checkAdmin.setChecked(false);
			
		}
	});
	
	checkAdmin.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			
			  checkLider.setChecked(false);
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nuevo_usuario, menu);
		return true;
	}

}
