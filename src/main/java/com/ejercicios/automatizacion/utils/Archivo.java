package com.ejercicios.automatizacion.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Archivo {


    public static FileInputStream procesar(String rutaArchvo) throws FileNotFoundException {
        FileInputStream flujo = null;
        File archivo = new File(rutaArchvo);
        if (archivo.exists() && archivo.isFile()) {
            flujo = new FileInputStream(archivo);
        }
        return flujo;
    }

    public static String calcularMD5(FileInputStream archivo) throws IOException {
        String MD5 = DigestUtils.md5Hex(archivo);
        return MD5;
    }

    public static boolean comparaArchivos(FileInputStream archivo) {
        try {
            String MD5_1 = calcularMD5(procesar(Constantes.RUTA_ARCHIVO));
            String MD5_2 = calcularMD5(archivo);
            if (!MD5_1.equals(MD5_2)) {
                return false;
            }
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return true;
    }
}
