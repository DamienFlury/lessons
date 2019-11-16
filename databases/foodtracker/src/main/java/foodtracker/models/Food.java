package foodtracker.models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "food")
@NamedQuery(name = "Food.findAll", query = "select f from Food f")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@ToString
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;


    

    // @Override
    // public String toString() {
    //     return "Food{" +
    //             "id=" + id +
    //             "price=" + price +
    //             '}';
    // }

}
