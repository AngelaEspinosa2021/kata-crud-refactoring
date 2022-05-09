package co.com.sofka.crud.repository;

import co.com.sofka.crud.model.GroupTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupTodoRepository extends JpaRepository<GroupTodo, Long> {
    List<GroupTodo> findByName(String name);
}
