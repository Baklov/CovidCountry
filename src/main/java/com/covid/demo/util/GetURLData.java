package com.covid.demo.util;  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.*;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeSet;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.covid.demo.model.CountryEntity;   
public class GetURLData {   

static JSONParser jParser = new JSONParser();
JSONArray jsonArrays = new JSONArray();
	public static Map getUrlContents(String theUrl)  
	  {  
	    StringBuilder content = new StringBuilder();  
	    Map<String, CountryEntity> countries= new HashMap<String, CountryEntity>();
	     
	     HttpsURLConnection urlConnection = null;
		try {
			urlConnection =   (HttpsURLConnection) new URL(theUrl).openConnection();
			 if (urlConnection.getResponseCode() == 200) {
				 try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())))
				    {  
				    	String line;  
					      while ((line = bufferedReader.readLine()) != null)  
					      {  
					        content.append(line + "\n");  
					      }  
					   
				    } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			 else {
				 throw new ConnectException("Communication errror"+urlConnection.getResponseCode());
			 }

		
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    	   
	    try (JsonReader jsonReader = Json.createReader(new StringReader(content.toString()))) {
	    	JsonArray jsonArray = jsonReader.readArray();
	    	ListIterator l = jsonArray.listIterator();
	    	while ( l.hasNext() ) {
	    		JsonObject j = (JsonObject)l.next();
	    		ObjectMapper objectMapper = new ObjectMapper();
	    		try {
					CountryEntity country = objectMapper.readValue(j.toString(), CountryEntity.class);
					countries.put(country.getIso2(), country);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }

	    return countries;  
	  } 
    public static void main(String[] args){    
    try{ 
    
    	Map<String, CountryEntity> countries  = getUrlContents("https://api.covid19api.com/countries");  
    	System.out.println(countries);
    }  
    catch(Exception e)  
    {  
        System.out.println(e);}    
    }    
    }  