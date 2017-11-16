package hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import hello.entity.Student;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

  @Autowired
  SessionFactory sessionFactory;

  Session session = null;
  Transaction tx = null;

  @Override
  public boolean addEntity(Student student) throws Exception {
    session = sessionFactory.openSession();
    tx = session.beginTransaction();
    session.save(student);
    tx.commit();
    session.close();

    return false;
  }

  @Override
  public Student getEntityById(long id) throws Exception {
    session = sessionFactory.openSession();
    Student student = (Student) session.load(Student.class,
      new Long(id));
    tx = session.getTransaction();
    session.beginTransaction();
    tx.commit();
    return student;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Student> getEntityList() throws Exception {
    session = sessionFactory.openSession();
    tx = session.beginTransaction();
    List<Student> studentList = session.createCriteria(Student.class)
      .list();
    tx.commit();
    session.close();
    return studentList;
  }

  @Override
  public boolean deleteEntity(long id)
   throws Exception {
    session = sessionFactory.openSession();
    Object o = session.load(Student.class, id);
    tx = session.getTransaction();
    session.beginTransaction();
    session.delete(o);
    tx.commit();
    return false;
  }

}
