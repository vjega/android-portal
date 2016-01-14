package com.msystechnologies.msysempportal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pravinth on 13/1/16.
 */

public class ParseJSON {
    public static String[] ids;
//    public static String[] names;
    public static String[] documents;


    public static final String JSON_ARRAY = "result";
//    public static final String KEY_ID = "id";
    public static final String KEY_DOCUMENT = "doc_name";

    private JSONArray qualifications = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

//    protected void parseJSON(){
//        JSONObject jsonObject=null;
//        try {
//            jsonObject = new JSONObject(json);
//            qualifications = jsonObject.getJSONArray(JSON_ARRAY);
//
//            ids = new String[qualifications.length()];
//            documents = new String[qualifications.length()];
//
//
//            for(int i=0;i<qualifications.length();i++){
//                JSONObject jo = qualifications.getJSONObject(i);
////                ids[i] = jo.getString(KEY_ID);
//                documents[i] = jo.getString(KEY_DOCUMENT);
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//    protected void parseJSON(){
//        JSONArray get_json_array =new JSONArray();
//        try {
//            for(int i =0;i<get_json_array.length();i++){
//                documents[i] = get_json_array.getJSONObject(i).getString("doc_name");
//
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}