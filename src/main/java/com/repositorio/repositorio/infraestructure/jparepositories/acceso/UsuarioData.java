package com.repositorio.repositorio.infraestructure.jparepositories.acceso;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuario")
public class UsuarioData {
    @Id
    private Long id;

    @Column
    private String usuario;
    @Column
    private String contrasenia;


}
