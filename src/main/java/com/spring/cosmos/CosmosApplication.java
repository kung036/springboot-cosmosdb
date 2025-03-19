package com.spring.cosmos;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.spring.cosmos.entity.ContentItem;
import com.spring.cosmos.entity.HybridRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCosmosRepositories
@DependsOn("expressionResolver")
public class CosmosApplication {
	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}
}