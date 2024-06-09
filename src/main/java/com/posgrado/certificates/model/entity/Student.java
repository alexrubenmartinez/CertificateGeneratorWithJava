package com.posgrado.certificates.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table (name="tm_usuario")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    @Column(name="usu_nom")
    private String usu_nom;

    @Column(name="usu_apep")
    private String usu_apep;

    @Column(name="usu_apem")
    private String usu_apem;

    @Column(name="usu_correo")
    private String usu_correo;

    @Column(name="usu_pass")
    private String usu_pass;

    @Column(name="usu_sex")
    private String usu_sex;

    @Column(name="usu_telf")
    private String usu_telf;

    @Column(name="rol_id")
    private String rol_id;

    @Column(name="usu_dni")
    private String usu_dni;

    @Column(name="fech_crea")
    private String fech_crea;

    @Column(name="est")
    private String est;

    @Column(name="usu_cod_estudiante")
    private String usu_cod_estudiante;

    @Column(name="posg_id")
    private String posg_id;

    @Column(name="usu_deuda")
    private String usu_deuda;

    @Column(name="usu_sem_id_actual")
    private String usu_sem_id_actual;

    @Column(name="usu_sem_id_ingreso")
    private String usu_sem_id_ingreso;

    @Column(name="ciclo_actual")
    private String ciclo_actual;
}
