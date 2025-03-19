package com.spring.cosmos;

import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosmosDBConfig extends AbstractCosmosConfiguration {

    @Value("${spring.cloud.azure.cosmos.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.azure.cosmos.key}")
    private String key;

    @Value("${spring.cloud.azure.cosmos.database}")
    private String databaseName;

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return new CosmosClientBuilder()
                .endpoint(endpoint)
                .key(key)
                .buildAsyncClient();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
