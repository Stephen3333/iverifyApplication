package com.iverify.iverifyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iverify.iverifyApp.dao.ProductDAO;
import com.iverify.iverifyApp.model.Product;



@RestController
@RequestMapping(path = "/product")
public class ProductController{
    
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping(value="/getAllProducts", method=RequestMethod.GET)
    
    public List<Product> getAllProducts(){
        List<Product> prodList = (List<Product>) productDAO.findAll();
        System.out.println(prodList.size());
        return prodList;
    }
    
    @RequestMapping(value="/saveProduct", method=RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product){
        Product prod = productDAO.save(product);
        return prod;
    }
    
    @RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
    public Product getByIdProduct( @PathVariable("id") long id){
        Product prod = productDAO.findOne(id);
        return prod;
    }
    
    @RequestMapping(value="/updateProduct/{id}", method=RequestMethod.PUT)
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        Product prod = productDAO.findOne(id);
        prod.setProdName(product.getProdName());
        Product savedProd = productDAO.save(prod);
        return savedProd;
    }
    
    @RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") long id){
        productDAO.delete(productDAO.findOne(id));
    }
}
