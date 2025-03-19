package com.spring.cosmos;

import com.spring.cosmos.entity.HybridRecommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<HybridRecommendation> createRecommendation(@RequestBody HybridRecommendation recommendation) {
        HybridRecommendation savedRecommendation = recommendationService.saveRecommendation(recommendation);
        return ResponseEntity.ok(savedRecommendation);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<HybridRecommendation>> getRecommendationsByUserId(@PathVariable String userId) {
        List<HybridRecommendation> recommendations = recommendationService.getByUserId(userId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HybridRecommendation> getRecommendationById(@PathVariable String id) {
        HybridRecommendation recommendation = recommendationService.getById(id);
        return recommendation != null ? ResponseEntity.ok(recommendation) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HybridRecommendation> updateRecommendation(@PathVariable String id, @RequestBody HybridRecommendation recommendation) {
        HybridRecommendation updatedRecommendation = recommendationService.updateRecommendation(id, recommendation);
        return ResponseEntity.ok(updatedRecommendation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable String id) {
        recommendationService.deleteRecommendation(id);
        return ResponseEntity.noContent().build();
    }
}
