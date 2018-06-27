package pl.bjur.strzelec.dupa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bjur.strzelec.dupa.model.Klub;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DupaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void dupa() {
		Klub klub = new Klub();
	}

}
