package com.tsilva;

import com.tsilva.demo.DemoData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DirectoryImpl implements Directory
{
    // == variables ==
    private final String REPO;
    private final String PATH;
    // List containing Directory or File objects contained inside this one
    private List<Object> layer = new ArrayList<>();

    // == constructors ==
    public DirectoryImpl(String repo ,String path)
    {
        this.REPO = repo;
        this.PATH = path;
        exploreLayer();
    }

    // == public methods ==
    public String getPATH()
    {
        return PATH;
    }

    public List<Object> getLayer()
    {
        return layer;
    }

    // == private methods
    private void setLayer(List<Object> layer)
    {
        this.layer = layer;
    }

    private void exploreLayer()
    {
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();
        UrlContentReader layerContentReader = new UrlContentReaderImpl();
        String layerContent = layerContentReader
                .urlRead(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, this.REPO, this.PATH));
        try
        {
            JSONArray jsonArray = new JSONArray(layerContent);
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String path = jsonObject.getString("path");
                String type = jsonObject.getString("type");
                jsonObject = null;
                if(type.equals("file"))
                {
                    this.layer.add(new FileImpl(this.REPO, path));
                }
                else if(type.equals("dir"))
                {
                    this.layer.add(new DirectoryImpl(this.REPO, path));
                }
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
        }
    }
}