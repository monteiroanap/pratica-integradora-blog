package br.com.meli.blog.controller;

import br.com.meli.blog.dto.BlogDTO;
import br.com.meli.blog.exceptions.BlogInexistenteException;
import br.com.meli.blog.exceptions.IdExistenteException;
import br.com.meli.blog.model.Blog;
import br.com.meli.blog.service.GerenciaBlogService;
import br.com.meli.blog.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BlogController {

    @Autowired
    private IBlog blogService;


    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createdBlog(@RequestBody BlogDTO blogDto){
        Blog blog = new Blog();
        blog.setId(blogDto.getId());
        blog.setTitulo(blogDto.getTitulo());
        blog.setNomeAutor(blogDto.getNomeAutor());
        try{
            blogService.criarBLog(blog);
        }catch (IdExistenteException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("blog criado com sucesso " + blog.getId(),HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogs = blogService.consultarLista();
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Object> consultarBlogId(@PathVariable Integer id){
        Blog blog = null;
        try{
            blog = blogService.consultarBlogId(id);
        }catch (BlogInexistenteException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


}
