package ndalama;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import ndalama.code.R;

import org.json.JSONArray;
import org.json.JSONObject;

import tweet.tweet;
import adapters.tweetsAdapter;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

public class codeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        ArrayList<tweet> mytweets= new ArrayList<tweet>();
        
        LoadTweets(mytweets);
        
        
        ListView myList = (ListView)findViewById(R.id.listViewTweets);
        
        tweetsAdapter arrayAdapter = new tweetsAdapter(this, R.layout.tweet_item,mytweets);
        myList.setAdapter(arrayAdapter);
    }

	private void LoadTweets(ArrayList<tweet> mytweets) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://api.twitter.com/1/statuses/public_timeline.json");
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.connect();
            
            if(c.getResponseCode()==HttpURLConnection.HTTP_OK){
            	
            	InputStream is = c.getInputStream();
                
                DataInputStream in = new DataInputStream(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
    			StringBuffer buf = new StringBuffer();
    			
    			String line;
    			while((line = br.readLine())!= null){
    				buf.append(line);
    			} 
    			
    			JSONArray arr = new JSONArray(buf.toString());
    			for(int i=0;i<arr.length(); i++){
    			   JSONObject obj = arr.getJSONObject(i);
    			   
    			   tweet var = new tweet();
    			   var.created_at = obj.getString("created_at");
    			   var.in_reply_to_status_id = obj.getString("in_reply_to_status_id");
    			   var.source = obj.getString("source");
    			   var.text = obj.getString("text");
    			   String temp = obj.getString("user");
    			   JSONObject tmpuser = new JSONObject(temp);
    			   
    			   var.user.created_at = tmpuser.getString("created_at");
    			   var.user.location = tmpuser.getString("location");
    			   var.user.name = tmpuser.getString("name");

			       try {
    			       URL picurl = new URL(tmpuser.getString("profile_image_url"));
    			       InputStream content = (InputStream)picurl.getContent();
    			       Drawable d = Drawable.createFromStream(content , "src"); 
    			       var.user.profile_image_url= d;
    			   }
    			   catch(Exception e){
    				   //Just dont load the Image Just dont do anything
    				   //If you have a default Image then you can load it
    			   }
    			   
    			   var.user.screen_name= tmpuser.getString("screen_name");
    			   var.user.time_zone= tmpuser.getString("time_zone");
    			   
    			   mytweets.add(var);
    			}
			} 
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}