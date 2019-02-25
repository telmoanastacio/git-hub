package com.tsilva;

import java.util.List;
import java.util.Map;

public interface MessageProcessingService
{
    public String getEmail();

    public List<String> getRepos();

    public Map<String, Integer> getGlobalStatistics();
}