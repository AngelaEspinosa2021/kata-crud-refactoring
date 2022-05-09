package co.com.sofka.crud.controller;

import co.com.sofka.crud.model.GroupTodo;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.service.GroupTodoService;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GroupTodoController {

    @Autowired
    private GroupTodoService service;

    @GetMapping(value = "api/grouptodos")
    public Iterable<GroupTodo> list(){
        return service.groupTodolist();
    }

    @PostMapping(value = "api/groupTodo")
    public GroupTodo save(@RequestBody GroupTodo groupTodo){
        return service.saveTodo(groupTodo);
    }

    @PutMapping(value = "api/groupTodo")
    public GroupTodo update(@RequestBody GroupTodo groupTodo){
        if(groupTodo.getId_groupTodo() != null){
            return service.saveTodo(groupTodo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/groupTodo")
    public void delete(@PathVariable("id")Long id){
        service.deleteTodo(id);
    }

    @GetMapping(value = "api/{id}/groupTodo")
    public GroupTodo get(@PathVariable("id") Long id){
        return service.getTodo(id);
    }

}
