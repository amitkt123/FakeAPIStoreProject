package com.example.scalarproject.ThirdPartyClient;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.DataTransfer.FakeStoreProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThirdPartyClientInterface {
   ResponseEntity<FakeStoreProductDTO> DeleteProductByID(Long id) throws NotFoundException;
   FakeStoreProductDTO GetProductById(Long Id);
   ResponseEntity<FakeStoreProductDTO> CreateProduct(GenericProductDTO productDTO);
   List<FakeStoreProductDTO> GetAllProducts();
}
