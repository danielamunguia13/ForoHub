package com.alura.forohub.Controller;

import com.alura.forohub.model.Topic;
import com.alura.forohub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Validated Topic topic) {
        topicRepository.save(topic);
        return ResponseEntity.ok(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(topic.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody @Validated Topic topicDetails) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setTitle(topicDetails.getTitle());
            topic.setMessage(topicDetails.getMessage());
            topic.setStatus(topicDetails.getStatus());
            topicRepository.save(topic);
            return ResponseEntity.ok(topic);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
