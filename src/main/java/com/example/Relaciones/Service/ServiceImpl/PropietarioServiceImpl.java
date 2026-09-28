package com.example.Relaciones.Service.ServiceImpl;

import com.example.Relaciones.Entity.Propietario;
import com.example.Relaciones.Repository.PropietarioRepository;
import com.example.Relaciones.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }


    @Override
    public Propietario buscarPorId(long id) {
        return (Propietario) propietarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Propietario no encontrado"));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {
        Propietario existente = buscarPorId(id);
        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());
        return propietarioRepository.save(existente);
    }


    @Override
    public void eliminar(long id) {
        if (!propietarioRepository.existsById(id)) {
            throw new RuntimeException("Propietario no existe");
        }
        propietarioRepository.deleteById(id);
    }
}