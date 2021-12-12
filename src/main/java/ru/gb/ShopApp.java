package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.*;
import ru.gb.entity.*;
import ru.gb.service.ServiceProductDao;

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
        ServiceProductDao serviceProductDao =
                context.getBean(ServiceProductDao.class);
        System.out.println(serviceProductDao.findAllSortedByCostIsDesc());
        System.out.println(serviceProductDao.findAllSortedByCostIsASC());

    }

    }

