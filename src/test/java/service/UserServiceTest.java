package service;

import model.Role;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Александр on 19.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    protected UserService service;


    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "testAdmin", "adminTest@gmail.com", "newPass", true, getRolesAdmin(), "Имя","Фамилия", "адрес");
        User created = service.save(newUser);
        newUser.setId(created.getId());
        assertThat(newUser.getId(), is(notNullValue()));
    }

    @Test
    public void testGetUserId() throws Exception {
        User user = service.get(10);
        assertThat(user.getId(), is(notNullValue()));
        printUser(user);
    }

    @Test
    public void testGetNickName() throws Exception {
        User user = service.getNickName("UserTest");
        assertThat(user.getId(), is(notNullValue()));
        printUser(user);
    }


    @Test
    public void testEditUser() throws Exception{
        Random random = new Random();
        int count = random.nextInt(10000);
        User newUser = new User(null, "UserTest", count + "userTest@gmail.com", count + "newPassEdit", false, Collections.singleton(Role.ROLE_USER), count +"ИмяEdit",count +"ФамилияEdit", count +"адресEdit");
        User user = service.get(20);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setRoles(newUser.getRoles());
        user.setEnabled(newUser.isEnabled());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setAddress(newUser.getAddress());
        service.update(user);
        User userEdit = service.get(user.getId());
        assertEquals(user, userEdit);
        printUser(user);
        printUser(userEdit);

    }

    @Test
    public void getByEmailTest()throws Exception{
        User user = service.getByEmail("adminTest@gmail.com");
        assertThat(user.getId(), is(notNullValue()));
        printUser(user);
    }

    @Test
    public void getAllTest() throws Exception {
        List<User> users = service.getAll();
        assertNotNull(users);
        for (User user: users)
            assertThat(user.getId(), is(notNullValue()));
        System.out.println( "количество юзеров - " + users.size());
    }

    private Set<Role> getRolesAdmin() {
        Set<Role> roles = new HashSet<Role>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);
        Collections.singleton(roles);
        return roles;
    }

    private void printUser(User user){
        System.out.println("----------------------------------------------------------");
        System.out.println(user.toString());
        System.out.println("----------------------------------------------------------");
    }
}
