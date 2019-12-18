package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	private static final String EMAIL = "user.default@gmail.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setName("User Default");
		user.setPassword("101010");
		user.setEmail(EMAIL);
		repository.save(user);
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("Darley Peres");
		user.setPassword("1234");
		user.setEmail("darleyperes@gmail.com");
		
		User response = repository.save(user);
		
		assertNotNull(response);
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> responseOpt = repository.findByEmailEquals(EMAIL);
		assertTrue(responseOpt.isPresent());
		assertEquals(responseOpt.get().getEmail(), EMAIL);
	}
}
