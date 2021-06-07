package com.example.igil.controller;

import com.example.igil.model.Topic;
import com.example.igil.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping // ДОМАШНЯЯ СТРАНИЦА
    public String homePage(Model model){
        model.addAttribute("topics",topicService.findAll());
        model.addAttribute("topic",new Topic());
        return "home";
    }

    @GetMapping(value = "/topic") // ВЫБРАНАЯ ТЕМА В ВЫПАДАЮЩЕМ МЕНЮ. ОТОБРАЗИТСЯ НА ДРУГОЙ СТР
    public String getTopic(Model model, @ModelAttribute Topic topic){
        model.addAttribute("topic",topicService.findById(topic.getId()));
        return "topic-info";
    }
}
