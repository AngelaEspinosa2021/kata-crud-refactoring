package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;
/*
    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }*/

    @Override
    public TodoDto create(TodoDto todo) {
        Todo todoEntity = modelMapper.map(todo, Todo.class);
        todoRepository.save(todoEntity);
        return modelMapper.map(todoEntity, TodoDto.class);
    }
}
