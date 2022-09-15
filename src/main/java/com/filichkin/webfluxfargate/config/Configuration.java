package com.filichkin.webfluxfargate.config;

import com.filichkin.webfluxfargate.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public DynamoDbAsyncTable<User> dbAsyncTable(@Value("${dynamodb.table}") String table,@Value("${aws.region}")String region) {
        DynamoDbEnhancedAsyncClient client = DynamoDbEnhancedAsyncClient
                .builder()
                .dynamoDbClient(DynamoDbAsyncClient.builder().region(Region.of(region)).build())
                .build();
        return client.table(table, TableSchema.fromBean(User.class));
    }
}
