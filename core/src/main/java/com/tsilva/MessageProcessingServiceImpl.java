package com.tsilva;

import com.tsilva.demo.DemoData;

import java.util.List;
import java.util.Map;

public class MessageProcessingServiceImpl implements MessageProcessingService
{
    // == variables ==
    UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();

    private static UrlContentReader userContent = new UrlContentReaderImpl();
    private static UrlContentReader userReposContent = new UrlContentReaderImpl();

    private static MessageProcessingModule2 globalStats = new MessageProcessingModule2();

    // == constructors ==
    public MessageProcessingServiceImpl()
    {}

    // == public methods ==
    // email
    public String getEmail(String user)
    {
        String userResult = userContent.urlRead(urlPathGenerator.getUserInfoUrl(user));
        return new MessageProcessingModule1(userResult).getEmail();
    }

    // public repos
    public List<String> getRepos(String user)
    {
        String userReposResult = userReposContent.urlRead(urlPathGenerator.getUserRepositoryListUrl(user));
        return new MessageProcessingModule1(userReposResult).getRepos();
    }

    // global stats
    public Map<String, Integer> getGlobalStatistics(String user)
    {
        Map<String, Integer> globalStatsResult = globalStats.getGlobalStatistics(user);
        return globalStatsResult;
    }
}