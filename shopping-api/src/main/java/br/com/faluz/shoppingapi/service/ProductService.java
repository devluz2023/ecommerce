package br.com.faluz.shoppingapi.service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import shoppingclient.dto.ProductDTO;
import shoppingclient.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;




@Service
public class ProductService {

    @Value("${PRODUCT_API_URL:http://localhost:8084}")
    private String productApiURL;

    public ProductDTO getProductByIdentifier(String productIdentifier) {

        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(productApiURL)
                    .build();

            Mono<ProductDTO> product = webClient.get()
                    .uri("/product/" + productIdentifier)
                    .retrieve()
                    .bodyToMono(ProductDTO.class);

            return product.block();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductNotFoundException();
        }

    }

}
