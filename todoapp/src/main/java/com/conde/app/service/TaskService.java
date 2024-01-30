package com.conde.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.conde.app.exceptions.ToDoExceptions;
import com.conde.app.mapper.TaskInDtoToTask;
import com.conde.app.persistence.entity.Task;
import com.conde.app.persistence.entity.TaskStatus;
import com.conde.app.persistence.repository.TaskRepository;
import com.conde.app.service.dto.TaskInDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TaskService {

  private final TaskRepository repository;
  private final TaskInDtoToTask mapper;

  public Task create(TaskInDto taskIn) {
    Task task = mapper.map(taskIn);
    return this.repository.save(task);
  }
  
  public List<Task> findAll(){
    return this.repository.findAll();
  }
  
  public List<Task> findAllByStatus(TaskStatus status){
    return this.repository.findAllByTaskStatus(status);
  }
  
  @Transactional
  public void updateTaskAsFinished(Long id) {
    Optional<Task> optionalTask = repository.findById(id);
    if (optionalTask.isEmpty()) {
      throw new ToDoExceptions("Task Not Found", HttpStatus.NOT_FOUND);
    }
    this.repository.markTaskAsFinished(id);
  }
  
  public void deleteById(Long id) {
    Optional<Task> optionalTask = repository.findById(id);
    if (optionalTask.isEmpty()) {
      throw new ToDoExceptions("Task Not Found", HttpStatus.NOT_FOUND);
    }
    this.repository.deleteById(id);
  }
}
