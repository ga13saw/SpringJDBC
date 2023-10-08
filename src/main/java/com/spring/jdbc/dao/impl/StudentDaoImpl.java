package com.spring.jdbc.dao.impl;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.model.entities.Student;
import com.spring.jdbc.rowmapper.StudentMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Data
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insert(Student student) {
        System.out.println("going to insert student- "+ student);
        String insertQuery = "insert into student(id,name,city) values(?,?,?)";
        int inserted = jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
        System.out.println(String.format(" %d row/rows inserted successfully.",inserted));
        return inserted;

    }

    @Override
    public int update(Student student) {
        System.out.println("Updating student with id- "+ student.getId());
        String updateQuery = "update student set name=?, city=? where id=?";
        int updated = jdbcTemplate.update(updateQuery,student.getName(),student.getCity(),student.getId());
        System.out.println(String.format(" %d row/rows updated successfully.",updated));
        return updated;
    }

    @Override
    public int delete(int id) {
        System.out.println("Deleting student with id- "+ id);
        String deleteQuery = "delete from student where id=?";
        int deleted = jdbcTemplate.update(deleteQuery,id);
        System.out.println(String.format(" %d row/rows deleted successfully.",deleted));
        return deleted;
    }

    @Override
    public Student getStudentById(int id) {
        String getByIdQuery = "select id,name,city from student where id=?";
        Student student = jdbcTemplate.queryForObject(getByIdQuery,studentMapper,id);
        System.out.println("Successfully fetched student for id-" + student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String getByIdQuery = "select * from student";
        List<Student> student = jdbcTemplate.query(getByIdQuery, studentMapper);
        System.out.println("Successfully fetched student for id-" + student);
        return student;
    }

}
