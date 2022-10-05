package br.com.meli.blog.dto;

import br.com.meli.blog.model.Blog;

import java.io.Serializable;


public class BlogDTO implements Serializable {
    private int id;
    private String titulo;
    private String nomeAutor;


    public BlogDTO(Blog blog){
        this.id = blog.getId();
    }

    public BlogDTO(String titulo, String nomeAutor) {
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
    }

    public BlogDTO() {
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }



    public void setId(int id) {
        this.id = id;


    }
}

