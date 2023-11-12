package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

public class HomeResponse {
   private Long id;
   private String name;
   private String address;

   private List<RoomResponse> rooms = new ArrayList<>();
}
