package com.product.service;

import com.product.dto.Request;
import com.product.entity.Product;

public interface ProductService {
	Product getProductDetail (Request request) throws Exception;
	
}
