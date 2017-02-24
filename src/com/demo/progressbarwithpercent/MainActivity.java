package com.demo.progressbarwithpercent;

import java.util.Timer;
import java.util.TimerTask;

import com.demo.progressbarwithpercent.view.OnProgressBarListener;
import com.demo.progressbarwithpercent.view.ProgressBarWithPercent;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements OnProgressBarListener {

	private Timer timer;
	private ProgressBarWithPercent progressBarWithPercent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBarWithPercent = (ProgressBarWithPercent) findViewById(R.id.progressBarWithPercent);
		progressBarWithPercent.setOnProgressBarListener(this);
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						progressBarWithPercent.incrementProgressBy(1);
					}
				});
			}
		}, 1000, 100);
	}

	@Override
	public void onProgressChange(int current, int max) {
		if (current == max) {
			progressBarWithPercent.setProgress(0);
		}
	}

}
