package com.example.taskreview.tasks;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  private static final List<String> HEADERS = List.of("id", "team", "owner", "status");

  private final List<TaskRow> tasks =
      List.of(
          new TaskRow(
              "TASK-101",
              "Platform",
              "Asha Rao",
              PriorityLevel.HIGH,
              PriorityLevel.MEDIUM,
              PriorityLevel.LOW,
              ReviewStatus.PENDING,
              "The platform team is reviewing a release task that needs automated smoke checks before it can move forward.",
              List.of(
                  new TaskCheck("Smoke test checklist", true),
                  new TaskCheck("Reviewer sign-off", true),
                  new TaskCheck("Deployment note", false)),
              "2026-05-20T10:30:00.000Z"),
          new TaskRow(
              "TASK-102",
              "Data Tools",
              "Vikram Mehta",
              PriorityLevel.MEDIUM,
              null,
              null,
              ReviewStatus.REJECTED,
              "The data tools task is missing a sample file and needs clearer acceptance criteria.",
              List.of(
                  new TaskCheck("Sample file attached", false),
                  new TaskCheck("Acceptance criteria reviewed", true)),
              "2026-05-18T08:15:00.000Z"),
          new TaskRow(
              "TASK-103",
              "Support Ops",
              "Neha Singh",
              PriorityLevel.LOW,
              PriorityLevel.LOW,
              PriorityLevel.LOW,
              ReviewStatus.APPROVED,
              "The support operations task is ready because documentation and owner review are complete.",
              List.of(
                  new TaskCheck("Documentation updated", true),
                  new TaskCheck("Owner review", true)),
              "2026-05-12T14:00:00.000Z"));

  public TaskResponse findTasks(PriorityLevel priority, ReviewStatus status) {
    var rows =
        tasks.stream()
            .filter(task -> priority == null || task.priority() == priority)
            .filter(task -> status == null || task.status() == status)
            .toList();

    return new TaskResponse(HEADERS, rows);
  }

  public ReviewResponse saveReview(ReviewRequest request) {
    return new ReviewResponse(true, request);
  }
}
