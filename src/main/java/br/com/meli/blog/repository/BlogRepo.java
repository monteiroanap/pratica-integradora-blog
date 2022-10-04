package br.com.meli.blog.repository;

import br.com.meli.blog.model.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
//comunicacao com o banco de dados - chamadas de banco
@Repository
public class BlogRepo {
    private final String linkFile = "src/main/resources/blogs.json";
    ObjectMapper mapper = new ObjectMapper(); // mapeia objeto

    public List<Blog> getAll(){
        List<Blog> blogs = null;
        try {
            //mapper.readValue: esse metodo procura o arquivo passado no 1 parametro, e faz a leitura caso
            //encontre e tenta converter para o tipo do dado do 2 parametro que nesse caso é Array de Blog.
            blogs = Arrays.asList(mapper.readValue(new File(linkFile), Blog[].class));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("não foi possivel ler esse arquivo");
        }
        return blogs;
    }

    public void createBlog(Blog blog){
        List<Blog> blogs = getAll();
    }

    public void getOneBlog(){
        List<Blog> blogs = getAll();
    }

}
