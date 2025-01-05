package com.example.todo.domain.service;

public interface Blogic<I,O> {
    O execute(I input);
}
