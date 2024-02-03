package com.enoca.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.challenge.data.entity.Cart;
import com.enoca.challenge.data.entity.CartItem;
import com.enoca.challenge.data.entity.CartStatus;
import com.enoca.challenge.data.entity.Order;
import com.enoca.challenge.data.entity.OrderItem;
import com.enoca.challenge.data.repository.CartRepository;
import com.enoca.challenge.data.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
   
    @Autowired 
    private CartRepository cartRepository;
    
    @Autowired
    private CartService cartService;
    
    

    @Override
    public Order placeOrder(Long cartId) {
        Cart cart = cartRepository.getById(cartId);

        if (cart != null) {
            Order order = new Order();
            order.setCustomer(cart.getCustomer());

            List<CartItem> cartItems = cart.getCartItems();
            List<OrderItem> orderItems = new ArrayList<>();
            double totalOrderPrice = 0.0;

            for (CartItem cartItem : cartItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(cartItem.getProduct());
                orderItem.setQuantity(cartItem.getQuantity());

                double itemTotalPrice = cartItem.getProduct().getPrice() * cartItem.getQuantity();
                orderItem.setPriceAtOrder(itemTotalPrice); 

                totalOrderPrice += itemTotalPrice;
                orderItems.add(orderItem);
            }

            order.setItems(orderItems);
            order.setTotalPrice(totalOrderPrice);
            

            Order savedOrder = orderRepository.save(order);
            
            
            
           
            cartService.emptyCart(cartId);
            cart.setStatus(CartStatus.COMPLETED);
            cartRepository.save(cart);
           
            
            return savedOrder;
        }
        return null;
        }

    @Override
    public Order getOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        return optionalOrder.orElse(null);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomer_Id(customerId);
    }

   

    

}