package co.com.sofka.crud.service;
import co.com.sofka.crud.dto.GroupTodoDto;

import javax.validation.Valid;
import java.util.List;

public interface IGroupTodoService {

    public GroupTodoDto create(@Valid GroupTodoDto groupTodo);

    public List<GroupTodoDto> listTodo();

    public GroupTodoDto editTodo(@Valid GroupTodoDto groupTodo,@Valid Long id);

    public GroupTodoDto getTodoById(@Valid Long id);

    public boolean deleteTodo(@Valid Long id);
}
