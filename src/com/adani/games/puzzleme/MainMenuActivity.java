package com.adani.games.puzzleme;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity {
	boolean pressed = false;
	private ImageButton imgBtnPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main_menu);
		
		initComponents();

	}
	
	public void onBtnPlayPressed(View v){	
	}


	/**
	 * Initialise all the components here.
	 */
	private void initComponents(){
		imgBtnPlay = (ImageButton) findViewById(R.id.btnPlay);
	}

}
