package top.starrysea.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import top.starrysea.dto.Hello;

@Repository
public interface HelloRepository extends ReactiveMongoRepository<Hello, Long> {

}
