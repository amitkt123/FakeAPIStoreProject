package com.example.scalarproject.Services;

import java.util.List;

import com.example.scalarproject.ThirdPartyClient.ThirdPartyClientInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;



@Service
@Qualifier("FakeStoreProdServ")
public class FakeStoreProductService implements ProductServices
{
    ThirdPartyClientInterface thirdPartyClient;
    FakeStoreProductService(ThirdPartyClientInterface thirdPartyClientInterface) {

        this.thirdPartyClient = thirdPartyClientInterface;
    }


    @Override
    public List<GenericProductDTO> GetAllProducts() {
       return  thirdPartyClient.GetAllProducts();
    }


    @Override
    public  ResponseEntity<GenericProductDTO> CreateProduct(GenericProductDTO productDTO) {
        return thirdPartyClient.CreateProduct(productDTO);

    }

    @Override
    public GenericProductDTO GetProductById(Long Id) {
        return thirdPartyClient.GetProductById(Id);
    }

    @Override
    public ResponseEntity<GenericProductDTO> DeleteProductByID(Long id) throws NotFoundException {
      return thirdPartyClient.DeleteProductByID(id);
    }


}
