package com.example.scalarproject.Services;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.DataTransfer.ProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;
import com.example.scalarproject.Models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductServices {
     GenericProductDTO GetProductById(Long Id);
     List<GenericProductDTO> GetAllProducts();

     ResponseEntity<GenericProductDTO> CreateProduct(GenericProductDTO genericProductDTO);

     ResponseEntity<GenericProductDTO> DeleteProductByID(Long Id) throws NotFoundException;
}
