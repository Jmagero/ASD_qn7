package miu.edu.cs.asd.housesystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"owner"})
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private HouseOwner owner;

    public House(String name, HouseOwner owner) {
        this.name = name;
        this.owner = owner;
    }

    public House(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "House{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", owner=" + owner +
//                '}';
//    }
}
