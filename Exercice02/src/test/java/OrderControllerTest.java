import static org.junit.Assert.*;

import org.example.Order;
import org.example.OrderController;
import org.example.OrderDao;
import org.example.OrderService;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;
import org.mockito.ArgumentCaptor;
public class OrderControllerTest {
    @Test
    public void testCreateOrder() {
        // Créez un mock pour OrderService et OrderDao
        OrderService orderServiceMock = Mockito.mock(OrderService.class);
        OrderDao orderDaoMock = Mockito.mock(OrderDao.class);

        OrderController orderController = new OrderController(orderServiceMock);


        Order order = new Order("12345", "Product 1", 10);

        Mockito.doNothing().when(orderServiceMock).createOrder(ArgumentMatchers.any(Order.class));
        Mockito.doNothing().when(orderDaoMock).saveOrder(ArgumentMatchers.any(Order.class));

        // Appelez la méthode createOrder de OrderController
        orderController.createOrder(order);

        // Vérifiez que OrderService.createOrder est appelé avec le bon argument
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        Mockito.verify(orderServiceMock, Mockito.times(1)).createOrder(orderCaptor.capture());
        assertEquals(order, orderCaptor.getValue());

        // Vérifiez que OrderDao.saveOrder est appelé avec l'objet de commande créé
        Mockito.verify(orderDaoMock, Mockito.times(1)).saveOrder(order);
    }
}
