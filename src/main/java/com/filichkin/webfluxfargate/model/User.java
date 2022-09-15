package com.filichkin.webfluxfargate.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamoDbBean
public class User {

    String id;
    String name;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
