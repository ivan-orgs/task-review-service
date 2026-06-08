package com.example.taskreview.tasks;

import java.util.List;

public record TaskRow(
    String id,
    String team,
    String owner,
    PriorityLevel priority,
    PriorityLevel confidence,
    PriorityLevel suggestedPriority,
    ReviewStatus status,
    String summary,
    List<TaskCheck> checks,
    String updatedAt) {}
