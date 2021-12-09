package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Client;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaClientDao implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("select c from Client c").getResultList();
    }

    @Override
    public Client findById(Long id) {
        TypedQuery<Client> query = entityManager.createNamedQuery("client.findById", Client.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
