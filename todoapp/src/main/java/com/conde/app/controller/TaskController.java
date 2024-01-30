package com.conde.app.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.conde.app.persistence.entity.Task;
import com.conde.app.persistence.entity.TaskStatus;
import com.conde.app.service.TaskService;
import com.conde.app.service.dto.TaskInDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TaskController {

  private final TaskService service;

  @PostMapping
  public Task create(@RequestBody TaskInDto taskIn) {
    return this.service.create(taskIn);
  }

  @GetMapping
  public List<Task> findAll() {
    return this.service.findAll();
  }

  @GetMapping("/status/{status}")
  public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
    return this.service.findAllByStatus(status);
  }

  @PatchMapping("/mark_as_finished/{id}")
  public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
    this.service.updateTaskAsFinished(id);
    return ResponseEntity.noContent().build();
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    this.service.deleteById(id);
    return ResponseEntity.noContent().build();
  }


}
