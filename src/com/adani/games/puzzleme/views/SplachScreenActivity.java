package com.adani.games.puzzleme.views;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.R.anim;
import com.adani.games.puzzleme.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplachScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splach_screen);
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				finish();
				Intent intent = new Intent(SplachScreenActivity.this, MainMenuActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}

		}, 3000);
	}
}
