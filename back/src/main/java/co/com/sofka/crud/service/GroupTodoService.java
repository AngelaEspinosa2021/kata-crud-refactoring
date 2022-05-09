package co.com.sofka.crud.service;

import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupTodoService {
    @Autowired
    private TodoRepository groupTodoRepository;

    public Iterable<Todo> groupTodolist(){
        return groupTodoRepository.findAll();
    }

    public Todo saveTodo(Todo todo){
        return groupTodoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        groupTodoRepository.delete(getTodo(id));
    }

    public Todo getTodo(Long id){
        return groupTodoRepository.findById(id).orElseThrow();
    }
}
