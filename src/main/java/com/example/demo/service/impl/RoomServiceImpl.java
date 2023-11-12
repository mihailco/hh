package com.example.demo.service.impl;

import com.example.demo.entity.RoomEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomEntity create(RoomEntity room) {
        return roomRepository.save(room);
    }

    @Override
    public RoomEntity updateRoom(Long roomId, RoomEntity updatedRoom) {
        if (!roomRepository.existsById(roomId)) {
            throw new NoSuchElementException();
        }
        //я не знаю, правильно ли это
        var room = roomRepository.findById(roomId).get();
        room.setName(updatedRoom.getName());

        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
        }
    }
}
