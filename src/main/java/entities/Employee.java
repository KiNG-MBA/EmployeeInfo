package entities;

import com.sun.corba.se.impl.ior.GenericIdentifiable;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String fullName;

    private Long empCode;

    private Double salary;

    @OneToMany(targetEntity = Address.class,cascade =CascadeType.REMOVE)
    private Set<Address> addresses;
}
