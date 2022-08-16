package com.ejercicios.automatizacion.questions;

import com.ejercicios.automatizacion.utils.Archivo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.FileInputStream;

public class RespuestaComparacion implements Question<Boolean> {

    private FileInputStream archivoPdf;

    public RespuestaComparacion(FileInputStream archivoPdf) {
        this.archivoPdf = archivoPdf;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return Archivo.comparaArchivos(archivoPdf);
    }

    public static RespuestaComparacion con(FileInputStream archivoPdf) {
        return new RespuestaComparacion(archivoPdf);

    }

}

