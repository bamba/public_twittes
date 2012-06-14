package adapters;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ndalama.code.R;


import tweet.tweet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class tweetsAdapter extends ArrayAdapter<tweet>{

	int resource;
    android.content.Context context;
    List<tweet> data = null; 
	public tweetsAdapter(Context context, int resource,List<tweet> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resource = resource;
		this.data = objects;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	@Override
	public tweet getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout tweetview;
        //Get the current alert object
        tweet al = getItem(position);
 
        //Inflate the view
        if(convertView==null)
        {
        	tweetview = new LinearLayout(getContext());
            String inflater = android.content.Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, tweetview, true);
        }
        else
        {
        	tweetview = (LinearLayout) convertView;
        }
        //Get the text boxes from the listitem.xml file
        TextView name =(TextView)tweetview.findViewById(ndalama.code.R.id.name);
        TextView tweet =(TextView)tweetview.findViewById(ndalama.code.R.id.tweet);
        TextView time =(TextView)tweetview.findViewById(ndalama.code.R.id.time);
        ImageView iv = (ImageView)tweetview.findViewById(R.id.imgIcon);
        

        iv.setImageDrawable(al.user.getProfile_image_url());
        name.setText(al.user.name);
        tweet.setText(al.text);
        time.setText(al.created_at);
        
        return tweetview;
    }


}
