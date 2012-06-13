package tweet;


public class tweet {
	
    public String source;
    public String in_reply_to_status_id;
    public String created_at;
    public String text;
    public user user; 
    
    public tweet() {
		user = new user();
	    source = "";
	    in_reply_to_status_id = "";
	    created_at = "";
	    text = "";
	}
    
    public String getSource(){
    	return source;
    }
    public String getIn_reply_to_status_id(){
    	return in_reply_to_status_id;
    }
    public String getCreated_at(){
    	return created_at;
    }
    public String getText(){
    	return text;
    }
    public user getTweet(){
    	return user;
    }
    public void setSource(String value){
    	 source = value;
    }
    public void setIn_reply_to_status_id(String value){
    	in_reply_to_status_id = value;
    }
    public void setCreated_at(String value){
    	created_at= value;;
    }
    public void setText(String value){
    	text = value;;
    }
    public void setUser(user value){
    	user.created_at = value.created_at;
    	user.location = value.location;
    	user.name = value.name;
    	user.profile_image_url = value.profile_image_url;
    	user.screen_name = value.screen_name;
    	user.time_zone = value.time_zone;
    }
    
    

}
