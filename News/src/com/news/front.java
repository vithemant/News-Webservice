package com.news;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/front")
public class front {
	@GET
	@Path("/news")
	@Produces(MediaType.APPLICATION_JSON)
	public List getTrackInJSON(@QueryParam("keyword")String search) throws IOException, JSONException {
		
		List listPerson = new ArrayList();
		ArrayList<String> message=new ArrayList<String>();
		String url="https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=eadb6da4bb5847a8b5f5b8a633e53ab9";
		URL obj = new URL(url);
		URLConnection con = obj.openConnection();
	   // Spliting the URL for country and category
	   String[] quer=obj.getQuery().split("&|=");
	   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	    
	     //Read JSON response
	     JSONObject myResponse = new JSONObject(response.toString());
	     JSONArray ja_data = myResponse.getJSONArray("articles");
	     
	     int num=myResponse.getInt("totalResults");
	     if(search == null)
	     {
	    	 for(int i=0;i<num;i++)
		     { back p1 = new back();
		     JSONObject jsonObj = ja_data.getJSONObject(i); 
		     p1.setCountry(quer[1]);
		     p1.setCategory(quer[3]);
		     if(jsonObj.has("url") && !jsonObj.isNull("url"))
		     p1.setURL(jsonObj.getString("url"));
		     else 
		    	 p1.setURL("null");
		     if(jsonObj.has("title") && !jsonObj.isNull("title"))
		     p1.setTitle(jsonObj.getString("title"));
		     else
		    	 p1.setTitle("null");
		     if(jsonObj.has("description") && !jsonObj.isNull("description"))
		    	 p1.setDescription(jsonObj.getString("description"));
		    	 
		     else 
		    	 p1.setDescription("null");
		    	 
		     listPerson.add(p1);}
		     
	    	 return  listPerson;
	     }
	     else
	     {
	     int count=0;
	     for(int i=0;i<num;i++)
	     { back p1 = new back();
	     JSONObject jsonObj = ja_data.getJSONObject(i);
	     if(jsonObj.has("description") && !jsonObj.isNull("description"))
	     { //
	    	 if(jsonObj.getString("description").matches("(?i).*" +search+".*"))
	     {
	    	 count++;
	     p1.setCountry(quer[1]);
	     p1.setCategory(quer[3]);
	     p1.setURL(jsonObj.getString("url"));
	     p1.setTitle(jsonObj.getString("title"));
	     p1.setDescription(jsonObj.getString("description"));
	     listPerson.add(p1);
	     }}}
		if(count>0)
		{   
			return  listPerson;
		}
		else
		{message.add("Nothing found for your Keyword "+search);
			return message;}
		
	}
	
	}
}




