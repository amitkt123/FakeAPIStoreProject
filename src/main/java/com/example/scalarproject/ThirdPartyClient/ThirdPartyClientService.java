package com.example.scalarproject.ThirdPartyClient;

import com.example.scalarproject.DataTransfer.GenericProductDTO;
import com.example.scalarproject.DataTransfer.FakeStoreProductDTO;
import com.example.scalarproject.Exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThirdPartyClientService implements ThirdPartyClientInterface{

    private final RestTemplateBuilder restTemplateBuilder;
    private final String getProductRequestBaseUrl = "https://fakestoreapi.com/products";

    ThirdPartyClientService(RestTemplateBuilder remptbd) {
        this.restTemplateBuilder = remptbd;
    }


    @Override
    public List<FakeStoreProductDTO> GetAllProducts() {
        RestTemplate restTemp = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO[]> response = restTemp.getForEntity(getProductRequestBaseUrl, FakeStoreProductDTO[].class);

        FakeStoreProductDTO[] respon = response.getBody();
        

        return respon;
    }


    @Override
    public  ResponseEntity<GenericProductDTO> CreateProduct(GenericProductDTO productDTO) {
        RestTemplate restTemp = restTemplateBuilder.build();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> postEntity = new HttpEntity<>(header);
        ResponseEntity<GenericProductDTO> response = restTemp.exchange(getProductRequestBaseUrl, HttpMethod.POST, postEntity, GenericProductDTO.class );

        return response;
    }

    @Override
    public GenericProductDTO GetProductById(Long Id) {

        RestTemplate temp = restTemplateBuilder.build();
        String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDTO> response = temp.getForEntity(getProductRequestUrl, FakeStoreProductDTO.class, Id);

        FakeStoreProductDTO responseBody = response.getBody();
        GenericProductDTO prod = new GenericProductDTO();
        assert responseBody != null;
        prod.setDescription(responseBody.getDescription());
        prod.setPrice(responseBody.getPrice());
        prod.setTitle(responseBody.getTitle());
        prod.setCategory(responseBody.getCategory());
        return prod;
    }

    @Override
    public ResponseEntity<FakeStoreProductDTO> DeleteProductByID(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String deleteProductRequestUrl = "https://fakestoreapi.com/products/";
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(
                deleteProductRequestUrl + "/" + id,  // Assuming getProductRequestUrl already contains the base URL
                HttpMethod.DELETE,
                requestEntity,
                FakeStoreProductDTO.class
        );
        try{
            GenericProductDTO genericProductDTO = convertor(response.getBody());
            return new ResponseEntity<>(genericProductDTO, response.getStatusCode());
        }catch (NullPointerException e){
            GenericProductDTO genericProductDTO = new GenericProductDTO();
            return new ResponseEntity<>(genericProductDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private GenericProductDTO convertor(FakeStoreProductDTO productDTO){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setImage(productDTO.getImage());
        genericProductDTO.setId(productDTO.getId());
        genericProductDTO.setDescription(productDTO.getDescription());
        genericProductDTO.setTitle(productDTO.getTitle());
        genericProductDTO.setCategory(productDTO.getCategory());
        return genericProductDTO;
    }
}
