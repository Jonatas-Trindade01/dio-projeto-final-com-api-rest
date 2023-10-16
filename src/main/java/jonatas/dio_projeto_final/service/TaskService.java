package jonatas.dio_projeto_final.service;

import jonatas.dio_projeto_final.model.Task;

public interface TaskService {

    Task findById(int id);

    Task create(Task task);
}
