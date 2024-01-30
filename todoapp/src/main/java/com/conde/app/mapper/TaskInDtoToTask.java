package com.conde.app.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.conde.app.persistence.entity.Task;
import com.conde.app.persistence.entity.TaskStatus;
import com.conde.app.service.dto.TaskInDto;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task> {

  @Override
  public Task map(TaskInDto in) {

    Task task = new Task();
    task.setTitle(in.getTitle());
    task.setDescription(in.getDescription());
    task.setEta(in.getEta());
    task.setCreateDate(LocalDateTime.now());
    task.setFinished(false);
    task.setTaskStatus(TaskStatus.BACKLOG);

    return task;
  }

}
