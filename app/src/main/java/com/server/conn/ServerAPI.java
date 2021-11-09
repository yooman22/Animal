package com.server.conn;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ServerAPI extends Thread{

    public int flag = 0;
    public HashMap<String,String> query;
    private StringBuilder output = new StringBuilder();

    public ServerAPI(int flag,HashMap<String,String> query){
        this.flag = flag;
        this.query = query;
    }

    public String getOutput(){
        return output.toString();
    }

    @Override
    public void run() {
        switch(flag){
            case 1 : requestAPI("http://10.0.2.2:8080/json/signUp?"+makeQueryString()); break;
            case 2 : requestAPI("http://10.0.2.2:8080/json/login?"+makeQueryString()); break;
            case 3 : requestAPI("http://10.0.2.2:8080/json/phoneAuth?"+makeQueryString()); break;
            case 4 : requestAPI("http://10.0.2.2:8080/json/findId?"+makeQueryString()); break;
        }
    };

    public void requestAPI(String requestURL){

        try {
            java.net.URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                int resCode = conn.getResponseCode();
                System.out.println("resCode : " +resCode);
                if (resCode == HttpURLConnection.HTTP_OK) {

                    InputStream ip = conn.getInputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String temp = "";

                    while((temp = br.readLine()) != null){
                        System.out.println("temp : " + temp);
                        output.append(temp);
                    }
                    conn.disconnect();
                }
            }
        } catch(Exception ex) {
            Log.e("SampleHTTP", "Exception in processing response.", ex);
            ex.printStackTrace();
        }
    }


    private String makeQueryString(){
        int i=1;
        String queryString = "";
        for(String key : query.keySet()){
            queryString += key+"=";
            queryString += query.get(key);

            if(i < query.size() ) queryString += "&";

            i++;
        }
        return queryString;
    }

}
