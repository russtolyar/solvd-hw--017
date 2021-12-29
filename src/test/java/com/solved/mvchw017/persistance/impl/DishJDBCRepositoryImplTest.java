package com.solved.mvchw017.persistance.impl;

import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.persistence.impl.DishJDBCRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DishJDBCRepositoryImplTest {


    @Test
    public  void createTest(){
        DishJDBCRepositoryImpl dishJDBCRepository = new DishJDBCRepositoryImpl();
        //1. Open DB restaurantdb
        //2. Execute DDl
        //2. Execute DMl

       Dish fish = new Dish();
       fish.setName("MyFish");
       fish.setType("Normal");

       Long id = dishJDBCRepository.create(fish,  2L);
       Dish fishSaved = dishJDBCRepository.findById(id);
       assertEquals(id, fishSaved.getId());
       assertEquals(fish.getName(), fishSaved.getName());
    }

//    @DataProvider (name="passwords")
//    public Object [][] passwards (){
//        return  new Object[][]{
//                {"abcd", "test@test.com"},
//                {"abcde1","test@test.com" }
//        };
//    }
//
//    @Test (dataProvider = "passwords")
//    public void test1 (String passwords, String email){

//    }
}
