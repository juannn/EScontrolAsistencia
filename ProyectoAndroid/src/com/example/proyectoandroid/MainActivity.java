package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		configureButtonReader(); 
		
	}

	   private <QrReaderActity> void configureButtonReader() {  
	        final ImageButton buttonReader = (ImageButton)findViewById(R.id.btReader);  
	        buttonReader.setOnClickListener(new View.OnClickListener() {  
	            @Override  
	            public void onClick(View view) {  
	            	  new IntentIntegrator(MainActivity.this).initiateScan();  
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
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
