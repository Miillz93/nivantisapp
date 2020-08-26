package com.Nivantis.b3.nivantisapp.repositories;

import com.Nivantis.b3.nivantisapp.models.Price;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentPriceRepositories extends MongoRepository<Price , String> {

    Price findBy_id(ObjectId id);
}
