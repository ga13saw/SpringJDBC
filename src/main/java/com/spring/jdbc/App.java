package com.spring.jdbc;

import com.spring.jdbc.config.AppConfig;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.impl.StudentDaoImpl;
import com.spring.jdbc.model.entities.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class App 
{

    public static void main(String[] args )
    {


        System.out.println( "Hello World!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        String insertQuery = "insert into student(id,name,city) values(?,?,?)";
//        int update = jdbcTemplate.update(insertQuery, 103, "Bumrah", "Mumbai");
//        System.out.println("no of rows updated- "+ update);

        StudentDao dao = context.getBean("dao", StudentDao.class);
        //INSERT
        //dao.insert(Student.builder().id(106).name("Kohli").city("delhi").build());

        //UPDATE
        //dao.update(Student.builder().id(105).name("Kotil").city("kolkata").build());
        //DELETE
        //dao.delete(102);

        //GETBYID
        dao.getStudentById(104);

        //GETALL
        dao.getAllStudents();
    }
}
