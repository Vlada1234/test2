package com.mynewsite.mynewsite.repository;

import com.mynewsite.mynewsite.model.Post;
import com.mynewsite.mynewsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.postId = ?1")
    User findBypostId(Long postId);

}
