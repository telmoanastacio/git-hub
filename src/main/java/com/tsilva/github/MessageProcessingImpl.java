package com.tsilva.github;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

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

    public Map<String, Integer> getStatistics()
    {
        Map<String, Integer> stats = new LinkedHashMap<>();
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
            return sortByValue(stats);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
            return null;
        }
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
    {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for(int i = list.size() - 1; i >= 0; i-- ) /*(Map.Entry<K, V> entry : list)*/
        {
            Map.Entry<K, V> entry = list.get(i);
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}