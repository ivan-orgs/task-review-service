package com.example.taskreview.tasks;

import java.util.List;

// DTO returned by GET /tasks/filters.
// priorities: distinct PriorityLevel values present in the task data.
// statuses:   distinct ReviewStatus values present in the task data.
public record FilterOptionsResponse(
    List<PriorityLevel> priorities,
    List<ReviewStatus> statuses) {}
