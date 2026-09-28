package com.example.Relaciones.Service.ServiceImpl;

import com.example.Relaciones.Entity.HistoriaClinica;
import com.example.Relaciones.Entity.Mascota;
import com.example.Relaciones.Repository.HistoriaClinicaRepository;
import com.example.Relaciones.Repository.MascotaRepository;
import com.example.Relaciones.Service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoriaClinicaImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    public List<HistoriaClinica> listarTodas() {
        return historiaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarPorId(Long id) {
        return historiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Historia Clínica no encontrada"));
    }

    @Override
    public HistoriaClinica crear(HistoriaClinica historia, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        historia.setMascota(mascota);
        return historiaRepository.save(historia);
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historia) {
        HistoriaClinica existente = buscarPorId(id);
        existente.setFechaApertura(historia.getFechaApertura());
        existente.setAntecedentes(historia.getAntecedentes());
        existente.setObservaciones(historia.getObservaciones());
        return historiaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!historiaRepository.existsById(id)) {
            throw new RuntimeException("Historia Clínica no existe");
        }
        historiaRepository.deleteById(id);
    }
}


