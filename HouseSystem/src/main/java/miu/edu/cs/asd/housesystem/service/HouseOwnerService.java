package miu.edu.cs.asd.housesystem.service;

import miu.edu.cs.asd.housesystem.model.House;
import miu.edu.cs.asd.housesystem.model.HouseOwner;

import java.util.List;
import java.util.Optional;

public interface HouseOwnerService  {
    Optional<HouseOwner> addHouseOwner(HouseOwner houseOwner);
    Optional<HouseOwner>  updateHouseOwner(HouseOwner houseOwner);
    void deleteHouseOwner(HouseOwner houseOwner);
    Optional<HouseOwner> findHouseOwnerByName(String houseOwnerName);
    List<HouseOwner> findAllHouseOwner();
}
