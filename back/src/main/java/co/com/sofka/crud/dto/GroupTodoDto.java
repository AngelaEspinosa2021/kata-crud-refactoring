package co.com.sofka.crud.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class GroupTodoDto {
    private Long id_groupTodo;

    @NotBlank
    private String name;
    private List<TodoDto> todoList;

    public GroupTodoDto(Long id_groupTodo, String name, List<TodoDto> todoList) {
        this.id_groupTodo = id_groupTodo;
        this.name = name;
        this.todoList = todoList;
    }

    public GroupTodoDto(String name, List<TodoDto> todoList) {
        this.name = name;
        this.todoList = todoList;
    }

    public GroupTodoDto() {
    }

    public static Long getId_groupTodo() {
        return id_groupTodo;
    }

    public void setId_groupTodo(Long id_groupTodo) {
        this.id_groupTodo = id_groupTodo;
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
