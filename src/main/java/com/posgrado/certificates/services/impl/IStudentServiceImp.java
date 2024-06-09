package com.posgrado.certificates.services.impl;

import com.posgrado.certificates.model.dao.StudentDao;
import com.posgrado.certificates.model.dto.StudentDto;
import com.posgrado.certificates.model.entity.Student;
import com.posgrado.certificates.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IStudentServiceImp implements IStudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> listAll() {
        return (List) studentDao.findAll();
    }

    @Transactional
    @Override
    public Student save(StudentDto studentDto) {
        Student savedStudent = Student.builder()
                .usu_id(studentDto.getUsu_id())
                .usu_nom(studentDto.getUsu_nom())
                .usu_apep(studentDto.getUsu_apep())
                .usu_apem(studentDto.getUsu_apem())
                .usu_dni(studentDto.getUsu_dni())
                .build();
        return studentDao.save(savedStudent);
    }

    @Transactional(readOnly = true)
    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    public boolean existById(Integer id) {
        return studentDao.existsById(id);
    }
}
