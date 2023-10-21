package net.pandanet.springboottodorestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.pandanet.springboottodorestapi.entity.Todo;
import net.pandanet.springboottodorestapi.repository.TodoRepository;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        return optionalTodo.get();
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).get();

        existingTodo.setSubject(todo.getSubject());

        Todo updatedTodo = todoRepository.save(existingTodo);

        return updatedTodo;
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
