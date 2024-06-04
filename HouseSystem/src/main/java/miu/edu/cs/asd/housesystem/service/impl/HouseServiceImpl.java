package miu.edu.cs.asd.housesystem.service.impl;

import lombok.Locked;
import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.housesystem.dao.HouseRepository;
import miu.edu.cs.asd.housesystem.model.House;
import miu.edu.cs.asd.housesystem.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public Optional<House> addHouse(House house) {
        return Optional.of(houseRepository.save(house));
    }

    @Override
    public Optional<House> updateHouse(House house) {
        Optional<House> houseOptional = houseRepository.findById(house.getId());
        houseOptional.ifPresent(value -> value.setName(house.getName()));
        return Optional.of(houseRepository.save(house));
    }

    @Override
    public void deleteHouse(House house) {
        houseRepository.findById(house.getId())
                .ifPresent(houseRepository::delete);

    }

    @Override
    public Optional<House> getHouseByName(String name) {
        return houseRepository.findByName(name);
    }


}
