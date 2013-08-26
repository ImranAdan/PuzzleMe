package com.adani.games.puzzleme.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.adani.games.puzzleme.R;

/**
 * Level Select Activity. 
 * 
 * @author Imran Adan
 * @version 0.0.1
 */
public class LevelSelectActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_select);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_select, menu);
		return true;
	}

}
