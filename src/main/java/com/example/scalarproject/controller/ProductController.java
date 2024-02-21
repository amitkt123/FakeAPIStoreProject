package com.example.scalarproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;
import com.example.scalarproject.Services.ProductServices;

@RestController()
@RequestMapping("/products")
public class ProductController {
    private ProductServices prodServ;

    ProductController(@Qualifier("FakeStoreProdServ") ProductServices prodserv){

        this.prodServ = prodserv;
    }

    @GetMapping()
    public List<GenericProductDTO> GetAllProducts(){
        List<GenericProductDTO> prods = prodServ.GetAllProducts();
        return prods;
    }

    @GetMapping("{id}")
    public GenericProductDTO GetProductById(@PathVariable("id") Long id){
        GenericProductDTO prods = prodServ.GetProductById(id);
        return prods;
    }


    @DeleteMapping("/delete/{id}")
    public GenericProductDTO DeleteProductbyId(@PathVariable("id") Long id) throws NotFoundException {
       ResponseEntity<GenericProductDTO> genericProductDTOResponseEntity = prodServ.DeleteProductByID(id);
       if(genericProductDTOResponseEntity.getStatusCode() == HttpStatusCode.valueOf(500))
       {
            throw new NotFoundException("Not Found");
       }
       return genericProductDTOResponseEntity.getBody();
    }

    @PostMapping(value = "/add")
    public GenericProductDTO CreateProduct(GenericProductDTO genericProductDTO){
        ResponseEntity<GenericProductDTO> responseEntity = prodServ.CreateProduct(genericProductDTO);


        return responseEntity.getBody();


    }

    @PutMapping()
    public void UpdateProduct(){

    }
}
