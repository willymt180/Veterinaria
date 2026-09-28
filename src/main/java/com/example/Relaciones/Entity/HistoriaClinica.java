package com.example.Relaciones.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de apertura es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fechaApertura;

    @NotBlank(message = "Los antecedentes son obligatorios")
    private String antecedentes;

    @NotBlank(message = "Las observaciones son obligatorias")
    private String observaciones;

    @OneToOne(mappedBy = "historiaClinica")
    private Mascota mascota;
}