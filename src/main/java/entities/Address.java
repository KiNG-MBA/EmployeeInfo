package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Long postalCode;

    private String postalAddress;

    private String city;

    @ManyToOne(targetEntity = Employee.class,cascade = CascadeType.REMOVE)
    private Employee employee;

    @OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.REMOVE)
    private Set<PhoneNumber> phoneNumbers;


}
