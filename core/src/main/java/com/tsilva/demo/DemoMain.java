package com.tsilva.demo;

import com.tsilva.*;

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

//        MessageProcessingService messageProcessingService = new MessageProcessingServiceImpl();
//
//        System.out.println("== email ==");
//        System.out.println(messageProcessingService.getEmail(DemoData.USER));
//
//        System.out.println("== repos ==");
//        System.out.println(messageProcessingService.getRepos(DemoData.OWNER));
//
//        System.out.println("== global stats ==");
//        System.out.println(messageProcessingService.getGlobalStatistics(DemoData.USER));
//
//        System.out.println("== file content ==");
//        System.out.println(new Base64DecoderImpl()
//                .getDecodedContent(new FileImpl(DemoData.REPO, DemoData.FILE).getFileContent()));
//
//        System.out.println("== directory layer ==");
//        Directory directory = new DirectoryImpl(DemoData.REPO, "");
//        System.out.println("Path: " + directory.getPATH() + "\nLayer: " + directory.getLayer());
    }
}