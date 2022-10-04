package br.com.meli.blog.controller;

import br.com.meli.blog.model.Blog;
import br.com.meli.blog.service.IBLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog" )
public class BlogController {

    @Autowired
    private IBLog blogService;


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public createdBlog(@RequestBody Blog blog){
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogs = blogService.consultarLista();
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }



}
