package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Cart;

public interface CartDao extends CrudRepository<Cart, Long> {

}
