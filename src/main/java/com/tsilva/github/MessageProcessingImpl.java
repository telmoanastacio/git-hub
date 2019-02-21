package com.tsilva.github;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageProcessingImpl
{
    private final String JSON_STRING;
    private JSONObject jsonObject;

    public MessageProcessingImpl(String jsonString)
    {
        this.JSON_STRING = jsonString;
        try
        {
            this.jsonObject = new JSONObject(jsonString);
            //TODO: collect the info from JSON files
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
        }
    }

    public String getEmail()
    {
        return this.jsonObject.getString("email");
    }
}