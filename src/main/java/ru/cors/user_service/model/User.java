package ru.cors.user_service.model;

import org.bson.types.ObjectId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true,sparse = true)
    private String username;

    private String password;

    @Indexed(unique = true,sparse = true)
    private String email;

    @Indexed(unique = true,sparse = true)
    private String phone;

    private List<String> roles;

    private Boolean isOauth;

    @Indexed(unique = true,sparse = true)
    private String googleId;

    @Indexed(unique = true,sparse = true)
    private String yandexId;

}
