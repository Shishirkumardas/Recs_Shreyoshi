package org.example.recs_shreyoshi.repositories;


import org.example.recs_shreyoshi.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    Area findByName(String name);
}
