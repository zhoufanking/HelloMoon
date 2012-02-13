package com.hellomoon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AuthActivity extends Activity {
    /** Called when the activity is first created. */
	Button Authbtn = null;
	TextView tv = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);
        
        tv = (TextView) findViewById(R.id.title);
        Authbtn = (Button) findViewById(R.id.AuthButton);
        Authbtn.setOnClickListener(new AuthClickListener());
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 1, R.string.exit);
		menu.add(0,1,2,R.string.about);
		menu.add(0,1,3,"hello");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == 1)
			finish();
		return super.onMenuItemSelected(featureId, item);
	}
    
    class AuthClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent aIntent = new Intent();
			aIntent.setClass(AuthActivity.this, MainFrm.class);
			aIntent.putExtra("user", "zhoufan");
			AuthActivity.this.startActivity(aIntent);
			
		}
    	
    }
}