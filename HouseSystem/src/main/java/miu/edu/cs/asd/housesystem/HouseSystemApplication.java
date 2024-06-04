package miu.edu.cs.asd.housesystem;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.housesystem.dao.HouseOwnerRepository;
import miu.edu.cs.asd.housesystem.dao.HouseRepository;
import miu.edu.cs.asd.housesystem.model.House;
import miu.edu.cs.asd.housesystem.model.HouseOwner;
import miu.edu.cs.asd.housesystem.service.impl.HouseOwnerServiceImpl;
import miu.edu.cs.asd.housesystem.service.impl.HouseServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HouseSystemApplication implements CommandLineRunner {
    private final HouseRepository houseRepository;
    private final HouseOwnerRepository houseOwnerRepository;



    public static void main(String[] args) {
        SpringApplication.run(HouseSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        House house1 = new House("firstHouse");
        House house2 = new House("secondHouse");
        House house3 = new House("thirdHouse");
        House house4 = new House("fourthHouse");
        House house5 = new House("fifthHouse");
        House house6 = new House("sixthHouse");



//        houseService.addHouse(house1);
//        houseService.addHouse(house2);
//        houseService.addHouse(house3);
//        houseService.addHouse(house4);
//        houseService.addHouse(house5);
//        houseService.addHouse(house6);
        HouseOwner houseOwner = new HouseOwner("Joe", "737377373",
                Arrays.asList(house1, house2, house3));
        house1.setOwner(houseOwner);
        house2.setOwner(houseOwner);
        house3.setOwner(houseOwner);
        HouseOwner houseOwner1 = new HouseOwner("Doe", "747474848", Arrays.asList(
                house4, house5, house6
        ));
        house4.setOwner(houseOwner1);
        house5.setOwner(houseOwner1);
        house6.setOwner(houseOwner1);

        houseRepository.save(house1);
        houseRepository.save(house2);
        houseRepository.save(house3);
        houseRepository.save(house4);
        houseRepository.save(house5);
        houseRepository.save(house6);


//        houseService.addHouse(house1);
//        houseService.addHouse(house2);
//        houseService.addHouse(house3);
//        houseService.addHouse(house4);
//        houseService.addHouse(house5);
//        houseService.addHouse(house6);
        houseOwnerRepository.save(houseOwner);
        houseOwnerRepository.save(houseOwner1);

//       houseOwnerService.addHouseOwner(houseOwner);
//       houseOwnerService.addHouseOwner(houseOwner1)

        List<HouseOwner> houseOwners = houseOwnerRepository.findAll();


       houseOwners.stream()
               .sorted(Comparator.comparing(HouseOwner::getPhoneNumber))
               .forEach(System.out::println);

    }
}
