package com.ramosvji.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ramosvji.app.repository.entity.Game;

@Repository
public interface GameRepository extends MongoRepository<Game,String> {

}
