package ru.cors.user_service.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.cors.user_service.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {

    User findByUsername(String name);

}
