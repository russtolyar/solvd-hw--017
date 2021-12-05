package com.solved.mvchw017;

import com.solved.mvchw017.domain.*;
import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.department.Product;
import com.solved.mvchw017.domain.department.Staff;
import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.domain.menu.Food;
import com.solved.mvchw017.domain.menu.Menu;
import com.solved.mvchw017.persistence.impl.RestaurantJDBCRepositoryImpl;
import com.solved.mvchw017.service.ClientService;
import com.solved.mvchw017.service.MenuService;
import com.solved.mvchw017.service.RestaurantService;
import com.solved.mvchw017.service.impl.ClientServiceImpl;
import com.solved.mvchw017.service.impl.MenuServiceImpl;
import com.solved.mvchw017.service.impl.RestaurantServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        addressTwo.setCity("");
        addressTwo.setStreet("Zhukov");
        addressTwo.setNumberHouse(8);
        addressTwo.setNumberFlat(9);

        Address addressFour = new Address();
        addressTwo.setCity("Minsk");
        addressTwo.setStreet("Krasnaya");
        addressTwo.setNumberHouse(9);
        addressTwo.setNumberFlat(90);

        Address addressFive = new Address();
        addressTwo.setCity("Zaslavl");
        addressTwo.setStreet("Dachnaya");
        addressTwo.setNumberHouse(4);
        addressTwo.setNumberFlat(50);

        Address addressSix = new Address();
        addressTwo.setCity("Drozdy");
        addressTwo.setStreet("Levaya");
        addressTwo.setNumberHouse(5);
        addressTwo.setNumberFlat(30);

        Address addressSeven = new Address();
        addressTwo.setCity("Minsk");
        addressTwo.setStreet("Centr");
        addressTwo.setNumberHouse(6);
        addressTwo.setNumberFlat(55);

        Address addressEight = new Address();
        addressTwo.setCity("Minsk");
        addressTwo.setStreet("Grusheva");
        addressTwo.setNumberHouse(7);
        addressTwo.setNumberFlat(22);

        Address addressNine = new Address();
        addressTwo.setCity("Minsk");
        addressTwo.setStreet("Usataya");
        addressTwo.setNumberHouse(8);
        addressTwo.setNumberFlat(47);

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

        Food dishOne = new Food();
        dishOne.setName("Vegetabls");
        dishOne.setType("Vegan");

        Food dishTwo = new Food();
        dishOne.setName("Fried bea");
        dishOne.setType("Normal");

        Food dishThree = new Food();
        dishOne.setName("Boiled potato");
        dishOne.setType("Vegan");

        Food dishFour = new Food();
        dishOne.setName("Fried eggs");
        dishOne.setType("Vegetarian");

        Food dishFive = new Food();
        dishOne.setName("Pizza");
        dishOne.setType("Vegan");

        Food dishSix = new Food();
        dishOne.setName("Pizza with sausages");
        dishOne.setType("Normal");

        Food dishSeven = new Food();
        dishOne.setName("Baked chiken");
        dishOne.setType("Normal");

        Client clientOne = new Client();
        clientOne.setName("Olya");
        clientOne.setAddress(addressTwo);
        clientOne.setDob(LocalDateTime.of(2000, 10, 10, 00, 00));

        Client clientTwo = new Client();
        clientTwo.setName("Tanya");
        clientTwo.setAddress(addressFour);
        clientTwo.setDob(LocalDateTime.of(1995, 11, 11, 00, 00));

        Client clientThree = new Client();
        clientThree.setName("Ira");
        clientThree.setAddress(addressSix);
        clientThree.setDob(LocalDateTime.of(1990, 12, 12, 00, 00));

        Client clientFour = new Client();
        clientFour.setName("Dima");
        clientFour.setAddress(addressEight);
        clientFour.setDob(LocalDateTime.of(2005, 5, 5, 00, 00));

        List<Client> clients = Arrays.asList(clientOne, clientTwo, clientThree, clientFour);

