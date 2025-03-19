package com.spring.cosmos.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Container(containerName = "${spring.cloud.azure.cosmos.container}")
public class HybridRecommendation {

    @Id
    private String id;

    @PartitionKey
    private String userId;

    @JsonProperty("content_id")
    private List<ContentItem> contentId;

    @JsonProperty("model name")
    private String modelName;

    private String version;
}
