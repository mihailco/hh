package com.example.demo.service;

import com.example.demo.entity.HomeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HomeService {
   HomeEntity create(HomeEntity home);
   List<HomeEntity> getAll();
   HomeEntity getHomeById(Long id);
   HomeEntity updateHome(Long id, HomeEntity updatedHome);
   void deleteHome(Long id);
}
