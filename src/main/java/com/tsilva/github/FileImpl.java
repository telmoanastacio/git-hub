package com.tsilva.github;

import com.tsilva.github.demo.DemoData;
import org.json.JSONException;
import org.json.JSONObject;

public class FileImpl implements File
{
    public final String REPO;
    public final String PATH;

    public FileImpl(String repo ,String path)
    {
        this.REPO = repo;
        this.PATH = path;
    }

    public String getPATH()
    {
        return PATH;
    }

    public String getFileContent()
    {
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();
        UrlContentReader fileContentReader = new UrlContentReaderImpl();
        String fileContent = fileContentReader
                .urlRead(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, this.REPO, this.PATH));
        try
        {
            JSONObject jsonObject = new JSONObject(fileContent);
            return jsonObject.getString("content");
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            System.out.println("== parsing exception ==");
            return null;
        }
    }
}