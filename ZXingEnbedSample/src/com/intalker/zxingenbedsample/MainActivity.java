package com.intalker.zxingenbedsample;


import com.google.zxing.client.android.Intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	public final static int scan_result_code = 1000;
	
	private TextView mScanResultTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mScanResultTextView = (TextView) findViewById(R.id.scanResultTextView);
        
        Button btn = (Button) findViewById(R.id.scanButton);
        btn.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				//Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
				//intent.setAction("com.intalker.SCAN");
				//com.google.zxing.client.android.SCAN
				Intent intent = new Intent(Intents.Scan.ACTION);
				try
				{
					MainActivity.this.startActivityForResult(intent, MainActivity.scan_result_code);
				}
				catch (Exception ex)
				{
					ex = null;
				}
			}
		});
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == scan_result_code) {
			switch (resultCode) {
			case RESULT_OK:
				String result = data.getStringExtra("SCAN_RESULT");
				
				mScanResultTextView.setText("Scan Result:\n" + result);
				break;
			case RESULT_CANCELED:
				break;
			default:
				break;
			}
		}
	}
}
