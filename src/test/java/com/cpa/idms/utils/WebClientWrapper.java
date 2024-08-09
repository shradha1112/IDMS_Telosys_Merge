package com.cpa.idms.utils;


public class WebClientWrapper {

	public WebClientWrapper() {
		
	}
	
        public Boolean auth = false;
	    public String userName ;
	    public String password ;
	    public String host;
	    public int port;

	    public WebClientWrapper(String root){
	       
	        String baseURL = "https://localhost:8081";
	        
	 
	    }

	    public boolean getAuth() {
	        return this.auth;
	    }

	    public void setAuth(boolean authenticate) {
	        this.auth = authenticate;
	    }

	    public String getUserName(){
	        return this.userName;
	    }

	    public void setUserName(String userName){
	        this.userName = userName;
	    }

	    public String getPassword(){
	        return this.password;
	    }

	    public void setPassword(String password){
	        this.password = password;
	    }

	    public void setHost(String host){
	        this.host = host;
	    }

	    public String getHost(){
	        return this.host;
	    }

	    public void setPort(int port){
	        this.port = port;
	    }

	    public int getPort(){
	        return this.port;
	    }

}
           