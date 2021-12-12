package ru.gb.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface ProductDao extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    Product save(Product product);
    void deleteById(Long id);
    List<Product> findAll(Sort sort);

}
