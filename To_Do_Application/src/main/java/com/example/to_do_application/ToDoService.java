package com.example.to_do_application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
//    private final ToDo toDo;
    private final ToDoRepo toDoRepo;

    public List<ToDo> fetchAllToDo(){
            return toDoRepo.findAll();
    }

    public ToDo getToDoById(int id)
    {
        return toDoRepo.findById(id).orElseThrow(() ->
        new RuntimeException("Unable to find Expense with id:-" + id ));
    }

    public ToDo addToDo(ToDo toDo)
    {
        return toDoRepo.save(toDo);
    }

    public void deleteAToDo(int id)
    {
        getToDoById(id);
        toDoRepo.deleteById(id);
    }

    public ToDo updateToDo(ToDo toDo)
    {
        getToDoById(toDo.getId());
        return toDoRepo.save(toDo);
    }
}
