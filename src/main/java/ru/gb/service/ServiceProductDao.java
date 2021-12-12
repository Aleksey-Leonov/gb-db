package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceProductDao {

    private final ProductDao productDao;

    @Transactional(readOnly = true)
    public List<Product> findAllSortedByCostIsDesc() {
        return productDao.findAll(Sort.by(Sort.Direction.DESC,"cost"));
    }
    @Transactional(readOnly = true)
    public List<Product> findAllSortedByCostIsASC() {
        return productDao.findAll(Sort.by(Sort.Direction.ASC,"cost"));
    }


}
