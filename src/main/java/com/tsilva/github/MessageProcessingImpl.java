package com.tsilva.github;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessageProcessingImpl
{
    private final String JSON_STRING;

    public MessageProcessingImpl(String jsonString)
    {
        this.JSON_STRING = jsonString;
        System.out.println("=== JSON string ===");
        System.out.println(jsonString);
        System.out.println("===================");
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

    public Map<String, Double> getOverallStatistics()
    {
        return null;
    }
}