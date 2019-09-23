/*package fr.projet.service.test;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.projet.app.App;
import fr.projet.domain.Customer;
import fr.projet.exception.BadRequestException;
import fr.projet.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class UserServiceTest {
    
    @Autowired
    private UserService userService;

	@Test
	public void saveTest() throws BadRequestException {
		Customer user = new Customer("stazi", "Salim", "pwd");
		user = userService.save(user);
		assertNotNull("Id should be set after save.", user.getId());
	}
	
	@Test(expected = DataAccessException.class)
	public void saveExistingTest() throws BadRequestException {
		Customer user = new Customer("stazi", "Salim", "pwd");
		user.setId(1L);
		user = userService.save(user);
	}
	
	

}
*/
