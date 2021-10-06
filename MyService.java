package com.agiliz.product.service;

import com.agiliz.product.model.Product;

public interface MyService {
	Product save(Product pt);

	Product getProduct(int id);

	Product update(int id, Product pt);

	Product delete(int id);

}
