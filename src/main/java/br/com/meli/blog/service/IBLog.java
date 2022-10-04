package br.com.meli.blog.service;

import br.com.meli.blog.model.Blog;

import java.util.ArrayList;
import java.util.List;

// precisa de uma classe concreta para implementar os metodos da interface

public interface IBLog {
    // cadastra o blog e retorna o blog cadastrado
    Blog criarBLog(Blog blog);

    Blog consultarBlogId(int id);

    List<Blog> consultarLista();
}

