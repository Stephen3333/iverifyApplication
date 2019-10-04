package com.iverify.iverifyApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iverify.iverifyApp.dao.CustomerDAO;
import com.iverify.iverifyApp.model.Customer;


@RestController
@RequestMapping(path = "/customer")
//PC
public class CustomerController{
    
    @Autowired
    private CustomerDAO customerDAO;
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    
    @ResponseBody
    public ResponseEntity<?> registration(@RequestBody Customer customerJson) {
    Gson gson = new Gson();

    //JsonObject reqObj = gson.fromJson(customerJson, JsonObject.class);
    String name = customerJson.getCustomerName();//reqObj.get("name").getAsString();
    String password = customerJson.getCustomerPassword();//reqObj.get("name").getAsString();
    
   // System.out.println("name"+ name +"password"+password);
    /// Save to DB
    customerDAO.save(customerJson);

    // Send json response	// Send json response
    JsonObject responseObj = new JsonObject();
    responseObj.addProperty("response_status", true);
    responseObj.addProperty("response_message", "success");
    responseObj.addProperty("response_name", name);
    responseObj.addProperty("response_password", password);
    return ResponseEntity.ok(gson.toJson(responseObj));

    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer CustomerLogin(@RequestBody Customer customer) {
    // public ResponseEntity<?> login(@RequestBody Customer customer) {
    customer = customerDAO.findByCustomerName(customer.getCustomerName());
    return customer;

    }
    
    //RMvmRM. consumes produces
    //consumes MediaType.A_J_V
    @RequestMapping(value="/getAllCustomers", method=RequestMethod.GET)
    
    public List<Customer> getAllCustomers(){
        List<Customer> custList = (List<Customer>) customerDAO.findAll();
        System.out.println(custList.size());
        return custList;
    }
    
    @RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer customer){
        Customer cust  = customerDAO.save(customer);
        return cust;
    }
    
    @RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
    public Customer getByIdCustomer( @PathVariable("id") long id){
        Customer cust = customerDAO.findOne(id);
        return cust;
    }
    
    @RequestMapping(value="/updateCustomer/{id}", method=RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        Customer cust = customerDAO.findOne(id);
        cust.setCustomerName(customer.getCustomerName());
        cust.setCustomerPassword(customer.getCustomerPassword());
        Customer savedCust = customerDAO.save(cust);
        return savedCust;
    }
    
    @RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") long id){
         customerDAO.delete(customerDAO.findOne(id));
         //.delete.findOne
    }
}
