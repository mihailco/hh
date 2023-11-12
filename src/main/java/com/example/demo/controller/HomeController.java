package com.example.demo.controller;

import com.example.demo.dto.request.HomeRequest;
import com.example.demo.dto.response.HomeListResponse;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.mapper.HomeMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    public List<HomeListResponse> getHomes() {
        return homeMapper.getAll();
    }

    @PostMapping
    public HomeResponse createHome(@Valid @RequestBody HomeRequest homeRequest) {
        return homeMapper.create(homeRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        var home = homeMapper.getHomeById(id);
        if (home == null) {
            return new ResponseEntity<>("home not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(home);
    }

    @PutMapping("/{id}")
    public HomeResponse updateHome(@NotBlank @PathVariable("id") Long id, @Valid @RequestBody HomeRequest homeRequest) {
        return homeMapper.updateHome(id, homeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteHome(@PathVariable("id") Long id) {
        homeMapper.deleteHome(id);
    }
}
