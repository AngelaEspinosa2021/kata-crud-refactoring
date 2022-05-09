package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.GroupTodoDto;
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
    public Iterable<GroupTodoDto> list(){
        return service.listTodo();
    }

    @PostMapping(value = "api/groupTodo")
    public GroupTodoDto save(@RequestBody GroupTodoDto groupTodoDto){
        return service.create(groupTodoDto);
    }

    @PutMapping(value = "api/groupTodo")
    public GroupTodoDto update(@RequestBody GroupTodoDto groupTodoDto){
        if(groupTodoDto.getId_groupTodo() != null){
            return service.editTodo(groupTodoDto, groupTodoDto.getId_groupTodo());
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/groupTodo")
    public void delete(@PathVariable("id")Long id){
        service.deleteTodo(id);
    }

    @GetMapping(value = "api/{id}/groupTodo")
    public GroupTodoDto get(@PathVariable("id") Long id){
        return service.getTodoById(id);
    }

}
