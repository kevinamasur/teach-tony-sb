package com.icims.tony.demo.services;

import org.springframework.stereotype.Service;

@Service
public class DemoService implements DemoServiceInterface {
	
	private int count = 0;
	
	@Override
	public void runDemo() {
		System.out.println("Hello world : " + count);
		count++;
	}

}
