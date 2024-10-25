package com.learn.soap.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SoapDemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// This test will pass if the application context loads successfully.
		assertThat(applicationContext).isNotNull();
	}

	@Test
	void testSpecificBeanLoaded() {
		SoapDemoApplication.main(new String[]{});
		// Example test to check if a specific bean is loaded
		assertThat(applicationContext.getBean(SoapDemoApplication.class)).isNotNull();
	}

}
