package com.example.maplocation;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity {
 
	private final String TAG = "MapLocation";
    @Override
    
    // First Method which is called when activity launched anew.
    // Start of the existential life time of the activity.
    // Usual Flow : 
    // 1. Restore previous saved state
    // 2. Set the view 
    // 3. Get references to useful view elements
    // 4. Configure them (Attach Listeners etc.)
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// Restoring the saved instance state
        super.onCreate(savedInstanceState);
        
        // Setting content view to the layout
        setContentView(R.layout.activity_main);
        
        // Getting Button View
        final EditText addressField = (EditText) findViewById(R.id.address_field);
        final Button submitButton = (Button) findViewById(R.id.submit_button);

        // Attaching listener to the button
        submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					//Extract datqa from address field
					String address = addressField.getText().toString();
					// Create an intent with address data and action of ACTION_VIEW
					address = address.replace(' ','+');
					Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW,
											Uri.parse("geo:0,0?q=" + address));
					// Start an Activity that has this intent filter.
					startActivity(geoIntent);
				}catch(Exception e){
					Log.e(TAG,e.toString());
				}
			}
		});
        
    }
    // Called when activity is being started after being stopped
    // Special processing required after activity has been stopped
    // and being restarted again should be done in this step.
    @Override
    protected void onRestart(){
    	super.onRestart();
    	Log.i(TAG,"The activity has been restarted");
    }
    // Start of the visible lifetime of the activity
    // Typically start the ON VISIBLE ONLY behavior
    @Override
    protected void onStart(){
    	super.onStart();
    	Log.i(TAG,"The activity has been started");
    }
    
    // Start of the interactive lifetime of the activity
    // Typically start ON INTERACTIVE/FOREGROUND ONLY behavior
    // Load persistent state
    @Override
    protected void onResume(){
    	super.onResume();
    	Log.i(TAG,"The activity is now interactive (resumed state)");
    }
    
    // End of the interactive lifetime of the activity
    // Shut down any ON INTERACTIVE/FOREGROUND ONLY behavior
    // Save persistent state
    @Override
    protected void onPause(){
    	super.onPause();
    	Log.i(TAG,"The activity is not interactive (paused state)");
    }
    
    // End of visible lifetime of the activity
    // Shut down any ON VISIBLY ONLY behavior
    // Cache state. 
    // Note : May NOT be called. Best Cache state in onPause only - 
    @Override
    protected void onStop(){
    	super.onStop();
    	Log.i(TAG,"The activity has been stopped");
    }
    
    // End of the existential lifetime of the activity
    // Typically release any special resources you have occupied
    // Note : May NOT be called. Best Release resources in onPause
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	Log.i(TAG,"The activity is being destroyed");
    }
   
}
