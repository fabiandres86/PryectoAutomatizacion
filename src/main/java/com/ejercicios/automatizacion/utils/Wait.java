package com.ejercicios.automatizacion.utils;

public class Wait {

    public static void ForSeconds(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Wait() {
    }
}
