package output;

import model.Piloto;

import java.util.UUID;

public interface CrearPilotoRepository {
    UUID crearPiloto(Piloto piloto);
    boolean buscarPiloto(String nombre);
}
