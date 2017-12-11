package course.examples.Networking.AndroidHttpClientJSON;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import course.examples.Networking.AndroidHttpClientJSON.ITunes.ITunesRecord;
import course.examples.Networking.AndroidHttpClientJSON.ITunes.ITunesTags;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NetworkingJSONActivity extends ListActivity {
	
	private ListView mylistview;
	private static String sSearch="radiohead";
	private static final String URL = "http://itunes.apple.com/search?term=";
	private String sSearchURL="";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get passed in string data
		Intent intent = getIntent();
		sSearch = intent.getExtras().getString("sSearch");
		
		//appened search term to the string
		sSearchURL=URL+sSearch;
		
		new HttpGetTask().execute();
	}

	private class HttpGetTask extends AsyncTask<Void, Void, List<ITunesRecord>> {			
		
		AndroidHttpClient mClient = AndroidHttpClient.newInstance("");
		
		@Override
		protected List<ITunesRecord> doInBackground(Void... params) {
			
			HttpGet request = new HttpGet(sSearchURL);
			JSONResponseHandler responseHandler = new JSONResponseHandler();
			try {
				return mClient.execute(request, responseHandler);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<ITunesRecord> result) {
			if (null != mClient)
				mClient.close();			
			
	
			// Create a new ListAdapter for this ListActivity's ListView
			ITunesListAdapter mAdapter = new ITunesListAdapter(NetworkingJSONActivity.this,result);			
			mylistview= (ListView) findViewById(R.id.listView1);
			
			setListAdapter(mAdapter);

		}
	}

	private class JSONResponseHandler implements ResponseHandler<List<ITunesRecord>> {

		
		@Override
		public List<ITunesRecord> handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			List<ITunesRecord> result = new ArrayList<ITunesRecord>();
			String JSONResponse = new BasicResponseHandler()
					.handleResponse(response);
			try {

				// Get top-level JSON Object - a Map
				JSONObject responseObject = (JSONObject) new JSONTokener(
						JSONResponse).nextValue();

				// Extract value of "results" key -- a List
				JSONArray itunesrecords = responseObject
						.getJSONArray(ITunesTags.RESULTS_TAG);

				
				// Iterate over itune results list
				for (int idx = 0; idx < itunesrecords.length(); idx++) {
					
					// Get single result data - a Map
					JSONObject itunesrecord = (JSONObject) itunesrecords.get(idx);

					//*****************************************************
					//shud create new itunes record object
					ITunesRecord iRec= new ITunesRecord();
					
					//set the fields and add to arraylist
					iRec.setsArtist(itunesrecord.get(ITunesTags.artistName).toString());
					iRec.setsAlbum(itunesrecord.get(ITunesTags.collectionName).toString());
					iRec.setsGenre(itunesrecord.get(ITunesTags.primaryGenreName).toString());
					iRec.setsTrack(itunesrecord.get(ITunesTags.TRACK_NAME).toString());
					iRec.setsRealeaseDate(itunesrecord.get(ITunesTags.releaseDate).toString());
					
					//img url
					iRec.setsImgURL(itunesrecord.get(ITunesTags.artworkUrl30).toString());
					//*****************************************************
					
					//add single record to arraylist of ITunesRecords
					result.add(iRec);
					
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return result;
		}
		
	}
}