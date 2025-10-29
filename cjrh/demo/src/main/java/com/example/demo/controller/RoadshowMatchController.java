package com.example.demo.controller;

import com.example.demo.entity.RoadshowMatch;
import com.example.demo.service.RoadshowMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roadshow-matches")
public class RoadshowMatchController {
    
    @Autowired
    private RoadshowMatchService roadshowMatchService;
    
    @GetMapping
    public List<RoadshowMatch> getAllRoadshowMatches() {
        return roadshowMatchService.list();
    }

    @GetMapping("/{id}")
    public RoadshowMatch getRoadshowMatchById(@PathVariable Long id) {
        return roadshowMatchService.getById(id);
    }

    @PostMapping
    public boolean createRoadshowMatch(@RequestBody RoadshowMatch roadshowMatch) {
        return roadshowMatchService.save(roadshowMatch);
    }

    @PutMapping("/{id}")
    public boolean updateRoadshowMatch(@PathVariable Long id, @RequestBody RoadshowMatch roadshowMatch) {
        roadshowMatch.setId(id);
        return roadshowMatchService.updateById(roadshowMatch);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRoadshowMatch(@PathVariable Long id) {
        return roadshowMatchService.removeById(id);
    }
}