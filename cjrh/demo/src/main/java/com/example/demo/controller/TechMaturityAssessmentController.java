package com.example.demo.controller;

import com.example.demo.entity.TechMaturityAssessment;
import com.example.demo.service.TechMaturityAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tech-maturity-assessments")
public class TechMaturityAssessmentController {
    
    @Autowired
    private TechMaturityAssessmentService techMaturityAssessmentService;
    
    @GetMapping
    public List<TechMaturityAssessment> getAllAssessments() {
        return techMaturityAssessmentService.list();
    }

    @GetMapping("/{id}")
    public TechMaturityAssessment getAssessmentById(@PathVariable Long id) {
        return techMaturityAssessmentService.getById(id);
    }

    @PostMapping
    public boolean createAssessment(@RequestBody TechMaturityAssessment assessment) {
        return techMaturityAssessmentService.save(assessment);
    }

    @PutMapping("/{id}")
    public boolean updateAssessment(@PathVariable Long id, @RequestBody TechMaturityAssessment assessment) {
        assessment.setId(id);
        return techMaturityAssessmentService.updateById(assessment);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAssessment(@PathVariable Long id) {
        return techMaturityAssessmentService.removeById(id);
    }
}