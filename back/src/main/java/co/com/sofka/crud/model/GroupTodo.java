package co.com.sofka.crud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="group_todo")
public class GroupTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_groupTodo;

    private String name;
    private List<Todo> todoList;

    public GroupTodo(){

    }

    public GroupTodo(String name, List<Todo> todoList) {
        this.name = name;
        this.todoList = todoList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GroupTodo other = (GroupTodo) obj;
        if (id_groupTodo == null) {
            if (other.id_groupTodo != null)
                return false;
        } else if (!id_groupTodo.equals(other.id_groupTodo))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_groupTodo == null) ? 0 : id_groupTodo.hashCode());
        return result;
    }
}
