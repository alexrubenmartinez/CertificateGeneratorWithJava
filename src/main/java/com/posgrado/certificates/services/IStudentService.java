package com.posgrado.certificates.services;

import com.posgrado.certificates.model.dto.StudentDto;
import com.posgrado.certificates.model.entity.Student;

import java.util.List;

public interface IStudentService
{
    List<Student> listAll();
    Student save(StudentDto student);
    Student findById(Integer id);
    void delete(Student student);
    boolean existById(Integer id);
}
