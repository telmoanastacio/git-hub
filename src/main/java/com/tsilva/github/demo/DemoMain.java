package com.tsilva.github.demo;

import com.tsilva.github.*;

public class DemoMain
{
    public static void main(String[] args)
    {
        // ========= To delete =========
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();

        System.out.println(urlPathGenerator.getUserInfoUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getUserRepositoryListUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getRepositoryLanguageStatisticsUrl(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryContentListURL(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, DemoData.REPO, DemoData.FILE));
        // =============================

        MessageProcessingService messageProcessingService = new MessageProcessingServiceImpl();

        System.out.println("== email ==");
        System.out.println(messageProcessingService.getEmail());

        System.out.println("== repos ==");
        System.out.println(messageProcessingService.getRepos());

        System.out.println("== global stats ==");
        System.out.println(messageProcessingService.getGlobalStatistics());
    }
}