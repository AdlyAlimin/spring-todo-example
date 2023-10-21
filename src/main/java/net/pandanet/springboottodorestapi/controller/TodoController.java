package net.pandanet.springboottodorestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.pandanet.springboottodorestapi.entity.Todo;
import net.pandanet.springboottodorestapi.service.TodoService;

@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long todoId) {
        Todo todo = todoService.getTodoById(todoId);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable("id") Long todoId,
            @RequestBody Todo todo) {
        todo.setId(todoId);

        Todo updatedTodo = todoService.updateTodo(todo);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>("Todo Successful Deleted", HttpStatus.OK);
    }
}
