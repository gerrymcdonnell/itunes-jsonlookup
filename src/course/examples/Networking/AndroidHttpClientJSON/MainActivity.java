package course.examples.Networking.AndroidHttpClientJSON;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private static final String TAG = "CA2";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		final int RETURN_CODE=0;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		final Button loadButton = (Button) findViewById(R.id.btnSearch);
		loadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//get textbox value
				EditText txt= (EditText)findViewById(R.id.txtSearch);
				String sSearch=txt.getText().toString();				
				
				//existing
				//startActivity(new Intent(MainActivity.this,NetworkingJSONActivity.class));
				
				Intent i=new Intent(MainActivity.this,NetworkingJSONActivity.class);				
				i.putExtra("sSearch", sSearch);
				startActivity(i);
				
				
				//start actrivity and get data back
				/*
				Intent i=new Intent(getBaseContext(), NetworkingAndroidHttpClientJSONActivity.class);
				startActivityForResult(i, RETURN_CODE);				
				*/
			}
		});
		
		
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i(TAG,"Entered onActivityResult()");
		
		
		
		if (resultCode == RESULT_OK)
		{
			//get the data inputted and put into a todoitem
			//ToDoItem item = new ToDoItem(data);
			//mAdapter.add(item); 
		}
		

	}
}