package com.spring.cosmos;

import com.spring.cosmos.entity.HybridRecommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final HybridRecommendationRepository repository;

    public HybridRecommendation saveRecommendation(HybridRecommendation recommendation) {
        return repository.save(recommendation);
    }

    public List<HybridRecommendation> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public HybridRecommendation getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public HybridRecommendation updateRecommendation(String id, HybridRecommendation recommendation) {
        HybridRecommendation existingRecommendation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));

        // Update fields
        existingRecommendation.setUserId(recommendation.getUserId());
        existingRecommendation.setContentId(recommendation.getContentId());
        existingRecommendation.setModelName(recommendation.getModelName());
        existingRecommendation.setVersion(recommendation.getVersion());

        return repository.save(existingRecommendation);
    }

    public void deleteRecommendation(String id) {
        repository.deleteById(id);
    }
}