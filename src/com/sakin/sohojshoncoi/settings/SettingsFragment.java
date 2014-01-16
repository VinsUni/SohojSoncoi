package com.sakin.sohojshoncoi.settings;

import java.util.ArrayList;

import com.sakin.sohojshoncoi.R;
import com.sakin.sohojshoncoi.Utils;
import com.sakin.sohojshoncoi.daylihisab.AddNewHisab;
import com.sakin.sohojshoncoi.daylihisab.DailyHisab;
import com.sakin.sohojshoncoi.filechooser.FileChooser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsFragment extends ListFragment {

	View rootView = null;
	private static final int FILE_CHOOSER = 11;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	     // The last two arguments ensure LayoutParams are inflated properly.
		if(rootView==null){
			rootView = inflater.inflate(R.layout.settings, container, false);
		} else {
			ViewGroup parent = (ViewGroup) rootView.getParent();
			parent.removeView(rootView);
		}
		 String[] values = new String[] { "Reminder tone", "Help", "Credits" };
		 SettingsArrayAdapter adapter = new SettingsArrayAdapter(getActivity(),
		    R.layout.settings_item, values);
		setListAdapter(adapter);
		
		Utils.setActionBarTitle(getActivity(), "সেটিংস");
		return rootView;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		if(position == 0){
			searchFile();
		} else if(position == 2) {
			Fragment addNewHisab = new AboutUs();
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.remove(SettingsFragment.this);
            ft.add(R.id.content_frame, addNewHisab, Utils.ADDNEWHISABTAG);
            ft.addToBackStack("settings");
            ft.commit();
		}
	   return;
	}
	
	private void searchFile() {
    	Intent intent = new Intent(getActivity(), FileChooser.class);
    	ArrayList<String> extensions = new ArrayList<String>();
    	extensions.add(".mp3");
    	extensions.add(".jpg");
    	extensions.add(".jpeg");
    	intent.putStringArrayListExtra("filterFileExtension", extensions);
    	startActivityForResult(intent, FILE_CHOOSER);
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if ((requestCode == FILE_CHOOSER) && (resultCode == -1)) {
    		String fileSelected = data.getStringExtra("fileSelected");
    		Utils.ALARM_TONE_DIRECTORY = fileSelected;
    		Toast.makeText(getActivity(), fileSelected, Toast.LENGTH_SHORT).show();
    	}
    		
    }
}

class SettingsArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;
	  private int id;
	  public SettingsArrayAdapter(Context context, int id, String[] values) {
	    super(context, id, values);
	    this.context = context;
	    this.values = values;
	    this.id = id;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(id, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.settings_title);
	    textView.setTypeface(Utils.banglaTypeFace);
	    textView.setTextColor(Color.WHITE);
	    textView.setText(values[position]);

	    return rowView;
	  }
	} 
