package tweet;

import android.graphics.drawable.Drawable;

public class user {
	public String name;
	public String created_at;
	public Drawable profile_image_url;
	public String location;
	public String time_zone;
	public String screen_name;
	public user() {
		name = "";
		created_at = "";
		profile_image_url = null;
		location = "";
		time_zone = "";
		screen_name = "";
	}
	public void setName(String value){
		name=value;
	}
	public void setCreated_at(String value){
		created_at=value;
	}
	public void setProfile_image_url(Drawable value){
		profile_image_url=value;
	}
	public void setLocation(String value){
		location=value;
	}
	public void setTime_zone(String value){
		time_zone=value;
	}
	public void setScreen_name(String value){
		screen_name=value;
	}

	public String getName(){
		return name;
	}
	public String getCreated_at(){
		return created_at;
	}
	public Drawable getProfile_image_url(){
		return profile_image_url;
	}
	public String getLocation(){
		return location;
	}
	public String getTime_zone(){
		return time_zone;
	}
	public String getScreen_name(){
		return screen_name;
	}

}
