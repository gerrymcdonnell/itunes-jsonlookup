package course.examples.Networking.AndroidHttpClientJSON;

import java.util.ArrayList;
import java.util.List;

import course.examples.Networking.AndroidHttpClientJSON.ITunes.ITunesRecord;


import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ITunesListAdapter extends BaseAdapter{

	//araylist of itunes objects
	private List<ITunesRecord> mItems = new ArrayList<ITunesRecord>();
	private final Context mContext;
	
	
	public ITunesListAdapter(Context context,List<ITunesRecord> recordList) {
		this.mContext = context;
		this.mItems=recordList;
	}
	
	
	//add a record
	public void add(ITunesRecord item) {
		mItems.add(item);
		notifyDataSetChanged();
	}
	
	
	public void clear() {
		mItems.clear();
		notifyDataSetChanged();
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItems.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return mItems.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final ITunesRecord myiTunesRecord = (ITunesRecord) getItem(position);		
	
		
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemLayout = inflater.inflate(R.layout.my_list_item, parent, false);
		
		
		//add image here later
		final ImageView img=(ImageView) itemLayout.findViewById(R.id.icon);
		//img.setImageURI(Uri.parse(myiTunesRecord.getsImgURL()));
		Log.i("img url",myiTunesRecord.getsImgURL());
		
		
		//Title in TextView
		final TextView titleView = (TextView) itemLayout.findViewById(R.id.txtTitle);        
        //desc or sub text
		final TextView descView = (TextView) itemLayout.findViewById(R.id.txtDesc);
		
		
		//set text
		//***********************************************************************************************		
		titleView.setText(myiTunesRecord.getsArtist() + " - " + myiTunesRecord.getsTrack());
		
		//album		
		descView.setText(myiTunesRecord.getsAlbum()+ "/n" + myiTunesRecord.getsYear());
		//***********************************************************************************************
		
		
		
		// TODO Auto-generated method stub
		return itemLayout;
	}

}
