package com.example.taskreview.tasks;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public TaskResponse tasks(
      @RequestParam(required = false) PriorityLevel priority,
      @RequestParam(required = false) ReviewStatus status) {
    return taskService.findTasks(priority, status);
  }

  @PostMapping("/reviews")
  public ReviewResponse reviews(@RequestBody ReviewRequest request) {
    return taskService.saveReview(request);
  }
}
