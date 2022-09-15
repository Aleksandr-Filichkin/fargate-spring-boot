package com.filichkin.webfluxfargate.dao;

import com.filichkin.webfluxfargate.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.UUID;

@Repository
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserDao {
    DynamoDbAsyncTable<User> dbAsyncTable;

    public Mono<User> get(String id) {
        return Mono.fromFuture(dbAsyncTable.getItem(Key.builder().partitionValue(id).build()));
    }

    public Mono<User> update(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        return Mono.fromFuture(dbAsyncTable.updateItem(user));
    }

    public Mono<User> delete(String id) {
        return Mono.fromFuture(dbAsyncTable.getItem(Key.builder().partitionValue(id).build()));
    }
}
