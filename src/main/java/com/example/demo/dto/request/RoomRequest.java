package com.example.demo.dto.request;

import com.example.demo.entity.HomeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoomRequest {
    @NotBlank(message = "name is required")
    String name;
}
