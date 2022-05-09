package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;

import javax.validation.Valid;
import java.util.List;

public interface ITodoService {
    public TodoDto create(@Valid TodoDto todo);

    public List<TodoDto> listTodo();
}
