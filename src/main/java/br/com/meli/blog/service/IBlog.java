package br.com.meli.blog.service;

import br.com.meli.blog.exceptions.BlogInexistenteException;
import br.com.meli.blog.exceptions.IdExistenteException;
import br.com.meli.blog.model.Blog;

import java.util.List;

// precisa de uma classe concreta para implementar os metodos da interface

public interface IBlog {
    // cadastra o blog e retorna o blog cadastrado
    Blog criarBLog(Blog blog) throws IdExistenteException;

    Blog consultarBlogId(int id) throws BlogInexistenteException;

    List<Blog> consultarLista();
}

