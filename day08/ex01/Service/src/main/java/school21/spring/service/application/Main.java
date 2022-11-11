package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("====================UsersRepositoryJdbcImpl=========================");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbcImpl", UsersRepository.class);
        System.out.println(usersRepository.findAll());
        System.out.println(usersRepository.findById(1L));
        System.out.println(usersRepository.findByEmail("leonid123@gmail.com"));
        User test = new User(4L, "helloworld@ya.ru");
        usersRepository.save(test);
        System.out.println(usersRepository.findAll());
        test.setEmail("LOL@mail.ru");
        usersRepository.update(test);
        System.out.println(usersRepository.findAll());
        usersRepository.delete(test.getId());
        System.out.println(usersRepository.findAll());


        System.out.println("");

        System.out.println("====================UsersRepositoryJdbcTemplateImpl=================");
        User test2 = new User(5L, "helloworld@ya.ru");
        System.out.println(usersRepository.findAll());
        System.out.println(usersRepository.findById(1L));
        System.out.println(usersRepository.findByEmail("leonid123@gmail.com"));
        usersRepository.save(test2);
        System.out.println(usersRepository.findAll());
        test2.setEmail("LOL@mail.ru");
        usersRepository.update(test2);
        System.out.println(usersRepository.findAll());
        usersRepository.delete(test2.getId());
        System.out.println(usersRepository.findAll());
    }
}