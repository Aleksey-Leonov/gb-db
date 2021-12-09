package ru.gb.dao;

import ru.gb.entity.Client;
import ru.gb.entity.Order;

import java.util.List;

public interface ClientDao {

    List<Client> findAll();
    Client findById(Long id);


}
