package com.banque;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.banque.ProjetsidApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjetsidApplication.class)
@WebAppConfiguration
public class ProjetsidApplicationTests {

	@Test
	public void contextLoads() {
	}

}
