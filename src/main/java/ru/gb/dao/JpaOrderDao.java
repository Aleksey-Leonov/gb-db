package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
@Transactional

public class JpaOrderDao implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("select o from Order o").getResultList();
    }

    @Override
    public Order findByIdInf(Long id) {
        TypedQuery<Order> query = entityManager.createNamedQuery("ord.findByIdInf", Order.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Order save(Order order) {
//        if (order.getId() == null) {
//            entityManager.persist(order);
//        } else {
            entityManager.merge(order);
//        }
        return order;
    }

    @Override
    public BigDecimal finalAmount(List<Product> productList) {

        final BigDecimal  lastCost=BigDecimal.valueOf(productList.stream().mapToDouble(c->(c.getCost()).doubleValue()).sum());

        return lastCost;
    }


}
