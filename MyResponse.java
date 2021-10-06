package com.agiliz.product.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.agiliz.product.model.Product;

@Component
public class MyResponse {
	private int status;
	private String message;
	private List<Product> liProducts;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Product> getLiProducts() {
		return liProducts;
	}

	public void setLiProducts(List<Product> liProducts) {
		this.liProducts = liProducts;
	}

}
