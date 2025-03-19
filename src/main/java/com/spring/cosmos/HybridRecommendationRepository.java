package com.spring.cosmos;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.spring.cosmos.entity.HybridRecommendation;

import java.util.List;

public interface HybridRecommendationRepository extends CosmosRepository<HybridRecommendation, String> {
    List<HybridRecommendation> findByUserId(String userId);
}
