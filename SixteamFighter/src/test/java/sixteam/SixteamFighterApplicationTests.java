package sixteam;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sixteam.t6_14.model.ActiveService;
import sixteam.t6_14.model.Actives;

@SpringBootTest
class SixteamFighterApplicationTests {
	@Autowired
	private ActiveService activeService;

	@Test
public	void contextLoads() {
		List<Actives> actives= activeService.findAll();
		System.out.println(actives);
	}

}
