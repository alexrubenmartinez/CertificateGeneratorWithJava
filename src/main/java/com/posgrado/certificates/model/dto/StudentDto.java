package com.posgrado.certificates.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@Builder
public class StudentDto implements Serializable {
    private Integer usu_id;
    private String usu_nom;

    private String usu_apep;

    private String usu_apem;

    private String usu_correo;

    private String usu_pass;

    private String usu_telf;

    private String rol_id;

    private String usu_dni;

    private String fech_crea;

    private String est;

    private String usu_cod_estudiante;

    private String usu_deuda;

    private String usu_sem_id_actual;

    private String usu_sem_id_ingreso;

    private String ciclo_actual;
}
