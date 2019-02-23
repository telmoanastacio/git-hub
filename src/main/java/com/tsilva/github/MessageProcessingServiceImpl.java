package com.tsilva.github;

import com.tsilva.github.demo.DemoData;

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
    public String getEmail()
    {
        String userResult = userContent.urlRead(urlPathGenerator.getUserInfoUrl(DemoData.USER));
        return new MessageProcessingModule1(userResult).getEmail();
    }

    // public repos
    public List<String> getRepos()
    {
        String userReposResult = userReposContent.urlRead(urlPathGenerator.getUserRepositoryListUrl(DemoData.USER));
        return new MessageProcessingModule1(userReposResult).getRepos();
    }

    // global stats
    public Map<String, Integer> getGlobalStatistics()
    {
        Map<String, Integer> globalStatsResult = globalStats.getGlobalStatistics();
        return globalStatsResult;
    }
}