package co.com.sofka.crud.repository;

import co.com.sofka.crud.model.GroupTodo;
import co.com.sofka.crud.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findByGroupListId(String groupListId);

    List<Todo> findByName(String name);

    List<Todo> findByGroupTodo(GroupTodo groupTodo);
}
