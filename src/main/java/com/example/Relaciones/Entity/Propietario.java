package com.example.Relaciones.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "propietario")
@Getter
@Setter
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    private String documento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "\\d{10}",
            message = "El teléfono debe tener 10 dígitos"
    )
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "propietario")
    private List<Mascota> mascotas;
}