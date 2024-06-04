package miu.edu.cs.asd.housesystem.service;

import miu.edu.cs.asd.housesystem.model.House;

import java.util.Optional;

public interface HouseService {
    Optional<House> addHouse(House house);
    Optional<House> updateHouse(House house);
    void deleteHouse(House house);
    Optional<House> getHouseByName(String name);
}
