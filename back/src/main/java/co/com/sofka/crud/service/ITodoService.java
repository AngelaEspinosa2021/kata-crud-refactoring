package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;

import javax.validation.Valid;
import java.util.List;

public interface ITodoService {
    public TodoDto create(@Valid TodoDto todo);

    public List<TodoDto> listTodo();

    public Todo editTodo(@Valid TodoDto todo, Long id);
}
