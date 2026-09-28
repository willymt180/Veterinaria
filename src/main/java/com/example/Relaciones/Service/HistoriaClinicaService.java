package com.example.Relaciones.Service;

import com.example.Relaciones.Entity.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodas();

    HistoriaClinica buscarPorId(Long id);

    HistoriaClinica crear(HistoriaClinica historia, Long mascotaId);

    HistoriaClinica actualizar(Long id, HistoriaClinica historia);

    void eliminar(Long id);
}