package com.example.igil.controller;

import com.example.igil.model.Comment;
import com.example.igil.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/comment")
public class CommentController {

    // ОТВЕЧАЕТ ЗА ОБРАБОТКУ ЗАПРОСОВ ОТНОСИТЬТЕЛЬНО КОММЕНТОВ

    private final CommentRepository commentRepository;

    @GetMapping(value = "/add") //ПОЛУЧЕНИЕ ФОРМЫ ЗАПОЛНЕНИЯ КОММЕНТА
    public String addComment(Model model){
       ;model.addAttribute("comment", new Comment());
        return "comment-add";
    }

    @PostMapping(value = "/add") // ПОЛУЧЕНИЕ КОММЕНТА ИЗ ФОРМЫ
    public String saveComment(@ModelAttribute Comment comment){
        commentRepository.save(comment);
        return "redirect:/";
    }

    @GetMapping(value = "/all") // ПОЛУЧЕНИЕ ВСЕХ КОММЕНТОВ
    public String getAll(Model model){
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments",comments);
        return "comment-table";
    }

}
