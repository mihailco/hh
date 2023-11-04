package com.example.demo.mapper;

import com.example.demo.dto.request.HomeRequest;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.entity.HomeEntity;
import com.example.demo.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HomeMapper {
   private final ModelMapper basicMapper;
   final HomeService homeService;


   public HomeResponse create(HomeRequest home) {
      HomeEntity homeEntity = basicMapper.map(home, HomeEntity.class);
      return basicMapper.map(homeService.create(homeEntity), HomeResponse.class);
   }

   public List<HomeResponse> getAll() {
      return homeService.getAll().stream()
              .map((e) -> basicMapper.map(e, HomeResponse.class)).toList();
   }

   public HomeResponse getHomeById(Long id) {
      return basicMapper.map(homeService.getHomeById(id), HomeResponse.class);
   }

   public HomeResponse updateHome(Long id, HomeRequest updatedHome) {
      HomeEntity homeEntity = basicMapper.map(updatedHome, HomeEntity.class);
      return basicMapper.map(homeService.updateHome(id, homeEntity), HomeResponse.class);
   }

   public void deleteHome(Long id) {
      homeService.deleteHome(id);
   }
}
