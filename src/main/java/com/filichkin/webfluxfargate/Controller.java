package com.filichkin.webfluxfargate;

import com.filichkin.webfluxfargate.dao.UserDao;
import com.filichkin.webfluxfargate.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@RestController
@RequestMapping("/user/v1")
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class Controller {
    UserDao userDao;
    @GetMapping("/{userId}")
    Mono<User> getUser(@PathVariable String userId){
      return userDao.get(userId);
    }
    @PostMapping("/")
    Mono<User> createUser(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        return userDao.update(user);
    }

    @DeleteMapping("/{userId}")
    Mono<ResponseEntity<Object>> deleteUser(@PathVariable String userId){
        return userDao.delete(userId)
                .thenReturn(ResponseEntity.noContent().build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
