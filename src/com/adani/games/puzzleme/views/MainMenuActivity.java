package com.adani.games.puzzleme.views;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.util.Debuggable;

public class MainMenuActivity extends Activity implements Debuggable {

	public static final String TAG = MainMenuActivity.class.getSimpleName();

	boolean pressed = false;
	ImageButton imgBtnPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main_menu);
		configureComponents();
		print("Main Menu Started...");
	}

	private void configureComponents(){
		imgBtnPlay = (ImageButton) findViewById(R.id.imgBtnPlay);
		imgBtnPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainMenuActivity.this.finish();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		print("Resuming Activity");
	}
	@Override
	protected void onPause() {
		super.onPause();
		print("Pausing Activity");
	}
	@Override
	protected void onStop() {
		super.onStop();
		print("Stoping Activity");
	}


	public void print(String message) {
		Log.d(DEBUG, TAG + ":" +  message);
	}
	

}
