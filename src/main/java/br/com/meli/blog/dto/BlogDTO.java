package br.com.meli.blog.dto;

import br.com.meli.blog.model.Blog;

import java.io.Serializable;


public class BlogDTO implements Serializable {
    private int id;
    private String titulo;
    private String nomeAutor;
    private String dataPublicacao;


    public BlogDTO(Blog blog){
        this.id = blog.getId();
    }

    public BlogDTO(String titulo, String nomeAutor, String dataPublicacao) {
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.dataPublicacao = dataPublicacao;
    }

    public BlogDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

