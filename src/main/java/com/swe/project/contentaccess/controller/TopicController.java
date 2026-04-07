package com.swe.project.contentaccess.controller;

import com.swe.project.contentaccess.model.Topic;
import com.swe.project.contentaccess.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
        System.out.println(">>> TopicController CREATED <<<");
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopicById(id);
    }
}