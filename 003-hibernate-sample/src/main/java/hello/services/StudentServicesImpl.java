package hello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.dao.StudentDao;
import hello.entity.Student;

@Service
public class StudentServicesImpl implements StudentServices {

 @Autowired
 StudentDao studentDao;

 @Override
 public boolean addEntity(Student student) throws Exception {
  return studentDao.addEntity(student);
 }

 @Override
 public Student getEntityById(long id) throws Exception {
  return studentDao.getEntityById(id);
 }

 @Override
 public List<Student> getEntityList() throws Exception {
  return studentDao.getEntityList();
 }

 @Override
 public boolean deleteEntity(long id) throws Exception {
  return studentDao.deleteEntity(id);
 }

}
