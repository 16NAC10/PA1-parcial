package model;

import exception.PilotoIncorrectoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PilotoUnitTest {
    @Test
    public void instanciar_atributosCorrectos_Instancia() {
        Piloto piloto = Piloto.factory("Ignacio Páez", "36626965", LocalDate.of(1992, 8, 11));
        Assertions.assertNotNull(piloto);
    }

    @Test
    public void instanciar_nombreIncorrecto_Exception(){
        Exception exceptionNulo = Assertions.assertThrows(PilotoIncorrectoException.class, () -> Piloto.factory(null, "36626965", LocalDate.of(1992, 8, 11)));
        Exception exceptionVacio = Assertions.assertThrows(PilotoIncorrectoException.class,() -> Piloto.factory("", "36626965", LocalDate.of(1992, 8, 11)));
        Assertions.assertEquals("El nombre es obligatorio", exceptionNulo.getMessage());
        Assertions.assertEquals("El nombre es obligatorio", exceptionVacio.getMessage());
    }

    @Test
    public void instanciar_documentoIncorrecto_Exception(){
        Exception exceptionNulo = Assertions.assertThrows(PilotoIncorrectoException.class, () -> Piloto.factory("Ignacio Páez", null, LocalDate.of(1992, 8, 11)));
        Exception exceptionVacio = Assertions.assertThrows(PilotoIncorrectoException.class,() -> Piloto.factory("Ignacio Páez", "", LocalDate.of(1992, 8, 11)));
        Assertions.assertEquals("El documento es obligatorio", exceptionNulo.getMessage());
        Assertions.assertEquals("El documento es obligatorio", exceptionVacio.getMessage());
    }

    @Test
    public void instanciar_fechaNacimientoIncorrecto_Exception(){
        Exception exceptionNulo = Assertions.assertThrows(PilotoIncorrectoException.class, () -> Piloto.factory("Ignacio Páez", "36626965", null));
        Exception exceptionMayor = Assertions.assertThrows(PilotoIncorrectoException.class, () -> Piloto.factory("Ignacio Páez", "36626965", LocalDate.now().plusDays(1)));
        Assertions.assertEquals("La fecha de nacimiento es inválida", exceptionNulo.getMessage());
        Assertions.assertEquals("La fecha de nacimiento es inválida", exceptionMayor.getMessage());
    }

    @Test
    public void instanciar_fechaMenor18Anios_Exception(){
        Exception exception = Assertions.assertThrows(PilotoIncorrectoException.class, () -> Piloto.factory("Ignacio Páez", "36626965", LocalDate.of(2020, 8, 11)));
        Assertions.assertEquals("El piloto no puede ser menor de 18 años", exception.getMessage());
    }
}
