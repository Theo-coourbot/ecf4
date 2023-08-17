package com.authentification.authentification;

import com.authentification.authentification.entity.UserApp;
import com.authentification.authentification.repository.UserAppRepository;
import com.authentification.authentification.service.UserAppService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthentificationApplicationTests {
	@Mock
	UserAppRepository userAppRepository;
	@InjectMocks
	UserAppService userAppService;



	@Test void shouldAddNewUserWhenValidDataProvided() {

		UserApp userApp = new UserApp("theo", "oui");
		Mockito.when(userAppRepository.save(userApp)).thenReturn(userApp);


		UserApp result = userAppService.saveUser("theo", "oui");


		Assertions.assertEquals(userApp, result);
	}

}
