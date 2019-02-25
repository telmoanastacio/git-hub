package com.tsilva;

import java.util.List;
import java.util.Map;

public interface MessageProcessingService
{
    String getEmail(String user);

    List<String> getRepos(String user);

    Map<String, Integer> getGlobalStatistics(String user);
}