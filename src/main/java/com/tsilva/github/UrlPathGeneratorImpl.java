package com.tsilva.github;

public class UrlPathGeneratorImpl implements UrlPathGenerator
{
    public static final String API_URL = "https://api.github.com";
    public UrlPathGeneratorImpl()
    {}

    public String getUserInfoUrl(String user)
    {
        return API_URL + "/users/" + user;
    }

    public String getUserRepositoryListUrl(String user)
    {
        return API_URL + "/users/" + user + "/repos";
    }

    public String getRepositoryLanguageStatisticsUrl(String owner, String repo)
    {
        return API_URL + "/repos/" + owner + "/" + repo + "/languages";
    }

    public String getRepositoryContentListURL(String owner, String repo)
    {
        return API_URL + "/repos/" + owner + "/" + repo + "/contents";
    }

    public String getRepositoryFileContentURL(String owner, String repo, String file)
    {
        return API_URL + "/repos/" + owner + "/" + repo + "/contents/" + file;
    }
}