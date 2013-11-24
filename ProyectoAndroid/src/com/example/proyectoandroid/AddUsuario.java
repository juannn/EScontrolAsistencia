package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class AddUsuario extends Activity {

	private CheckBox checkAdmin,checkLider;
	private Button btnAceptar,btnCancelar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_usuario);
		
		   checkLider=(CheckBox)findViewById(R.id.checkLider);
		    checkAdmin=(CheckBox)findViewById(R.id.checkAdministrador);
		   	
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
	
	public void Aceptar(View Buttton)
	{
		  EditText nomUsua=(EditText)findViewById(R.id.txtnom);
		  EditText pass=(EditText)findViewById(R.id.txtPassword);
		  EditText nom=(EditText)findViewById(R.id.txtNombres);
		  EditText ape=(EditText)findViewById(R.id.txtApellidos);
		  EditText descrip=(EditText)findViewById(R.id.txtDescripcion);
		  EditText fechaNaci=(EditText)findViewById(R.id.txtFechaNacimiento);
		  EditText fechaRegis=(EditText)findViewById(R.id.FechaRegistro);		 
		  EditText contac=(EditText)findViewById(R.id.txtContacto);
		  EditText domici=(EditText)findViewById(R.id.txtDomicilio);
		
		  String nombreUsuario=nomUsua.getText().toString();
		  String password=pass.getText().toString();
		  String nombres=nom.getText().toString();
		  String apellidos=ape.getText().toString();
		  String descripcion=descrip.getText().toString();
		  String fechaNacimiento=fechaNaci.getText().toString();
		  String fechaRegistro=fechaRegis.getText().toString();
		  String contacto=contac.getText().toString();
		  String domicilio=domici.getText().toString();
		  
		  
		  String agregarUsuario="";
		  
		  if(nombreUsuario.trim().equals("")||password.trim().equals("")||
				  nombres.trim().equals("")||apellidos.trim().equals("")||
				  descripcion.trim().equals("")||fechaNacimiento.trim().equals("")||
				  fechaRegistro.trim().equals("")||contacto.trim().equals("")||
				  domicilio.trim().equals("")){
			  
				Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_LONG).show();  	 	  
		  }
	else{ 
		  if(checkAdmin.isChecked()==false && checkLider.isChecked()==false){
			Toast.makeText(this,"Seleccione un Rol",Toast.LENGTH_LONG).show();  
		 
		  }
		  else{
			  if(checkAdmin.isChecked()==true){
			   //agregarUsuario=sql.nuevoUsuario(nombreUsuario,password,nombres,apellidos,descripcion,fechaNacimiento,fechaRegistro,contacto,domicilio,1);
			   }
			  if(checkLider.isChecked()==true){
			  // agregarUsuario=sql.nuevoUsuario(nombreUsuario,password,nombres,apellidos,descripcion,fechaNacimiento,fechaRegistro,contacto,domicilio,2);
			  }
			  
			  Toast.makeText(this,agregarUsuario,Toast.LENGTH_LONG).show();
		  }
	   }
	}
	public void Cancelar(View Button){	
		
	  EditText nomUsua=(EditText)findViewById(R.id.txtnom);
	  EditText pass=(EditText)findViewById(R.id.txtPassword);
	  EditText nom=(EditText)findViewById(R.id.txtNombres);
	  EditText ape=(EditText)findViewById(R.id.txtApellidos);
	  EditText descrip=(EditText)findViewById(R.id.txtDescripcion);
	  EditText fechaNaci=(EditText)findViewById(R.id.txtFechaNacimiento);
	  EditText fechaRegis=(EditText)findViewById(R.id.FechaRegistro);		 
	  EditText contac=(EditText)findViewById(R.id.txtContacto);
	  EditText domici=(EditText)findViewById(R.id.txtDomicilio);
	  
	 nomUsua.setText("");
	  pass.setText("");
	  nom.setText("");
	  ape.setText("");
	  descrip.setText("");
	  fechaNaci.setText("");
	  fechaRegis.setText("");
	  contac.setText("");
	  domici.setText("");
	  
	  checkAdmin.setChecked(false);
	  checkLider.setChecked(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_usuario, menu);
		return true;
	}

}
