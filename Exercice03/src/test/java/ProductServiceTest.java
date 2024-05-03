import org.example.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ProductServiceTest {

    @Test
    public void getProductSuccessTest() throws Exception{
        ProductApiClient mockApiClient = Mockito.mock(ProductApiClient.class);

        Product mocProduct = new Product("BANANA");
        Mockito.when(mockApiClient.getProduct("ID1")).thenReturn(mocProduct);

        ProductService productService = new ProductService(mockApiClient);

        Product relProduct = productService.getProduct("ID1");

        Mockito.verify(mockApiClient).getProduct("ID1");

        assertEquals(mocProduct, relProduct);
    }

    @Test
    public void getProductApiCallFailedTest() throws Exception{
        ProductApiClient mockApiClient = Mockito.mock(ProductApiClient.class);

        Mockito.when(mockApiClient.getProduct("ID1")).thenThrow(new APIException("API call failed"));

        ProductService productService = new ProductService(mockApiClient);

        assertThrows(APIException.class, () -> productService.getProduct("ID1"));

        Mockito.verify(mockApiClient).getProduct("ID1");
    }

    @Test
    public void getProductIncompatibleDataFormatTest() throws Exception{
        ProductApiClient mockApiClient = Mockito.mock(ProductApiClient.class);

        Mockito.when(mockApiClient.getProduct("ID1")).thenThrow(new DateFormatException("Data format is incompatible"));

        ProductService productService = new ProductService(mockApiClient);

        assertThrows(DateFormatException.class, () -> productService.getProduct("ID1"));

        Mockito.verify(mockApiClient).getProduct("ID1");
    }
}

