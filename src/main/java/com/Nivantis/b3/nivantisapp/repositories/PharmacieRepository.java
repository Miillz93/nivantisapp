package com.Nivantis.b3.nivantisapp.repositories;

import com.Nivantis.b3.nivantisapp.models.Pharmacie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieRepository extends MongoRepository<Pharmacie, String> {
}
