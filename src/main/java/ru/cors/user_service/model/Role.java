package ru.cors.user_service.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roles")
public class Role {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String value = "USER";
}
