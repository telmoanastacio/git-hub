package com.tsilva.controller;

import com.tsilva.MessageProcessingService;
import com.tsilva.MessageProcessingServiceImpl;
import com.tsilva.demo.DemoData;
import com.tsilva.util.AttributeNames;
import com.tsilva.util.ViewNames;
import com.tsilva.util.WebMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}