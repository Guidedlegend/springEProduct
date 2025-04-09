package com.hello.amazon;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String message) {
		 super(message);
	}

}
