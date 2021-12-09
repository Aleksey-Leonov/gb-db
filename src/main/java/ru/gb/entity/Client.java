package ru.gb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "client.findById",
                query = "select o from Client o where o.id = :id")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_name")
    private String status;


    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Order> orders;


    public boolean addOrder(Order order) {
        if (orders == null) {
            orders = new HashSet<>();
        }
        return orders.add(order);
    }
}
