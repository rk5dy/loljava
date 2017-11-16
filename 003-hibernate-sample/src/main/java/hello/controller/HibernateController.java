package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entity.Status;
import hello.entity.Student;
import hello.services.StudentServices;

@Controller
@RequestMapping("/student")
public class HibernateController {

    @Autowired
    StudentServices studentServices;

    /* Submit form in Spring Restful Services */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
      Status addStudent(@RequestBody Student student) {
       try {
        studentServices.addEntity(student);
        return new Status(1, "Student added Successfully !");
       } catch (Exception e) {
        // e.printStackTrace();
        return new Status(0, e.toString());
       }
    }

    /* Ger a single objct in Json form in Spring Rest Services */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
      Student getStudent(@PathVariable("id") long id) {
       Student student = null;
       try {
        student = studentServices.getEntityById(id);

       } catch (Exception e) {
        e.printStackTrace();
       }
       return student;
    }

    /* Getting List of objects in Json format in Spring Restful Services */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
      List<Student> getStudent() {

       List<Student> studentList = null;
       try {
        studentList = studentServices.getEntityList();

       } catch (Exception e) {
        e.printStackTrace();
       }

       return studentList;
    }

    /* Delete an object from DB in Spring Restful Services */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Status deleteStudent(@PathVariable("id") long id) {

     try {
      studentServices.deleteEntity(id);
      return new Status(1, "Student deleted Successfully !");
     } catch (Exception e) {
      return new Status(0, e.toString());
     }

    }
}
