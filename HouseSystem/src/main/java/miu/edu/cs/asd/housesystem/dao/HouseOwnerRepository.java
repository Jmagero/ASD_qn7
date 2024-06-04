package miu.edu.cs.asd.housesystem.dao;

import miu.edu.cs.asd.housesystem.model.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

import java.util.Optional;

public interface HouseOwnerRepository extends JpaRepository<HouseOwner, Long> {
    Optional<HouseOwner> findByName(String name);
}
