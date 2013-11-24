package com.example.proyectoandroid;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMiembro extends Activity {

	private Button btnAceptar;
	
	String NAMESPACE="http://juan.org/";
	String URL="http://192.168.200.158/SWcontrol/ServicioClientes.asmx";
	String METHOD_NAME="NuevoMiembro";
	String SOAP_ACTION="http://juan.org/NuevoMiembro";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_miembro);
		
		btnAceptar=(Button)findViewById(R.id.btnAcept);
		
		btnAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText nom=(EditText)findViewById(R.id.txtnom);
				EditText ape=(EditText)findViewById(R.id.txtApe);
				EditText fechaNac=(EditText)findViewById(R.id.txtFecNa);
				EditText fechaRegis=(EditText)findViewById(R.id.txtFeReg);
				EditText contac=(EditText)findViewById(R.id.txtCont);
				EditText domi=(EditText)findViewById(R.id.txtDomi);
				EditText descrip=(EditText)findViewById(R.id.txtDes);
				
				String nombre=nom.getText().toString();
				String apellido=ape.getText().toString();
				String fechaNacimiento=fechaNac.getText().toString();
				String fechaRegistro=fechaRegis.getText().toString();
				String contacto=contac.getText().toString();
				String domicilio=domi.getText().toString();
				String descripcion=descrip.getText().toString();
				
				
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

				request.addProperty("nombre",nombre);
				request.addProperty("apellido",apellido);
				request.addProperty("fechaNacimiento",fechaNacimiento);
				request.addProperty("fechaRegistro",fechaRegistro);
				request.addProperty("contacto",contacto);
				request.addProperty("descripcion",descripcion);
				request.addProperty("domicilio",domicilio);
				request.addProperty("idClase",2);

				SoapSerializationEnvelope envelope =
					    new SoapSerializationEnvelope(SoapEnvelope.VER11);
					 
					envelope.dotNet = true;
					envelope.setOutputSoapObject(request);
					HttpTransportSE transporte = new HttpTransportSE(URL);
					
					try
					{
					    transporte.call(SOAP_ACTION, envelope);
					    SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
						String res = resultado_xml.toString();
						 
						Toast.makeText(getApplication(),res,Toast.LENGTH_LONG).show();
					 
					}
					catch (Exception e)
					{
						Toast.makeText(getApplication(),"Error!",Toast.LENGTH_LONG).show();
						 
					}
				
				
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_miembro, menu);
		return true;
	}

}
