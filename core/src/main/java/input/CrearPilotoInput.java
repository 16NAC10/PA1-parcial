package input;

import exception.PilotoIncorrectoException;
import model.Piloto;

import java.util.UUID;

public interface CrearPilotoInput {
    UUID crearPiloto(Piloto piloto) throws PilotoIncorrectoException;
}
