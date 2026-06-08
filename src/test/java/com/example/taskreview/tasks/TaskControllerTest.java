package com.example.taskreview.tasks;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  void returnsFilteredTasks() throws Exception {
    mockMvc
        .perform(get("/tasks").param("priority", "HIGH").param("status", "PENDING"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.rows", hasSize(1)))
        .andExpect(jsonPath("$.rows[0].id").value("TASK-101"));
  }

  @Test
  void savesReview() throws Exception {
    mockMvc
        .perform(
            post("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                    {
                      "id": "TASK-101",
                      "review": "APPROVED",
                      "note": "Approved from test"
                    }
                    """))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.saved").value(true))
        .andExpect(jsonPath("$.received.id").value("TASK-101"));
  }
}
