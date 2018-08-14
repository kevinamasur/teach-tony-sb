package com.icims.tony.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icims.tony.demo.entities.DemoEntity;
import com.icims.tony.demo.repositories.DemoRepository;

@Service
public class DemoService implements DemoServiceInterface {
	
	@Autowired
	private DemoRepository demoRepository;
	
	private int count = 0;
	
	@Override
	public void runDemo() {
		System.out.println("Hello world : " + count);
		count++;
		
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setBar("bar");
		demoEntity.setFoo("foo");
		demoRepository.save(demoEntity);
	}

}
