package net.pandanet.springboottodorestapi.service;

import java.util.List;

import net.pandanet.springboottodorestapi.entity.Todo;

public interface TodoService {
    
    Todo createTodo(Todo todo);

    Todo getTodoById(Long todoId);

    List<Todo> getAllTodos();

    Todo updateTodo(Todo todo);

    void deleteTodo(Long todoId);
}
