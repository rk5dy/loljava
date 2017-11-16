package hello.dao;

import java.util.List;

import hello.entity.Student;

public interface StudentDao {

 public boolean addEntity(Student student) throws Exception;
 public Student getEntityById(long id) throws Exception;
 public List<Student> getEntityList() throws Exception;
 public boolean deleteEntity(long id) throws Exception;
}
