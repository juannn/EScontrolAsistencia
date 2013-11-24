package com.example.proyectoandroid;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ControlPersonal extends Activity {

	private TextView lblPersonas;
	
	
	String NAMESPACE="http://juan.org/";
	String URL="http://192.168.173.1/android/Android.asmx";
	String METHOD_NAME="VerCodigo";
	String SOAP_ACTION="http://juan.org/VerCodigo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control_personal);
		
		configureButtonReader(); 
		
		}

		private <QrReaderActity> void configureButtonReader() {  
		        final ImageButton buttonReader = (ImageButton)findViewById(R.id.btCodigo);  
		        buttonReader.setOnClickListener(new View.OnClickListener() {  
		            @Override  
		            public void onClick(View view) { 
		//cambiar Variable para probar en electiva con emulador
		reconocerPersona(1);
		            	  new IntentIntegrator(ControlPersonal.this).initiateScan(); 
		            	
		            }  
		        });  
		    }
		   
		   @Override  
		    public void onActivityResult(int requestCode, int resultCode, Intent intent) {  
		        final IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);  
		        handleResult(scanResult);  
		    }
		   
		    private void handleResult(IntentResult scanResult) {  
		        if (scanResult != null) {  
		            updateUITextViews(scanResult.getContents(), scanResult.getFormatName());  
		        } else {  
		            Toast.makeText(this, "No se ha leído nada :(", Toast.LENGTH_SHORT).show();  
		        }  
		    }  
		    
		    private void updateUITextViews(String scan_result, String scan_result_format) {  
		        ((TextView)findViewById(R.id.tvFormat)).setText(scan_result_format);  
		        final TextView tvResult = (TextView)findViewById(R.id.tvResult);  
		        tvResult.setText(scan_result);  
		        Linkify.addLinks(tvResult, Linkify.ALL); 
		        
		       int id=tvResult.getInputType();
		      //cambiar Variable para probar en electiva con celular
		        reconocerPersona(id);
		    }
	
		
	private void reconocerPersona(int id) {
				// TODO Auto-generated method stub
		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("id",id);


		SoapSerializationEnvelope envelope =
			    new SoapSerializationEnvelope(SoapEnvelope.VER11);
			 
			envelope.dotNet = true;
			 
			envelope.setOutputSoapObject(request);

			HttpTransportSE transporte = new HttpTransportSE(URL);
			lblPersonas=(TextView)findViewById(R.id.lblContenido);
			 
			try
			{
			    transporte.call(SOAP_ACTION, envelope);
			    SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
				String res = resultado_xml.toString();
				 
				   lblPersonas.setText(res); 
			 
			}
			catch (Exception e)
			{
			    lblPersonas.setText("Error!");
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.control_personal, menu);
		return true;
	}

}
