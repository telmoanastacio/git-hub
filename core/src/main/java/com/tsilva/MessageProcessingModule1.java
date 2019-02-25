package com.tsilva;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class MessageProcessingModule1
{
    private final String JSON_STRING;

    public MessageProcessingModule1(String jsonString)
    {
        this.JSON_STRING = jsonString;
    }

    public String getEmail()
    {
        try
        {
            JSONObject jsonObject = new JSONObject(this.JSON_STRING);
            return jsonObject.get("email").toString();
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
            return "";
        }
    }

    public List<String> getRepos()
    {
        List<String> repoNamesList = new LinkedList<>();
        try
        {
            JSONArray jsonArray = new JSONArray(this.JSON_STRING);
            for(int i = 0; i < jsonArray.length(); i++)
            {
                if(!jsonArray.getJSONObject(i).getBoolean("private"))
                {
                    repoNamesList.add(jsonArray.getJSONObject(i).getString("name"));
                }
            }
            return repoNamesList;
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
            return null;
        }
    }

    public Map<String, Integer> getStatistics()
    {
        Map<String, Integer> stats = new HashMap<>();
        Set<String> keys;
        Integer value = -1;
        try
        {
            JSONObject jsonObject = new JSONObject(this.JSON_STRING);
            keys = jsonObject.keySet();
            for(String key : keys)
            {
                value = jsonObject.getInt(key);
                stats.put(key, value);
            }
            return stats;
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
            return null;
        }
    }
}