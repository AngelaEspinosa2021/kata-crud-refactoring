package co.com.sofka.crud.model;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean completed;
    private String groupListId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_group_todo")
    private GroupTodo groupTodo;

    public Todo(){

    }

    public Todo(String name, boolean completed, String groupListId, GroupTodo groupTodo) {
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
        this.groupTodo = groupTodo;
    }

    public GroupTodo getGroupTodo() {
        return groupTodo;
    }

    public void setGroupTodo(GroupTodo groupTodo) {
        this.groupTodo = groupTodo;
    }

    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", groupListId=" + groupListId +
                ", groupTodo=" + groupTodo +
                '}';
    }
}
