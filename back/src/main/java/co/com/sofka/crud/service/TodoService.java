package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TodoDto create(TodoDto todo) {
        Todo todoEntity = modelMapper.map(todo, Todo.class);
        todoRepository.save(todoEntity);
        return modelMapper.map(todoEntity, TodoDto.class);
    }

    @Override
    public List<TodoDto> listTodo() {
        List<Todo> todoEntity = todoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();
        for(Todo todo: todoEntity)
        {
            TodoDto todoDto = modelMapper.map(todoEntity, TodoDto.class);
            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }

    @Override
    public TodoDto editTodo(TodoDto todo, Long idTodo) {
        Optional<Todo> item = todoRepository.findById(idTodo);
        Todo todoEntity = new Todo();
        if( idTodo == todoEntity.getId())
        {
            todoEntity = modelMapper.map(todo, Todo.class );
            todoRepository.save(todoEntity);
        }
        return modelMapper.map(todoEntity, TodoDto.class);
    }

    @Override
    public List<TodoDto> getListTodoByGroupListId(String groupListId) {
        List<Todo> todoEntity = todoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();
        for(Todo todo: todoEntity){
            if(todo.getGroupListId() == groupListId){
                TodoDto todoDto = modelMapper.map(todoEntity, TodoDto.class);
                todoDtoList.add(todoDto);
            }
        }

        return todoDtoList;
    }

    @Override
    public TodoDto getTodoById(Long id){
        Optional<Todo> todoEntity = todoRepository.findById(id);
        return modelMapper.map(todoEntity, TodoDto.class);
    }

    @Override
    public boolean deleteTodo(Long id){
        try{
            todoRepository.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }
    }

}
