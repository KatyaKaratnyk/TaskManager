package ua.karatnyk.tests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enums.Role;
import ua.karatnyk.service.UserService;

@Transactional
public class UserSaveTest extends BaseTest{

    @Autowired
    UserService userService;
    
    private UserEntity user;
    
    @Before
    public void initUser() {
    	user = new UserEntity();
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test@i.ua");
        user.setPassword("123456");
        user.setRole(Role.ROLE_USER);
    }

    @Test
    public void testSave() {
        userService.saveUser(user);;
    }
 
}
