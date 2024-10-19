package model;

import exception.PilotoIncorrectoException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Piloto {
    private UUID id;
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;

    private Piloto(UUID id, String nombre, String documento, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Piloto factory(String nombre, String documento, LocalDate fechaNacimiento) {
        if(nombre == null || nombre.isEmpty()){
            throw new PilotoIncorrectoException("El nombre es obligatorio");
        }
        if(documento == null || documento.isEmpty()){
            throw new PilotoIncorrectoException("El documento es obligatorio");
        }
        if(fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())){
            throw new PilotoIncorrectoException("La fecha de nacimiento es inválida");
        }
        if(Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18){
            throw new PilotoIncorrectoException("El piloto no puede ser menor de 18 años");
        }
        return new Piloto(UUID.randomUUID(), nombre, documento, fechaNacimiento);
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
