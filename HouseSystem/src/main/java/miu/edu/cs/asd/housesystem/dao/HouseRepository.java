package miu.edu.cs.asd.housesystem.dao;

import miu.edu.cs.asd.housesystem.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Long> {

    Optional<House> findByName(String name);
}
