package org.example;

import java.util.Date;

public class OrderService {

    private final OrderDao orderDao;

    // Initialisez le OrderService avec le OrderDao
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // Méthode pour créer une commande
    public void createOrder(Order order) {
        // Ajoutez des détails supplémentaires à la commande (par exemple, la date de création)
        //order.setCreatedAt(new Date());

        // Appelez la méthode saveOrder du OrderDao pour enregistrer la commande dans la base de données
        orderDao.saveOrder(order);
    }
}