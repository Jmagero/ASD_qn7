package miu.edu.cs.asd.housesystem.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.housesystem.dao.HouseOwnerRepository;
import miu.edu.cs.asd.housesystem.model.HouseOwner;
import miu.edu.cs.asd.housesystem.service.HouseOwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseOwnerServiceImpl implements HouseOwnerService {
    private final HouseOwnerRepository houseOwnerRepository;
    @Override
    public Optional<HouseOwner> addHouseOwner(HouseOwner houseOwner) {
        return Optional.of(houseOwnerRepository.save(houseOwner));
    }

    @Override
    public Optional<HouseOwner> updateHouseOwner(HouseOwner houseOwner) {
        Optional<HouseOwner> houseOwnerOptional = houseOwnerRepository.findById(houseOwner.getId());
        if(houseOwnerOptional.isPresent()) {
            houseOwnerOptional.get().setName(houseOwner.getName());
            houseOwnerOptional.get().setPhoneNumber(houseOwner.getPhoneNumber());
        };
        return Optional.of(houseOwnerRepository.save(houseOwner));
    }

    @Override
    public void deleteHouseOwner(HouseOwner houseOwner) {
        houseOwnerRepository.findByName(houseOwner.getName())
                        .ifPresent(h -> houseOwnerRepository.delete(houseOwner));
    }

    @Override
    public Optional<HouseOwner> findHouseOwnerByName(String houseOwnerName) {
        return houseOwnerRepository.findByName(houseOwnerName);
    }

    @Override
    public List<HouseOwner> findAllHouseOwner() {
        return houseOwnerRepository.findAll();
    }
}
