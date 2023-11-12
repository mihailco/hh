package com.example.demo.controller;

import com.example.demo.dto.request.RoomRequest;
import com.example.demo.dto.response.RoomResponse;
import com.example.demo.mapper.RoomMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    final RoomMapper roomMapper;

    public RoomController(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @PostMapping
    public RoomResponse createRoom(@RequestParam long homeId, @Valid @RequestBody RoomRequest roomRequest) {
        return roomMapper.create(roomRequest, homeId);
    }

    @PutMapping("/{roomId}")
    public RoomResponse updateRoom(@PathVariable long roomId, @Valid @RequestBody RoomRequest roomRequest) {
        return roomMapper.updateRoom(roomId, roomRequest);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<?> deleteRoom(@NotNull @PathVariable long roomId) {
        roomMapper.deleteRoom(roomId);
        return ResponseEntity.ok("");
    }
}
