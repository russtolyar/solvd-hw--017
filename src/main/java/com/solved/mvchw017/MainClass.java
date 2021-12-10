package com.solved.mvchw017;

import com.solved.mvchw017.domain.*;
import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.department.Product;
import com.solved.mvchw017.domain.department.Staff;
import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.domain.menu.Menu;
import com.solved.mvchw017.service.*;
import com.solved.mvchw017.service.impl.*;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MainClass {
    public static void main(String[] args) {

        Address addressOne = new Address();
        addressOne.setCity("Minsk");
        addressOne.setStreet("Zhukov");
        addressOne.setNumberHouse(1);
        addressOne.setNumberFlat(100);

        Address addressTwo = new Address();
        addressTwo.setCity("Fanipol");
        addressTwo.setStreet("Sovet");
        addressTwo.setNumberHouse(2);
        addressTwo.setNumberFlat(5);

        Address addressThree = new Address();
        addressThree.setCity("");
        addressThree.setStreet("Zhukov");
        addressThree.setNumberHouse(3);
        addressThree.setNumberFlat(9);

        Address addressFour = new Address();
        addressFour.setCity("Minsk");
        addressFour.setStreet("Krasnaya");
        addressFour.setNumberHouse(4);
        addressFour.setNumberFlat(90);

        Address addressFive = new Address();
        addressFive.setCity("Zaslavl");
        addressFive.setStreet("Dachnaya");
        addressFive.setNumberHouse(5);
        addressFive.setNumberFlat(50);

        Address addressSix = new Address();
        addressSix.setCity("Drozdy");
        addressSix.setStreet("Levaya");
        addressSix.setNumberHouse(6);
        addressSix.setNumberFlat(30);

        Address addressSeven = new Address();
        addressSeven.setCity("Minsk");
        addressSeven.setStreet("Centr");
        addressSeven.setNumberHouse(7);
        addressSeven.setNumberFlat(55);

        Address addressEight = new Address();
        addressEight.setCity("Minsk");
        addressEight.setStreet("Grusheva");
        addressEight.setNumberHouse(8);
        addressEight.setNumberFlat(22);

        Address addressNine = new Address();
        addressNine.setCity("Minsk");
        addressNine.setStreet("Usataya");
        addressNine.setNumberHouse(9);
        addressNine.setNumberFlat(47);

        Drink drinkOne = new Drink();
        drinkOne.setName("MilkShake");
        drinkOne.setAlcoholic(false);

        Drink drinkTwo = new Drink();
        drinkTwo.setName("Tea");
        drinkTwo.setAlcoholic(false);

        Drink drinkThree = new Drink();
        drinkThree.setName("Coffee");
        drinkThree.setAlcoholic(false);

        Drink drinkFour = new Drink();
        drinkFour.setName("Water");
        drinkFour.setAlcoholic(false);

        Drink drinkFive = new Drink();
        drinkFive.setName("Cognac");
        drinkFive.setAlcoholic(true);

        Drink drinkSix = new Drink();
        drinkSix.setName("Vodka");
        drinkSix.setAlcoholic(true);

        Drink drinkSeven = new Drink();
        drinkSeven.setName("B52");
        drinkSeven.setAlcoholic(true);

        Drink drinkEight = new Drink();
        drinkEight.setName("Vino");
        drinkEight.setAlcoholic(true);

        Dish dishOne = new Dish();
        dishOne.setName("Vegetabls");
        dishOne.setType("Vegan");

        Dish dishTwo = new Dish();
        dishTwo.setName("Fried beaf");
        dishTwo.setType("Normal");

        Dish dishThree = new Dish();
        dishThree.setName("Boiled potato");
        dishThree.setType("Vegan");

        Dish dishFour = new Dish();
        dishFour.setName("Fried eggs");
        dishFour.setType("Vegetarian");

        Dish dishFive = new Dish();
        dishFive.setName("Pizza");
        dishFive.setType("Vegan");

        Dish dishSix = new Dish();
        dishSix.setName("Pizza with sausages");
        dishSix.setType("Normal");

        Dish dishSeven = new Dish();
        dishSeven.setName("Baked chiken");
        dishSeven.setType("Normal");

        Client clientOne = new Client();
        clientOne.setName("Olya");
        clientOne.setAddress(addressOne);
        clientOne.setDob(LocalDateTime.of(2000, 10, 10, 00, 00));

        Client clientTwo = new Client();
        clientTwo.setName("Tanya");
        clientTwo.setAddress(addressTwo);
        clientTwo.setDob(LocalDateTime.of(1995, 11, 11, 00, 00));

        Client clientThree = new Client();
        clientThree.setName("Ira");
        clientThree.setAddress(addressThree);
        clientThree.setDob(LocalDateTime.of(1990, 12, 12, 00, 00));

        Client clientFour = new Client();
        clientFour.setName("Dima");
        clientFour.setAddress(addressFour);
        clientFour.setDob(LocalDateTime.of(2005, 5, 5, 00, 00));

//        List<Client> clients = Arrays.asList(clientOne, clientTwo, clientThree, clientFour);

        List<Drink> drinksMenu = Arrays.asList(drinkOne, drinkTwo, drinkThree, drinkFour, drinkFive, drinkSix, drinkSeven, drinkEight);
        List<Dish> dishesMenu = Arrays.asList(dishOne, dishTwo, dishThree, dishFour, dishFive, dishSix, dishSeven);

        Menu menu = new Menu();
        menu.setType("Season-menu");
        menu.setDishes(dishesMenu);
        menu.setDrinks(drinksMenu);

        Passport passportOne = new Passport();
        passportOne.setNumber("1001 " + UUID.randomUUID());
        passportOne.setExpiredAt(LocalDateTime.of(2000, 11, 11, 00, 00));

        Passport passportTwo = new Passport();
        passportTwo.setNumber("1002 " + UUID.randomUUID());
        passportTwo.setExpiredAt(LocalDateTime.of(2026, 05, 02, 00, 00));

        Passport passportThree = new Passport();
        passportThree.setNumber("1003 " + UUID.randomUUID());
        passportThree.setExpiredAt(LocalDateTime.of(2027, 8, 20, 00, 00));

        Passport passportFour = new Passport();
        passportFour.setNumber("1004  " + UUID.randomUUID());
        passportFour.setExpiredAt(LocalDateTime.of(2028, 7, 14, 00, 00));

        Passport passportFive = new Passport();
        passportFive.setNumber("1005 " + UUID.randomUUID());
        passportFive.setExpiredAt(LocalDateTime.of(2029, 3, 15, 0, 0));

        Passport passportSix = new Passport();
        passportSix.setNumber("1006 " + UUID.randomUUID());
        passportSix.setExpiredAt(LocalDateTime.of(2022, 10, 29, 0, 0));

        Passport passportSeven = new Passport();
        passportSeven.setNumber("1007 " + UUID.randomUUID());
        passportSeven.setExpiredAt(LocalDateTime.of(2023, 11, 30, 00, 00));

        Employee employeeOne = new Employee();
        employeeOne.setName("Ilya");
        employeeOne.setLastName("Ilin");
        employeeOne.setPosition("Chif");
        employeeOne.setDepartment("Kitchen");
        employeeOne.setPassport(passportOne);
        employeeOne.setAddress(addressFive);

        Employee employeeTwo = new Employee();
        employeeTwo.setName("Ivan");
        employeeTwo.setLastName("Ivanov");
        employeeTwo.setPosition("Cook");
        employeeTwo.setDepartment("Kitchen");
        employeeTwo.setPassport(passportTwo);
        employeeTwo.setAddress(addressSix);

        Employee employeeThree = new Employee();
        employeeThree.setName("Petr");
        employeeThree.setLastName("Petrov");
        employeeThree.setPosition("Helper");
        employeeThree.setDepartment("Kitchen");
        employeeThree.setPassport(passportThree);
        employeeThree.setAddress(addressSeven);

        Employee employeeFour = new Employee();
        employeeFour.setName("Vasya");
        employeeFour.setLastName("Vasin");
        employeeFour.setPosition("Boss");
        employeeFour.setDepartment("Administration");
        employeeFour.setPassport(passportFour);
        employeeFour.setAddress(addressEight);

        Employee employeeFive = new Employee();
        employeeFive.setName("Sidr");
        employeeFive.setLastName("Sodorov");
        employeeFive.setPosition("Cleaner");
        employeeFive.setDepartment("Kitchen");
        employeeFive.setPassport(passportFive);
        employeeFive.setAddress(addressNine);

        List<Employee> employees = Arrays.asList(employeeOne, employeeTwo, employeeThree, employeeFour, employeeFive);

        Product productOne = new Product();
        productOne.setName("Eggs");

        Product productTwo = new Product();
        productTwo.setName("Meat");

        Product productThree = new Product();
        productThree.setName("Chiken");

        Product productFour = new Product();
        productFour.setName("Tomato");

        Product productFive = new Product();
        productFive.setName("Spices");

        Product productSix = new Product();
        productSix.setName("Potato");

        Product productSeven = new Product();
        productSeven.setName("Apple");

        Product productEight = new Product();
        productEight.setName("Beef");

        Product productNine = new Product();
        productNine.setName("Oil");

        Product productTen = new Product();
        productTen.setName("Carrot");

        List<Product> productsFrige = Arrays.asList(productOne, productTwo, productThree, productFour, productEight);
        List<Product> productsBox = Arrays.asList(productFive, productSix, productSeven, productNine, productTen);

        Staff staffOne = new Staff();
        staffOne.setName("Frige");
        staffOne.setType("Equipment");
        staffOne.setProducts(productsFrige);

        Staff staffTwo = new Staff();
        staffTwo.setName("Box");
        staffTwo.setType("Equipment");
        staffTwo.setProducts(productsBox);

        Staff staffThree = new Staff();
        staffThree.setName("Table");
        staffThree.setType("Furniture");
        staffThree.setProducts(null);

        Staff staffFour = new Staff();
        staffFour.setName("Knife");
        staffFour.setType("Tool");
        staffFour.setProducts(null);

        Staff staffFive = new Staff();
        staffFive.setName("Mixer");
        staffFive.setType("Tool");
        staffFive.setProducts(null);

        List<Staff> staffList = Arrays.asList(staffOne, staffTwo, staffThree, staffFour, staffFive);

        Kitchen kitchen = new Kitchen();
        kitchen.setEmployees(employees);
        kitchen.setStaff(staffList);

        Restaurant restaurantFalcone = new Restaurant();
        restaurantFalcone.setName("Falcone");
        restaurantFalcone.setDateOfFoundation(LocalDateTime.of(2020, 01, 01, 00, 00));
        restaurantFalcone.setMenu(menu);

        restaurantFalcone.setKitchen(kitchen);
//
//        Restaurant restaurantBelaRossa = new Restaurant();
//        restaurantBelaRossa.setName("Bela Rossa");
//        restaurantBelaRossa.setDateOfFoundation(LocalDateTime.of(2020, 8, 9, 00, 00));
//        restaurantBelaRossa.setMenu(null);
//        restaurantBelaRossa.setKitchen(null);
//
//        RestaurantService restaurantService = new RestaurantServiceImpl();
//        restaurantService.create(restaurantFalcone);
//        RestaurantService restaurantService1 = new RestaurantServiceImpl();
//        restaurantService1.create(restaurantBelaRossa);
//
//        List<Dish> clientOneDish = Arrays.asList(restaurantFalcone.getMenu().getDishes().get(0),
//                restaurantFalcone.getMenu().getDishes().get(3));
//        clientOne.setDishes(clientOneDish);
//
//        List<Drink> clientOneDrink = Arrays.asList(restaurantFalcone.getMenu().getDrinks().get(2),
//                restaurantFalcone.getMenu().getDrinks().get(5));
//        clientOne.setDrinks(clientOneDrink);
//
//        List<Dish> clientTwoDish = Arrays.asList(restaurantFalcone.getMenu().getDishes().get(1),
//                restaurantFalcone.getMenu().getDishes().get(4));
//        clientOne.setDishes(clientOneDish);
//        clientTwo.setDishes(clientTwoDish);
//
//        List<Drink> clientTwoDrink = Arrays.asList(restaurantFalcone.getMenu().getDrinks().get(0),
//                restaurantFalcone.getMenu().getDrinks().get(3));
//        clientTwo.setDrinks(clientTwoDrink);
//
//
//        ClientService clientService = new ClientServiceImpl();
//        clientService.create(clientOne);
//        clientService.create(clientTwo);
//
//
//        PassportService passportService = new PassportServiceImpl();
//        System.out.println(passportService.findAll());
//
        EmployeeService employeeService = new EmployeeServiceImpl();
        System.out.println(employeeService.findAll());
//        System.out.println(employeeService.findWithAddress());
//           String new10 = "NewLastName";
//        System.out.println(employeeService.update(new10,employeeFour));

    }
}
