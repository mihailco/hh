package com.example.demo.mapper;

import com.example.demo.dto.request.HomeRequest;
import com.example.demo.dto.request.RoomRequest;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.dto.response.RoomResponse;
import com.example.demo.entity.HomeEntity;
import com.example.demo.entity.RoomEntity;
import com.example.demo.service.RoomService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomMapper {
    @PersistenceContext
    private EntityManager entityManager;
    private final ModelMapper basicMapper;
    private final RoomService roomService;

    public RoomResponse create(RoomRequest roomRequest, long homeId) {
        RoomEntity room = basicMapper.map(roomRequest, RoomEntity.class);
        HomeEntity homeEntity = entityManager.getReference(HomeEntity.class, homeId);
        room.setHome(homeEntity);
        return basicMapper.map(roomService.create(room), RoomResponse.class);
    }

    public RoomResponse updateRoom(Long roomId, RoomRequest updatedRoom) {
        RoomEntity roomEntity = basicMapper.map(updatedRoom, RoomEntity.class);
        return basicMapper.map(roomService.updateRoom(roomId, roomEntity), RoomResponse.class);
    }

    public void deleteRoom(long roomId) {
        roomService.deleteRoom(roomId);
    }
}
