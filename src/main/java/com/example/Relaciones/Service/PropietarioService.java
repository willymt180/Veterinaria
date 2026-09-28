package com.example.Relaciones.Service;

import com.example.Relaciones.Entity.Propietario;
import java.util.*;

public interface PropietarioService {
 List<Propietario>listarTodos();

 Propietario buscarPorId(long id);

 Propietario guardar(Propietario propietario);

 Propietario actualizar(Long id, Propietario propietario);

 void eliminar(long id);
}