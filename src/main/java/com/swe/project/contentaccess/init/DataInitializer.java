package com.swe.project.contentaccess.init;

import com.swe.project.contentaccess.model.Topic;
import com.swe.project.contentaccess.repository.TopicRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final TopicRepository topicRepository;

    public DataInitializer(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @jakarta.annotation.PostConstruct
    public void init() {
        System.out.println("\n[INIT] Checking Mongo topic collection...");

        for (Topic topic : SeedData.topics()) {
            if (!topicRepository.existsById(topic.getId())) {
                System.out.println("[INIT] Adding missing seed topic: " + topic.getId());
                topicRepository.save(topic);
            } else {
                System.out.println("[INIT] Topic already exists, skipping: " + topic.getId());
            }
        }

        System.out.println("[INIT] Seed check complete. Current topic count: " + topicRepository.count());
    }
}