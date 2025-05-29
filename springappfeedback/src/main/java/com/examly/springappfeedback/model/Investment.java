package com.examly.springappfeedback.model;

public class Investment {
     private Long investmentId;
    private String name;
    private String description;
    private String type;
    private Double purchasePrice;
    private Double currentPrice;
    private Integer quantity;
    private String purchaseDate;
    private String status;
    public Long getInvestmentId() {
        return investmentId;
    }
    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public Double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
