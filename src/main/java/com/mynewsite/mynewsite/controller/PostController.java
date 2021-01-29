package com.mynewsite.mynewsite.controller;

import com.mynewsite.mynewsite.model.Post;
import com.mynewsite.mynewsite.model.User;
import com.mynewsite.mynewsite.repository.PostRepository;
import com.mynewsite.mynewsite.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepo;

    @GetMapping("/create_post")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create_post";
    }

    @PostMapping("/process_post")
    public String processPostCreation(Post post) {
        postRepo.save(post);
        return "post_success";
    }

    @GetMapping("/list_posts")
    public String viewPostsList(Model model) {
        List<Post> listPosts = postRepo.findAll();
        model.addAttribute("listPosts", listPosts);
        return "posts";
    }


}
