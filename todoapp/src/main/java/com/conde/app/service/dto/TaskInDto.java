package com.conde.app.service.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TaskInDto {
  private String title;
  private String description;
  private LocalDateTime eta;
}