//        ArrayList<Drink> drinksSetOne = new ArrayList<>();
//        drinksSetOne.add(drinkTwo);
//        clientOne.setDrinks(drinksSetOne);
//
//        ArrayList<Food> dishesSetOne = new ArrayList();
//        dishesSetOne.add(dishOne);
//        dishesSetOne.add(dishFour);
//        clientOne.setDishes(dishesSetOne);

        List<Drink> drinksMenu = Arrays.asList(drinkOne, drinkTwo, drinkThree, drinkFour, drinkFive, drinkSix, drinkSeven, drinkEight);

        List<Food> foodMenu = Arrays.asList(dishOne, dishTwo, dishThree, dishFour, dishFive, dishSix, dishSeven);

        Menu menu = new Menu();
        menu.setType("Season-menu");
        menu.setDishes(foodMenu);
        menu.setDrinks(drinksMenu);


        Passport passportOne = new Passport();
        passportOne.setNumber("1001");
        passportOne.setExpiredAt(LocalDateTime.of(2000, 11, 11, 00, 00));

        Passport passportTwo = new Passport();
        passportTwo.setNumber("1002");
        passportTwo.setExpiredAt(LocalDateTime.of(2026, 05, 02, 00, 00));

        Passport passportThree = new Passport();
        passportThree.setNumber("1003");
        passportThree.setExpiredAt(LocalDateTime.of(2027, 8, 20, 00, 00));

        Passport passportFour = new Passport();
        passportFour.setNumber("1004");
        passportFour.setExpiredAt(LocalDateTime.of(2028, 7, 14, 00, 00));

        Passport passportFive = new Passport();
        passportFive.setNumber("1005");
        passportFive.setExpiredAt(LocalDateTime.of(2029, 3, 15, 0, 0));

        Passport passportSix = new Passport();
        passportSix.setNumber("1006");
        passportSix.setExpiredAt(LocalDateTime.of(2022, 10, 29, 0, 0));

        Passport passportSeven = new Passport();
        passportSeven.setNumber("1007");
        passportSeven.setExpiredAt(LocalDateTime.of(2023, 11, 30, 00, 00));

        Employee employeeOne = new Employee();
        employeeOne.setName("Ilya");
        employeeOne.setLastName("Ilin");
        employeeOne.setPosition("Chif");
        employeeOne.setDepartment("Kitchen");
        employeeOne.setPassport(passportTwo);
        employeeOne.setAddress(addressFive);

        Employee employeeTwo = new Employee();
        employeeTwo.setName("Ivan");
        employeeTwo.setLastName("Ivanov");
        employeeTwo.setPosition("Cook");
        employeeTwo.setDepartment("Kitchen");
        employeeTwo.setPassport(passportOne);
        employeeTwo.setAddress(addressThree);

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
        employeeFour.setPassport(passportFive);
        employeeFour.setAddress(addressOne);

        Employee employeeFive = new Employee();
        employeeFive.setName("Sidr");
        employeeFive.setLastName("Sodorov");
        employeeFive.setPosition("Cleaner");
        employeeFive.setDepartment("Kitchen");
        employeeFive.setPassport(passportFour);
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
        staffOne.setName("Box");
        staffOne.setType("Equipment");
        staffOne.setProducts(productsBox);

        Staff staffThree = new Staff();
        staffOne.setName("Table");
        staffOne.setType("Furniture");
        staffOne.setProducts(null);

        Staff staffFour = new Staff();
        staffOne.setName("Knife");
        staffOne.setType("Tool");
        staffOne.setProducts(productsFrige);

        Staff staffFive = new Staff();
        staffOne.setName("Mixer");
        staffOne.setType("Tool");
        staffOne.setProducts(productsFrige);

        List<Staff> staffList = Arrays.asList(staffOne, staffTwo, staffThree, staffFour, staffFive);

        Kitchen kitchen = new Kitchen();
        kitchen.setEmployees(employees);
        kitchen.setStaff(staffList);

        Restaurant restaurantFalcone = new Restaurant();
        restaurantFalcone.setName("Falcone");
        restaurantFalcone.setDateOfFoundation(LocalDateTime.of(2020, 01, 01, 00, 00));
        restaurantFalcone.setMenu(menu);
        restaurantFalcone.setClients(clients);
        restaurantFalcone.setKitchen(kitchen);

        Restaurant restaurantBelaRossa = new Restaurant();
        restaurantFalcone.setName("Bela Rossa");
        restaurantFalcone.setDateOfFoundation(LocalDateTime.of(2020, 8, 9, 00, 00));

//        new RestaurantJDBCRepositoryImpl().create(restaurantFalcone);
//        new AddressRepositoryImpl().create(addressOne);

        RestaurantService restaurantService = new RestaurantServiceImpl();
        restaurantService.create(restaurantFalcone);
        restaurantService.create(restaurantBelaRossa);


        List<Food> clientOneFood = Arrays.asList(restaurantFalcone.getMenu().getDishes().get(0),
                restaurantFalcone.getMenu().getDishes().get(3));
        clientOne.setDishes(clientOneFood);

        List<Drink> clientOneDrink = Arrays.asList(restaurantFalcone.getMenu().getDrinks().get(2),
                restaurantFalcone.getMenu().getDrinks().get(5));
        clientOne.setDrinks(clientOneDrink);

        List<Food> clientTwoFood = Arrays.asList(restaurantFalcone.getMenu().getDishes().get(0),
                restaurantFalcone.getMenu().getDishes().get(3));
        clientOne.setDishes(clientOneFood);
        clientTwo.setDishes(clientTwoFood);

        List<Drink> clientTwoDrink = Arrays.asList(restaurantFalcone.getMenu().getDrinks().get(2),
                restaurantFalcone.getMenu().getDrinks().get(5));
        clientTwo.setDrinks(clientTwoDrink);


        ClientService clientService = new ClientServiceImpl();
        clientService.create(clientOne);
    }
}
