package com.example.demo.controller;

import com.example.demo.dto.request.HomeRequest;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.mapper.HomeMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomeController {
   private final HomeMapper homeMapper;

   public HomeController(HomeMapper homeMapper) {
      this.homeMapper = homeMapper;
   }

   @GetMapping
   public ResponseEntity<List<HomeResponse>> getHomes() {
      return ResponseEntity.ok(
              homeMapper.getAll()
      );
   }

   @PostMapping
   public ResponseEntity<HomeResponse> createHome( @RequestBody HomeRequest homeRequest) {
      return ResponseEntity.ok(homeMapper.create(homeRequest));
   }

   @GetMapping("/{id}")
   public ResponseEntity<HomeResponse> getById(@PathVariable("id") Long id) {
      return ResponseEntity.ok(homeMapper.getHomeById(id));
   }

   @PutMapping("/{id}")
   public ResponseEntity<HomeResponse> updateHome(@PathVariable("id") Long id, @RequestBody HomeRequest homeRequest) {
      return ResponseEntity.ok(homeMapper.updateHome(id, homeRequest));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteHome(@PathVariable("id") Long id) {
      homeMapper.deleteHome(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
