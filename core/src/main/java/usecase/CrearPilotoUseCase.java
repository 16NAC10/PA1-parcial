package usecase;

import exception.PilotoIncorrectoException;
import input.CrearPilotoInput;
import model.Piloto;
import output.CrearPilotoRepository;

import java.util.UUID;

public class CrearPilotoUseCase implements CrearPilotoInput {
    private CrearPilotoRepository crearPilotoRepository;
    //private BuscarPilotoRepository buscarPilotoRepository;

    public CrearPilotoUseCase(CrearPilotoRepository crearPilotoRepository) {
        this.crearPilotoRepository = crearPilotoRepository;
    }

    @Override
    public UUID crearPiloto(Piloto piloto) throws PilotoIncorrectoException {
        if(crearPilotoRepository.buscarPiloto(piloto.getNombre())){
            throw new PilotoIncorrectoException(String.format("Ya existe un piloto con el nombre" + piloto.getNombre()));
        }
        return crearPilotoRepository.crearPiloto(piloto);
    }
}
