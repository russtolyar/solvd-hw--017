package com.solved.mvchw017.persistance.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.persistence.impl.AddressJDBCRepositoryImpl;
import com.solved.mvchw017.service.AddressService;
import com.solved.mvchw017.service.impl.AddressServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddressesRepositoryTest {

    private static final Logger LOGGER = LogManager.getLogger(AddressesRepositoryTest.class);
    private final AddressService addressService;

    public AddressesRepositoryTest() {
        this.addressService = new AddressServiceImpl();
    }

    @DataProvider(name = "addressRepositoryTest")
    public Object[][] provide() {
        Address addressOne = new Address();
        Address addressTwo = new Address();
        addressOne.setCity("Minsk");
        addressOne.setStreet("White");
        addressOne.setNumberHouse(11);
        addressOne.setNumberFlat(22);

        addressTwo.setCity("Minsk");
        addressTwo.setStreet("Black");
        addressTwo.setNumberHouse(33);
        addressTwo.setNumberFlat(44);
        return new Object[][]{
                {addressOne},
                {addressTwo}};
    }
@BeforeTest
public void beforeMethod(){
    LOGGER.debug("\n\nНачало проверки репозитория адресов");
}

    @Test
            (testName = " Creation Address in db",
                    description = " Address created in db",
                    dataProvider = "addressRepositoryTest",
                    groups = {"create.delete"})
    public void addressCreationTest(Address address) {
        AddressJDBCRepositoryImpl addressJDBCRepository = new AddressJDBCRepositoryImpl();

        Address address1 = addressJDBCRepository.create(address);
        addressService.create(address);
        Address addressSelected = addressSelect(address);

        Assert.assertEquals(address1.getCity(), addressSelected.getCity());
        Assert.assertEquals(address1.getStreet(), addressSelected.getStreet());
        Assert.assertEquals(address1.getNumberHouse(), addressSelected.getNumberHouse());
        Assert.assertEquals(address1.getNumberFlat(), addressSelected.getNumberFlat());
        Assert.assertNotNull(addressSelected.getId());

    }


    @Test(testName = " Selection Address in db",
            description = "Address selected in db",
            dataProvider = "addressRepositoryTest")
    public void addressSelectionTest(Address address) {
        addressService.create(address);
        Address addressSelected = addressSelect(address);
        System.out.println(addressSelected);
        Assert.assertEquals(address.getCity(), addressSelected.getCity());
    }


    @Test(testName = " Deletion Address from db ",
            description = " Address Deleted from db ",
            dataProvider = "addressRepositoryTest",
            priority = 1,
            groups = {"create.delete"})
    public void addressDeletionTest(Address address) {
        addressService.create(address);
        addressService.delete(address);
        Address addressSelected = addressSelect(address);
        Assert.assertNull(addressSelected.getId());
        Assert.assertNull(addressSelected.getCity());
        Assert.assertNull(addressSelected.getStreet());

    }

    @Test(testName = " Updating Address in db",
            description = " Address Updated in db ",
            dataProvider = "addressRepositoryTest")
    public void addressUpdatingTest(Address address) {

        Address addressMine = new Address();
        addressMine.setCity("55");
        addressMine.setStreet("66");
        addressMine.setNumberHouse(77);
        addressMine.setNumberFlat(88);
        addressService.update(address, addressMine);
        Address addressEx = addressSelect(address);
        Address addressNew = addressSelect(addressMine);
        Assert.assertNotEquals(addressEx.getCity(), addressNew.getCity());
        Assert.assertNotEquals(addressEx.getStreet(), addressNew.getStreet());
        Assert.assertNotEquals(addressEx.getNumberHouse(), addressNew.getNumberHouse());
        Assert.assertNotEquals(addressEx.getNumberFlat(), addressNew.getNumberFlat());
    }


    private Address addressSelect(Address address) {
        return addressService.select(address);
    }

    @AfterTest
    public  void afterTest(){
        LOGGER.debug("\nТест репозитория завершен");
    }
}
