package jonatas.dio_projeto_final.service.impl;

import jonatas.dio_projeto_final.model.Task;
import jonatas.dio_projeto_final.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TaskServiceImple implements jonatas.dio_projeto_final.service.TaskService {

    private final TaskRepository repository;

    public TaskServiceImple(TaskRepository taskRepository){
        this.repository = taskRepository;
    }


    @Override
    public Task findById(int id) {
       return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Task create(Task task) {
       if(task.getId() != 0 && repository.existsById(task.getId())){
           throw new IllegalArgumentException("This task ID already exists.");
       }
       return repository.save(task);
    }

}
