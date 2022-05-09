package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TodoContraintsValidationExceptionTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void contraintsValidationExceptionTest(){

        assertThrows(ConstraintViolationException.class, ()->{todoService.create(new TodoDto(null,false, "2"));});
        assertThrows(ConstraintViolationException.class, ()->{todoService.create(new TodoDto(" ",false, "2"));});

    }
    @Test
    public void createTodoOk(){
       TodoDto todoDto =  todoService.create(new TodoDto("ver pelicula",false,"3"));
       assertNotNull(todoDto);
       assertEquals("ver pelicula",todoDto.getName() );
       assertNotNull(todoDto.getId());
    }

    @Test
    public void listTodo(){
        List<TodoDto> listTodoDto = todoService.listTodo();
        assertNotNull(listTodoDto);
    }
}
