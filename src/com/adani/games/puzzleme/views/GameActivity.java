package com.adani.games.puzzleme.views;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.models.Game;

public class GameActivity extends Activity implements SensorEventListener {
	
	public static final String TAG = GameActivity.class.getSimpleName();
	
	private Sensor accelerometer;
	private SensorManager sm;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_game);
		
		initialiseSensorManager();
	}

	private void initialiseSensorManager(){
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
	}
	
	
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}
	@Override
	public void onSensorChanged(SensorEvent event) {
		if(Game.getInstance()!= null){
			Game.getInstance().updateBallCoordinates(event.values);
		}
	}	
}
