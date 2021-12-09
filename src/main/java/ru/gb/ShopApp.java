package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.*;
import ru.gb.entity.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShopApp {



    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(JpaConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        ClientDao clientDao=context.getBean(ClientDao.class);
        OrderDao   orderDao=context.getBean(OrderDao.class);


        List<Product> productList = new ArrayList<>(productDao.findAll().subList(1,4));
        Order testOrder = Order.builder()
                .products(productList.toString())
                .cost(orderDao.finalAmount(productDao.findAll().subList(1,4)))
                .client(clientDao.findById(2L))
                .build();
        System.out.println(testOrder);
        orderDao.save(testOrder);
//        CartDao cartDao = context.getBean(CartDao.class);

//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }


//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println("-----------------------");
//        System.out.println(manufacturerDao.findById(4L).getProducts());
//        Manufacturer manufacturer = manufacturerDao.findById(4L);
//        // УДАЛЕНИЕ
//        manufacturerDao.delete(manufacturer);
////        System.out.println("-----------------------");
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        Manufacturer testManufacturer = Manufacturer.builder()
//                .name("Company 4")
//                .products(new HashSet<Product>(((List<Product>) productDao.findAll()).subList(1, 5)))
//                .build();
//        System.out.println(testManufacturer);
//
//        manufacturerDao.save(testManufacturer);
//        System.out.println(testManufacturer);
//        Manufacturer savedManufacturer = manufacturerDao.findById(3L);
//        savedManufacturer.setName("Apple");
//        manufacturerDao.save(savedManufacturer);

//        manufacturerDao.deleteById(3L);

//        Product product = ((List<Product>) productDao.findAll()).get(5);
//
//        Cart cart = new Cart();
//        cart.addProduct(product);
//        cartDao.save(cart);
    }
}
