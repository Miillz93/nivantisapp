package com.Nivantis.b3.nivantisapp.repositories;


import com.Nivantis.b3.nivantisapp.models.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositories extends MongoRepository<Users , String> {
    Users findBy_id(ObjectId _id);

    Users findByName(String name);

}
