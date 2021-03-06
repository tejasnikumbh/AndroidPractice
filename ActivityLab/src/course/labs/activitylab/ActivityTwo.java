package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
	private static int mCreate;
	private static int mStart;
	private static int mResume;
	private static int mRestart;

	// View references
	private static TextView mTvCreate;
	private static TextView mTvStart;
	private static TextView mTvResume;
	private static TextView mTvRestart;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Getting references to view elements
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);	
			
		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
			mCreate = savedInstanceState.getInt("mCreateCounts");
			mStart = savedInstanceState.getInt("mStartCounts");
			mRestart = savedInstanceState.getInt("mRestartCounts");
			mResume = savedInstanceState.getInt("mResumeCounts");
		}


		// Logging method
		Log.i(TAG,"Activity Two Created");

		// Updating the correspoonding variable for method
		mCreate += 1;
		
		// Updating the UI
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "Activity Two being made visible to the user");
		
		// Updating the variable
		mStart += 1;
		
		// Displaying relevant counts
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		super.onResume();
		Log.i(TAG,"Starting foreground only behaviors for Activity Two");
		
		mResume += 1;
		
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG,"Dismissing foreground only behaviors");
		
	

	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG,"Activity being made invisible. Stopping visible only behavior");


	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG,"Doing any processing necessary oly after stoppping of activity");
		
		mRestart += 1;
		
		displayCounts();


	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt("mCreateCounts",mCreate);
		savedInstanceState.putInt("mStartCounts",mStart);
		savedInstanceState.putInt("mRestartCounts",mRestart);
		savedInstanceState.putInt("mResumeCounts",mResume);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
