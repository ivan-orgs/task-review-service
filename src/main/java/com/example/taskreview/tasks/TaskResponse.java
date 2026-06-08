package com.example.taskreview.tasks;

import java.util.List;

public record TaskResponse(List<String> headers, List<TaskRow> rows) {}
