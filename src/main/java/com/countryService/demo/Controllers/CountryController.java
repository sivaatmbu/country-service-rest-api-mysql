package com.countryService.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryService.demo.Beans.Country;
import com.countryService.demo.Beans.Message;
import com.countryService.demo.Services.CountryService;

@RestController
public class CountryController {

    // We already have CountryService which contains all the services.
    // So first we need a reference of CountryService to call those methods.
    // In Spring Boot, we can get the reference using @Autowired.
    // Spring automatically creates and injects the CountryService object.

    @Autowired
    CountryService countryService;

    // -------------------------------
    // SERVICE 1 -- GET ALL COUNTRIES
    @GetMapping("/getAllCountries")
    public List<Country> getAllCountries() {

        return countryService.getAllCountries();
    }
    // ResponseEntity is used when we want to control the HTTP response,
    // especially the status code and response body.
    // Example: 200 OK when data is found and 404 NOT_FOUND when data is not found.


    // SERVICE 2 -- GET COUNTRY BY ID
    @GetMapping("/getCountryById/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable int id) {
    	
        try {
            Country country = countryService.getCountryById(id);
            // Return 200 OK when country is found
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e) {
            // Return 404 NOT_FOUND when country is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // SERVICE 3 -- GET COUNTRY BY NAME
    @GetMapping("/getCountryByName")
    public ResponseEntity<Country> getCountryByName(@RequestParam String countryName) {

        try {
            Country country = countryService.getCountryByName(countryName);
            // Return 200 OK when country is found
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e) {
            // Return 404 NOT_FOUND when country is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // SERVICE 4 -- ADD NEW COUNTRY
    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }
    
    // SERVICE 5 -- UPDATE COUNTRY

    @PutMapping("/updateCountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable int id,@RequestBody Country country) {
    	
        try {
            Country existCountry = countryService.getCountryById(id);

            existCountry.setCountryName(country.getCountryName());
            existCountry.setCountryCapital(country.getCountryCapital());

            Country updatedCountry = countryService.updateCountry(existCountry);
            // Return 200 OK when country is successfully updated
            return new ResponseEntity<Country>(updatedCountry,HttpStatus.OK);
        }
        catch (Exception e) {
            // Return 409 CONFLICT when update cannot be performed
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // SERVICE 6 -- DELETE COUNTRY

    @DeleteMapping("/deleteCountry/{id}")
    public Message deleteCountry(@PathVariable int id) {
        return countryService.deleteCountry(id);
    }

}