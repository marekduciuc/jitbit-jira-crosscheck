package eu.pricefx.monitoring.tickets.crossCecker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.pricefx.monitoring.tickets.crossChecker.CrossChekerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossChekerApplication.class)
@WebAppConfiguration
public class CrossChekerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
