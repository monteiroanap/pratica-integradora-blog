package br.com.meli.blog.model;


public class Blog {
    private int id;
    private String titulo;
    private String nomeAutor;
    private String dataPublicacao;

    public Blog(int id, String titulo, String nomeAutor, String dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.dataPublicacao = dataPublicacao;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
