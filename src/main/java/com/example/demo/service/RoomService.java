package com.example.demo.service;

import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomEntity;

import java.util.List;

public interface RoomService {
    RoomEntity create(RoomEntity home);
    RoomEntity updateRoom(Long roomId, RoomEntity updatedRoom);
    void deleteRoom(Long id);
}
