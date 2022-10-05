package br.com.meli.blog.exceptions;

public class BlogInexistenteException extends Exception{
    public BlogInexistenteException(String message) {
        super(message);
    }
}
