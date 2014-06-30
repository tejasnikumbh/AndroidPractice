package com.example.theanswer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	// Some Instance Variables
	private int[] answers = {42,23,-5,0,100};
	private int answer = 42;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// Restoring saved bundle state
        super.onCreate(savedInstanceState);
        // Setting content view to the layout
        setContentView(R.layout.activity_main);
        
        // Getting reference to the view
        TextView answerHolder = (TextView) findViewById(R.id.the_answer);
        
        // Manipulating according to the logic
        int val = findAnswer();
        
        String answerText = (val == answer)?"42":"We may never know";
        answerHolder.setText("The answer to everything is : " + answerText);
       
    }

    private int findAnswer(){
    	for(int val:answers){
    		if(val==42)
    			return 42;
    	}
    	return -1;
    }	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
