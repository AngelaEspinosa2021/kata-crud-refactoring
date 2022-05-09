package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.GroupTodoDto;
import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.GroupTodo;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.GroupTodoRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class GroupTodoService  implements IGroupTodoService{
    @Autowired
    private GroupTodoRepository groupTodoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GroupTodoDto create(GroupTodoDto groupTodo) {
        GroupTodo groupTodoEntity = modelMapper.map(groupTodo, GroupTodo.class);
        groupTodoRepository.save(groupTodoEntity);
        return modelMapper.map(groupTodoEntity, GroupTodoDto.class);
    }

    @Override
    public List<GroupTodoDto> listTodo() {
        List<GroupTodo> groupTodoEntity = groupTodoRepository.findAll();
        List<GroupTodoDto> groupTodoDtoList = new ArrayList<>();
        for(GroupTodo groupTodo: groupTodoEntity)
        {
            GroupTodoDto groupTodoDto = modelMapper.map(groupTodoEntity, GroupTodoDto.class);
            groupTodoDtoList.add(groupTodoDto);
        }
        return groupTodoDtoList;

    }

    @Override
    public GroupTodoDto editTodo(GroupTodoDto groupTodo, Long id) {
        Optional<GroupTodo> item = groupTodoRepository.findById(id);
        GroupTodo groupTodoEntity = new GroupTodo();
        if( id == groupTodoEntity.getId_groupTodo())
        {
            groupTodoEntity = modelMapper.map(groupTodo, GroupTodo.class );
            groupTodoRepository.save(groupTodoEntity);
        }
        return modelMapper.map(groupTodoEntity, GroupTodoDto.class);
    }

    @Override
    public GroupTodoDto getTodoById(Long id) {
        Optional<GroupTodo> groupTodoEntity = groupTodoRepository.findById(id);
        return modelMapper.map(groupTodoEntity, GroupTodoDto.class);
    }

    @Override
    public boolean deleteTodo(Long id) {
        try{
            groupTodoRepository.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }
    }

}
