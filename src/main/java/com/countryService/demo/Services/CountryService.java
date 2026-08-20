package com.countryService.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.countryService.demo.Beans.Country;
import com.countryService.demo.Beans.Message;
import com.countryService.demo.Repositories.CountryRepository;

@Component
public class CountryService {

    // In CountryRepository (which extends JpaRepository), we have a number of predefined
    // methods like findById(), findAll(), save(), deleteById(), etc.

    // To access those JpaRepository methods, we need a reference of CountryRepository.

    // We can get the reference using @Autowired.

    // Spring Data JPA automatically creates the implementation object of CountryRepository
    // and injects it into the CountryService.

    @Autowired
    CountryRepository countryrep;


    // SERVICE 1 -- GET ALL COUNTRIES FROM DATABASE TABLE

    public List<Country> getAllCountries() {
        return countryrep.findAll();
    }


    // SERVICE 2 -- GET COUNTRY BY ID FROM DATABASE TABLE

    public Country getCountryById(int id) {
        return countryrep.findById(id).get();
    }


    // SERVICE 3 -- GET COUNTRY BY NAME
    // We don't have a predefined findByCountryName() method in JpaRepository,
    // so we retrieve all countries and search for the required country.

    public Country getCountryByName(String countryName) {

        List<Country> countries = countryrep.findAll();

        Country country = null;

        for (Country con : countries) {

            if (con.getCountryName().equalsIgnoreCase(countryName)) {
                country = con;
            }
        }

        return country;
    }


    // SERVICE 4 -- ADD NEW COUNTRY
    // We will provide only country name and capital,
    // but ID should be allocated automatically.

    // So first we create a method which will give us the next ID for the new country.

    public int getNextId() {
        return countryrep.findAll().size() + 1;
    }

    public Country addCountry(Country country) {

        country.setId(getNextId());

        countryrep.save(country);

        return country;
    }


    // SERVICE 5 -- UPDATE COUNTRY

    public Country updateCountry(Country country) {

        countryrep.save(country);

        return country;
    }


    // SERVICE 6 -- DELETE COUNTRY AND DISPLAY A MESSAGE
    // In this service we need to display a message,
    // so first we create a Message class and use it when required.

    // We create the Message class as a Bean class.

    public Message deleteCountry(int id) {

        countryrep.deleteById(id);

        Message msg = new Message();

        msg.setMsg("COUNTRY DELETED SUCCESSFULLY !!");
        msg.setId(id);

        return msg;
    }

    // Now we are done with the Service class.
    // All services are ready. Now we just need to map them using
    // the Controller class inside the Controller package.

}