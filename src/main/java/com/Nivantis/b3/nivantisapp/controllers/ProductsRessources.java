package com.Nivantis.b3.nivantisapp.controllers;

import com.Nivantis.b3.nivantisapp.models.Medicaments;
import com.Nivantis.b3.nivantisapp.models.Price;
import com.Nivantis.b3.nivantisapp.models.Users;
import com.Nivantis.b3.nivantisapp.repositories.MedicamentPriceRepositories;
import com.Nivantis.b3.nivantisapp.repositories.ProductlistReprositories;
import com.Nivantis.b3.nivantisapp.repositories.UsersRepositories;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/products")
@CrossOrigin("*")
public class ProductsRessources {

    @Autowired
    private ProductlistReprositories medicamentRepository;

    @Autowired
    private UsersRepositories usersRepositories;

    @Autowired
    private MedicamentPriceRepositories medicamentPriceRepositories;

    @RequestMapping(path = "/users" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getUsers() {

        return usersRepositories.findAll();
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Users getProductId(@PathVariable("id") ObjectId id){
        return  usersRepositories.findBy_id(id) ;
    }

/*
    @RequestMapping(path = "/{name}" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Users getProductName( @PathVariable("name") String name) {

        return usersRepositories.findByName(name);
    }
*/


    @RequestMapping(path = "/medicament" , method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Medicaments> getMedicamentsList() {
        return  medicamentRepository.findAll();
    }

//    @RequestMapping(path = "/{id}/price" , method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public Price getMedicamentPrice(@PathVariable("id") ObjectId id) {
//
//        return  medicamentPriceRepositories.findBy_id(id);
//    }



}
