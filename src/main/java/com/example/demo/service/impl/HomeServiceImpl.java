package com.example.demo.service.impl;

import com.example.demo.entity.HomeEntity;
import com.example.demo.repository.HomeRepository;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HomeServiceImpl implements HomeService {
   final HomeRepository homeRepository;

   public HomeServiceImpl(HomeRepository homeRepository) {
      this.homeRepository = homeRepository;
   }


   @Override
   public HomeEntity create(HomeEntity home) {
      return homeRepository.save(home);
   }

   @Override
   public List<HomeEntity> getAll() {
      return homeRepository.findAll();
   }

   @Override
   public HomeEntity getHomeById(Long id) {
      return homeRepository.findById(id).orElse(null);
   }

   @Override
   public HomeEntity updateHome(Long id, HomeEntity updatedHome) {
      if (!homeRepository.existsById(id)) {
         throw new NoSuchElementException();
      }
      updatedHome.setId(id);
      return homeRepository.save(updatedHome);
   }

   @Override
   public void deleteHome(Long id) {
      homeRepository.deleteById(id);
   }
}
