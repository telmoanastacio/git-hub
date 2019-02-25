package com.tsilva;

import com.tsilva.demo.DemoData;

import java.util.*;

public class MessageProcessingModule2
{
    public MessageProcessingModule2()
    {}

    public Map<String, Integer> getGlobalStatistics(String user)
    {
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();

        UrlContentReader userReposContent = new UrlContentReaderImpl();

        String userRepos = userReposContent.urlRead(urlPathGenerator.getUserRepositoryListUrl(user));
        List<String> repos = new MessageProcessingModule1(userRepos).getRepos();
        userRepos = null;

        Map<String, Integer> globalStats = new HashMap<>();

        for(String repo : repos)
        {
            String repoResult = new UrlContentReaderImpl()
                    .urlRead(urlPathGenerator.getRepositoryLanguageStatisticsUrl(user, repo));
            Map<String, Integer> auxMap = new MessageProcessingModule1(repoResult).getStatistics();
            for(String key : auxMap.keySet())
            {
                if(globalStats.containsKey(key))
                {
                    globalStats.replace(key, globalStats.get(key) + auxMap.get(key));
                }
                else
                {
                    globalStats.put(key, auxMap.get(key));
                }
            }
        }

        return sortByValue(globalStats);
    }

    // sort only the global statistics
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