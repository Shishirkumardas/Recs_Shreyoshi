package org.example.recs_shreyoshi.repositories;


import org.example.recs_shreyoshi.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Consumer findByName(String name);

}
