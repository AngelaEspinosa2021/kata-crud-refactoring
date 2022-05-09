package co.com.sofka.crud.service;

import co.com.sofka.crud.model.GroupTodo;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.GroupTodoRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupTodoService {
    @Autowired
    private GroupTodoRepository groupTodoRepository;

    public Iterable<GroupTodo> groupTodolist(){
        return groupTodoRepository.findAll();
    }

    public GroupTodo saveTodo(GroupTodo grouptodo){
        return groupTodoRepository.save(grouptodo);
    }

    public void deleteTodo(Long id){
        groupTodoRepository.delete(getTodo(id));
    }

    public GroupTodo getTodo(Long id){
        return groupTodoRepository.findById(id).orElseThrow();
    }

}
