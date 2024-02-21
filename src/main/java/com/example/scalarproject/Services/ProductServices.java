package com.example.scalarproject.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;


public interface ProductServices {
     GenericProductDTO GetProductById(Long Id);
     List<GenericProductDTO> GetAllProducts();

     ResponseEntity<GenericProductDTO> CreateProduct(GenericProductDTO genericProductDTO);

     ResponseEntity<GenericProductDTO> DeleteProductByID(Long Id) throws NotFoundException;
}
