package com.hellomoon;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFrm extends Activity {

//	private LinearLayout LLayout;
	
	Timer t = new Timer();
	private TextView tv = null;
	//private Button btn = null;
	
	int i = 0;
	
	private Handler timerHandler = new Handler(){
		public void handleMessage(Message msg)
		{
			if( i > 3){
				i = 0;
			}else
			{
			
			switch(msg.what){
			case 0:
				tv.setBackgroundColor(Color.BLUE);
				break;
			case 1:
				tv.setBackgroundColor(Color.GREEN);
				break;
			case 2:
				tv.setBackgroundColor(Color.RED);
				break;
			case 3:
				tv.setBackgroundColor(Color.WHITE);
				break;
			default:
					tv.setBackgroundColor(Color.YELLOW);
					break;
			}
			
			tv.invalidate();		
			}
			
		super.handleMessage(msg);
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,1,1,R.string.exit);
		menu.add(0,1,2,"return");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getOrder() == 1)
		{
			moveTaskToBack(true);
		}
		else
		{
			MainFrm.this.startActivity(new Intent(MainFrm.this, AuthActivity.class));
			
		}
		return super.onMenuItemSelected(featureId, item);
	}


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
		                      WindowManager.LayoutParams. FLAG_FULLSCREEN);
		
		setContentView(R.layout.mainfrm);
		
//		Intent intent = getIntent();
//		String un = intent.getStringExtra("user");		
		tv = (TextView) findViewById(R.id.mainTV);		
		tv.setBackgroundColor(Color.YELLOW);
//		
//		tv.setText(un);
		initView();
		//btn = (Button) findViewById(R.id.SHOWBUTTON);
		//btn.setText("a button");
	}
	
	private void initView(){
		t.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				i++;  
                Message mesasge = new Message();  
                mesasge.what = i;  
                timerHandler.sendMessage(mesasge); 				
			}		
			
		}, 0, 500);
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		t.cancel();
		super.onDestroy();
	}
	
	
	
}
