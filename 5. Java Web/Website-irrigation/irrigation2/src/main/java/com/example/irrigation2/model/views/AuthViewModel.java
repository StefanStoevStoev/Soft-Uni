package com.example.irrigation2.model.views;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuthViewModel {

    private String name;
    private Long id;
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userPhone;
    private String code;
    private LocalDateTime orderedAt;
    private BigDecimal price;
    private BigDecimal singlePrice;
    private int pieces;
    private int allPieces;
    private String urlPic;

    public AuthViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AuthViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AuthViewModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public AuthViewModel setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public AuthViewModel setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public AuthViewModel setUserAddress(String userAddress) {
        this.userAddress = userAddress;
        return this;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public AuthViewModel setUserPhone(String userPhone) {
        this.userPhone = userPhone;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AuthViewModel setCode(String code) {
        this.code = code;
        return this;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public AuthViewModel setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AuthViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public AuthViewModel setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public AuthViewModel setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public int getAllPieces() {
        return allPieces;
    }

    public AuthViewModel setAllPieces(int allPieces) {
        this.allPieces = allPieces;
        return this;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public AuthViewModel setUrlPic(String urlPic) {
        this.urlPic = urlPic;
        return this;
    }
}
