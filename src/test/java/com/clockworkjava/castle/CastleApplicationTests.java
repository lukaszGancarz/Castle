package com.clockworkjava.castle;

import com.clockworkjava.castle.domain.repository.InMemoryRepository;
import com.clockworkjava.castle.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CastleApplicationTests {

//	@Autowired
	Knight knight;

//	@Autowired
	InMemoryRepository inMemoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCastle() {
		String except = "Znajduje sie tu zamek o nazwie East Watch. " +
				"Zamieszkaly przez rycerza Rycerz o imieniu Lancelot(29). " +
				"Ma za zadanie Uratuj ksiezniczke";

		assertEquals(except, inMemoryRepository.toString());
	}
}
