package org.example;


public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws APIException, DateFormatException {
        return productApiClient.getProduct(productId);
    }
}
