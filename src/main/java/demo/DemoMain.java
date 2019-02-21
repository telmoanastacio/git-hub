package demo;

import implementations.UrlContentReader;
import implementations.UrlPathGeneratorImpl;
import interfaces.UrlPathGenerator;

public class DemoMain
{
    public static void main(String[] args)
    {
        UrlPathGenerator urlPathGenerator = new UrlPathGeneratorImpl();
        UrlContentReader userContent = new UrlContentReader();
        UrlContentReader fileContent = new UrlContentReader();

        System.out.println(urlPathGenerator.getUserInfoUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getUserRepositoryListUrl(DemoData.USER));
        System.out.println(urlPathGenerator.getRepositoryLanguageStatisticsUrl(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryContentListURL(DemoData.OWNER, DemoData.REPO));
        System.out.println(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, DemoData.REPO, DemoData.FILE));

        // print user content
        System.out.println(userContent.urlRead(urlPathGenerator.getUserInfoUrl(DemoData.USER)));
        userContent = null;
        // print file content
        System.out.println(fileContent
                .urlRead(urlPathGenerator.getRepositoryFileContentURL(DemoData.OWNER, DemoData.REPO, DemoData.FILE)));
    }
}