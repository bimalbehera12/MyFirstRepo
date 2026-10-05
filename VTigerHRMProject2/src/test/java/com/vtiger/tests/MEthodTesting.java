package com.vtiger.tests;

import java.util.UUID;

import org.testng.annotations.Test;

public class MEthodTesting {

	@Test
	public void test() {
		String data = UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
		//return data;
		System.out.println(data);
	}
}
