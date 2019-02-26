package com.tsilva.controller;

import com.tsilva.*;
import com.tsilva.demo.DemoData;
import com.tsilva.util.AttributeNames;
import com.tsilva.util.ViewNames;
import com.tsilva.util.WebMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class WebController
{
    // == fields ==
    private static final Logger LOG = LoggerFactory.getLogger(WebController.class);
    private static String user;

    // == constructors ==
    @Autowired
    public WebController()
    {}

    // == request methods ==
    @PostMapping(WebMappings.REPOS)
    public String repos(@RequestParam String username, Model model)
    {
        this.user = username;
        LOG.info("this.user = {}", this.user);
        MessageProcessingService messageProcessingService = new MessageProcessingServiceImpl();
        LOG.info("username = {}", username);
        String email = messageProcessingService.getEmail(username);
        LOG.info("email = {}", email);
        model.addAttribute(AttributeNames.EMAIL, email);
        Map<String, Integer> globalStatistics = messageProcessingService.getGlobalStatistics(username);
        model.addAttribute(AttributeNames.GLOBAL_STATISTICS, globalStatistics);
        List<String> repositoriesList = messageProcessingService.getRepos(username);
        LOG.info("repositories = {}", repositoriesList);
        model.addAttribute(AttributeNames.REPOSITORIES_LIST, repositoriesList);

        return ViewNames.REPOS;
    }

    @GetMapping(WebMappings.EXPLORE)
    public String explore(@RequestParam String repo, Model model)
    {
        LOG.info("repo = {}", repo);
        Directory directory = new DirectoryImpl(repo, "");
        // TODO: Split in a list of files and a list of dirs and pass to the model individually
        List<Object> layer = directory.getLayer();
        List<File> filesList = new LinkedList<>();
        List<Directory> directoriesList = new LinkedList<>();
        for(Object fileOrDir : layer)
        {
            if(fileOrDir.getClass().getName().equals("com.tsilva.FileImpl"))
            {
                filesList.add((File) fileOrDir);
                System.out.println("FILE: " + ((File) fileOrDir).getPATH());
            }
            else if(fileOrDir.getClass().getName().equals("com.tsilva.DirectoryImpl"))
            {
                directoriesList.add((Directory) fileOrDir);
                System.out.println("DERECTORY: " + ((Directory) fileOrDir).getPATH());
            }
        }

        LOG.info("layer = {}", layer);
        LOG.info("{} files = {}", filesList.size(), filesList);
        LOG.info("{} directories = {}", directoriesList.size(), directoriesList);
        model.addAttribute(AttributeNames.FILES_LIST, filesList);
        model.addAttribute(AttributeNames.DIRECTORIES_LIST, directoriesList);

//         ((FileImpl) layer.get(0)).getPATH();
//         ((DirectoryImpl) layer.get(0)).getPATH();

//        System.out.println(layer.get(0).getClass().getName().equals("com.tsilva.FileImpl"));
//        System.out.println(layer.get(0).getClass().getName().equals("com.tsilva.DirectoryImpl"));

        return ViewNames.EXPLORE;
    }
}