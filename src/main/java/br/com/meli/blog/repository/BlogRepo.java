package br.com.meli.blog.repository;

import br.com.meli.blog.exceptions.BlogInexistenteException;
import br.com.meli.blog.exceptions.IdExistenteException;
import br.com.meli.blog.model.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//comunicacao com o banco de dados - chamadas de banco
@Repository
public class BlogRepo {
    private final String linkFile = "src/main/resources/blogs.json";
    ObjectMapper mapper = new ObjectMapper(); // mapeia objeto

    public List<Blog> getAll() {
        List<Blog> blogs = null;
        try {
            //mapper.readValue: esse metodo procura o arquivo passado no 1 parametro, e faz a leitura caso
            //encontre e tenta converter para o tipo do dado do 2 parametro que nesse caso é Array de Blog.
            blogs = Arrays.asList(mapper.readValue(new File(linkFile), Blog[].class));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("não foi possivel ler esse arquivo");
        }
        return blogs;
    }

    public Blog createBlog(Blog blog) throws IdExistenteException {
        List<Blog> blogs = new ArrayList<>();
        blogs.addAll(getAll());
        Blog b = blogs.stream().filter(bl -> bl.getId() == blog.getId()).findAny().orElse(null);
        if (b != null) {
            throw new IdExistenteException("Id ja existente no banco de dados");
        }
        blog.setDataPublicacao(LocalDate.now().toString());
        blogs.add(blog);
        try {
            mapper.writeValue(new File(linkFile), blogs);
        } catch (Exception ex) {
            ;
            ex.printStackTrace();
            System.out.println("erro ao salvar o  arquivo");
        }
        return blog;
    }

    public Blog consultarBlogId(int id) throws BlogInexistenteException {
        List<Blog> blogs = getAll();
        return blogs.stream().filter(b -> b.getId() == id).findAny().orElseThrow(() -> new BlogInexistenteException("id não encontrado"));
    }
}
