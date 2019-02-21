package com.tsilva.github;

public interface UrlPathGenerator
{
    public String getUserInfoUrl(String user);

    public String getUserRepositoryListUrl(String user);

    public String getRepositoryLanguageStatisticsUrl(String owner, String repo);

    public String getRepositoryContentListURL(String owner, String repo);

    public String getRepositoryFileContentURL(String owner, String repo, String file);
}
