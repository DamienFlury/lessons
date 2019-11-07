package ch.bbw.df.entites;

import javax.persistence.*;

@Entity
@Table(name = "food")
@NamedQuery(name = "Food.findAll", query = "select f from Food f")
public class Food {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                "price=" + price +
                '}';
    }

}
