package com.enoca.challenge.controller.DTO;


public class AddProductRequest {
    
    private Long productId;
    private int quantity;

    

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

