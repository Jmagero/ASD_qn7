package miu.edu.cs.asd.housesystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"houses"} )
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    List<House> houses;

    public HouseOwner(String name, String phoneNumber, List<House> houses) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "HouseOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", houses=" + houses +
                '}';
    }
}
