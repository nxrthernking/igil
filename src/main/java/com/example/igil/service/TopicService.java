package com.example.igil.service;

import com.example.igil.model.Topic;
import com.example.igil.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Topic findById(Long id){
        return topicRepository.findById(id).orElseThrow();
    }
}
