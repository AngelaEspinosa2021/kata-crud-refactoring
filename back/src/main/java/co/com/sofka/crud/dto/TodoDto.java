package co.com.sofka.crud.dto;

import javax.validation.constraints.NotBlank;

public class TodoDto {
    private Long id;

    @NotBlank
    private String name;

    private boolean completed;
    private Long groupListId;

    public TodoDto(String name, boolean completed, Long groupListId){
        this.name=name;
        this.completed=completed;
        this.groupListId=groupListId;
    }

    public TodoDto(Long id, String name, boolean completed, Long groupListId) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }

    public TodoDto(){

    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", groupListId=" + groupListId +
                '}';
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
        TodoDto other = (TodoDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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

    public Long getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(Long groupListId) {
        this.groupListId = groupListId;
    }
}
