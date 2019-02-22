package com.tsilva.github;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageGeneratorImpl implements MessageGenerator
{
    // == variables ==
    private String email;
    private List<String> allRepositories;
    private Map<String, Double> overallLangStats;

    // == constructors ==
    // should be HashMap
    public MessageGeneratorImpl(String email, List<String> allRepositories, Map<String, Double> overallLangStats)
    {
        this.email = email;
        this.allRepositories = allRepositories;
        this.overallLangStats = overallLangStats;
    }

    // == public methods ==
    public String generateStatsMessage()
    {
        StringBuilder sb = new StringBuilder();
        Set<String> overallLangStatsKeys = this.overallLangStats.keySet();

        sb.append("=============================\n");
        sb.append("== STATS MESSAGE GENERATED ==\n");
        sb.append("=============================\n\n");

        sb.append("=> USER EMAIL: " + this.email + "\n\n");

        sb.append("=> REPOSITORIES:\n");
        for(String repository : this.allRepositories)
        {
            sb.append("- " + repository + "\n");
        }
        sb.append("\n");

        sb.append("=> GLOBAL LANGUAGE STATISTICS:\n");
        for(String key : overallLangStatsKeys)
        {
            sb.append("- " + key + ": " + this.overallLangStats.get(key) + "%\n");
        }

        sb.append("=============================\n");
        sb.append("=============================\n");

        this.email = null;
        this.allRepositories = null;
        this.overallLangStats = null;

        return sb.toString();
    }
}