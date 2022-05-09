package co.com.sofka.crud.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class GroupTodoDto {
    private Long id;

    @NotBlank
    private String name;
    private List<TodoDto> todoList;

    public GroupTodoDto(Long id_groupTodo, String name) {
        this.id = id_groupTodo;
        this.name = name;
    }

    public GroupTodoDto(String name) {
        this.name = name;
    }

    public GroupTodoDto() {
    }

    public Long getId_groupTodo() {
        return id;
    }

    public void setId_groupTodo(Long id_groupTodo) {
        this.id = id_groupTodo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoDto> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoDto> todoList) {
        this.todoList = todoList;
    }


}
