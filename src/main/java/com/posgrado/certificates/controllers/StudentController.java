package com.posgrado.certificates.controllers;

import com.posgrado.certificates.model.dto.StudentDto;
import com.posgrado.certificates.model.entity.Student;
import com.posgrado.certificates.model.payload.MensajeResponse;
import com.posgrado.certificates.services.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@Tag(name = "Cliente resource")
public class StudentController {


    @Autowired
    private IStudentService studentService;


    @Operation(summary = "Endpoint que lista todos los estudiantes")
   @GetMapping("/clientes")
    public ResponseEntity<?> getAllStudents() {
       List<Student> getList = studentService.listAll();

       if (getList.isEmpty()){
           return new ResponseEntity<>(
                   MensajeResponse.builder()
                           .mensaje("No existen registros en la base de datos")
                           .object(null)
                           .build()
                   , HttpStatus.OK);

       }

       return new ResponseEntity<>(MensajeResponse.builder()
               .mensaje(String.valueOf(getList.size()))
               .object(getList)
               .build()
       ,HttpStatus.OK);
   }

   @PostMapping("/cliente")
    public ResponseEntity<?> addStudent( @RequestBody StudentDto studentDto) {
       Student studentAdd = null;
       try {
           studentAdd = studentService.save(studentDto);

           return new ResponseEntity<> (MensajeResponse.builder()
                   .mensaje("Guardado correctamente")
                   .object(StudentDto.builder().usu_id(studentAdd.getUsu_id()).usu_nom(studentAdd.getUsu_nom()).build())
                   .build(),HttpStatus.CREATED);
       }catch (DataAccessException exDT){
           return new ResponseEntity<>(
                   MensajeResponse.builder()
                   .mensaje(exDT.getMessage())
                   .object(null).build()
                   ,HttpStatus.METHOD_NOT_ALLOWED);
       }

   }



   @PutMapping("cliente/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
       Student studentUpdate = null;
       try{
           if (studentService.existById(id)){
               studentDto.setUsu_id(id);
               studentUpdate = studentService.save(studentDto);
               return new ResponseEntity<>(MensajeResponse.builder()
                       .mensaje("Modificado correctamente")
                       .object(StudentDto.builder()
                               .usu_id(studentUpdate.getUsu_id())
                               .usu_nom(studentUpdate.getUsu_nom())
                               .build()).build(),HttpStatus.CREATED);
           }
           else {
               return new ResponseEntity<>(MensajeResponse.builder()
                       .mensaje("El registro que quiere modificar no existe en la base de datos")
                       .object(null).build(),HttpStatus.NOT_FOUND);
           }
       }catch (DataAccessException exDT){
           return new ResponseEntity<>(
                   MensajeResponse.builder()
                           .mensaje(exDT.getMessage())
                           .object(null).build()
                   ,HttpStatus.INTERNAL_SERVER_ERROR);
       }



   }

   @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
       try {
           Student studentDelete = studentService.findById(id);

           if (studentDelete != null){
               studentService.delete(studentDelete);
               return new ResponseEntity<>(MensajeResponse.builder()
                       .mensaje("Registro"+studentDelete.getUsu_nom()+" eliminado correctamente").build(),HttpStatus.NO_CONTENT);
           }
           else {
               return new ResponseEntity<>(MensajeResponse.builder()
                       .mensaje("Ese registro no existe").build(),HttpStatus.NOT_FOUND);
           }


       }catch (DataAccessException exDT){
           return new ResponseEntity<>(
                   MensajeResponse.builder()
                           .mensaje(exDT.getMessage())
                           .object(null).build()
                   ,HttpStatus.INTERNAL_SERVER_ERROR);
       }


   }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
      Student student = studentService.findById(id);

      if (student == null){
          return new ResponseEntity<>(MensajeResponse.builder()
                  .mensaje("El registro que intenta buscar no se encuentra en la base de datos")
                  .object(null).build(),HttpStatus.NOT_FOUND);
      }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Registro encontrado")
                .object(StudentDto.builder()
                        .usu_id(student.getUsu_id())
                        .usu_nom(student.getUsu_nom())
                        .build()).build(),HttpStatus.OK);
    }






}
