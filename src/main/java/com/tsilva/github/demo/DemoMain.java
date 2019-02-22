package com.tsilva.github.demo;

import com.tsilva.github.*;

public class DemoMain
{
    public static void main(String[] args)
    {
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();

        UrlContentReader userContent = new UrlContentReaderImpl();
        UrlContentReader userReposContent = new UrlContentReaderImpl();
        UrlContentReader repoContent = new UrlContentReaderImpl();
        UrlContentReader fileContent = new UrlContentReaderImpl();

        System.out.println(urlPathGenerator.getUserInfoUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getUserRepositoryListUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getRepositoryLanguageStatisticsUrl(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryContentListURL(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, DemoData.REPO, DemoData.FILE));

//        // print user content
//        System.out.println(userContent.urlRead(urlPathGenerator.getUserInfoUrl(DemoData.USER)));
//        userContent = null;
//        // print file content
//        System.out.println(fileContent
//                .urlRead(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, DemoData.REPO, DemoData.FILE)));

        String userResult = userContent.urlRead(urlPathGenerator.getUserInfoUrl(DemoData.USER));
        System.out.println(new MessageProcessingImpl(userResult).getEmail());

        String userRepos = userReposContent.urlRead(urlPathGenerator.getUserRepositoryListUrl(DemoData.USER));
        System.out.println(new MessageProcessingImpl(userRepos).getRepos());

        String repoResult = repoContent.urlRead(urlPathGenerator.getRepositoryLanguageStatisticsUrl(DemoData.OWNER, DemoData.REPO));
        System.out.println(new MessageProcessingImpl(repoResult).getStatistics());
    }
}