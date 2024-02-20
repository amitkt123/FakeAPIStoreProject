package com.example.scalarproject.Services;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.DataTransfer.ProductDTO;

import com.example.scalarproject.Exceptions.NotFoundException;
import java.util.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



@Service
@Qualifier("FakeStoreProdServ")
public class FakeStoreProductService implements ProductServices
{

    private final RestTemplateBuilder restTemplateBuilder;
    private final String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private final String getProductRequestBaseUrl = "https://fakestoreapi.com/products";
    private String deleteProductRequestUrl = "https://fakestoreapi.com/products/";
    FakeStoreProductService(RestTemplateBuilder remptbd) {
        this.restTemplateBuilder = remptbd;
    }


    @Override
    public List<GenericProductDTO> GetAllProducts() {
        RestTemplate restTemp = restTemplateBuilder.build();

        ResponseEntity<ProductDTO[]> response = restTemp.getForEntity(getProductRequestBaseUrl, ProductDTO[].class);

        ProductDTO[] respon = response.getBody();
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();

        for (ProductDTO prodDos : respon) {
            GenericProductDTO genericDto = new GenericProductDTO();
            genericDto.setDescription(prodDos.getDescription());
            genericDto.setId(prodDos.getId());
            genericDto.setTitle(prodDos.getTitle());
            genericDto.setCategory(prodDos.getCategory());
            genericDto.setPrice(prodDos.getPrice());
            genericDto.setImage(prodDos.getImage());
            genericProductDTOList.add(genericDto);

        }

        return genericProductDTOList;
    }


    @Override
    public  ResponseEntity<GenericProductDTO> CreateProduct(GenericProductDTO productDTO) {
        RestTemplate restTemp = restTemplateBuilder.build();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> postEntity = new HttpEntity<>(header);
        ResponseEntity<GenericProductDTO> response = restTemp.exchange(getProductRequestBaseUrl,HttpMethod.POST, postEntity, GenericProductDTO.class );

        return response;
    }

    @Override
    public GenericProductDTO GetProductById(Long Id) {

        RestTemplate temp = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response = temp.getForEntity(getProductRequestUrl, ProductDTO.class, Id);

        ProductDTO responseBody = response.getBody();
        GenericProductDTO prod = new GenericProductDTO();
        assert responseBody != null;
        prod.setDescription(responseBody.getDescription());
        prod.setPrice(responseBody.getPrice());
        prod.setTitle(responseBody.getTitle());
        prod.setCategory(responseBody.getCategory());
        return prod;
    }

    @Override
    public ResponseEntity<GenericProductDTO> DeleteProductByID(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ProductDTO> response = restTemplate.exchange(
                deleteProductRequestUrl + "/" + id,  // Assuming getProductRequestUrl already contains the base URL
                HttpMethod.DELETE,
                requestEntity,
                ProductDTO.class
        );
        try{
            GenericProductDTO genericProductDTO = convertor(response.getBody());
            return new ResponseEntity<>(genericProductDTO, response.getStatusCode());
        }catch (NullPointerException e){
            GenericProductDTO genericProductDTO = new GenericProductDTO();
            return new ResponseEntity<>(genericProductDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private GenericProductDTO convertor(ProductDTO productDTO){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setImage(productDTO.getImage());
        genericProductDTO.setId(productDTO.getId());
        genericProductDTO.setDescription(productDTO.getDescription());
        genericProductDTO.setTitle(productDTO.getTitle());
        genericProductDTO.setCategory(productDTO.getCategory());
        return genericProductDTO;
    }
}
