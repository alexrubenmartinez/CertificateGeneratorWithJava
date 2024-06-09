package com.posgrado.certificates.model.dao;

import com.posgrado.certificates.model.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Integer> {
}
