package com.ejercicios.automatizacion.taks;

import com.ejercicios.automatizacion.userinterfaces.BanistmoHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class IngresarALaPagina implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        WaitUntil.the(BanistmoHomePage.MENU_ITEM, isVisible());
        actor.attemptsTo(Click.on(BanistmoHomePage.MENU_ITEM));

        WaitUntil.the(BanistmoHomePage.OPCION_PRESTAMOS, isVisible()).forNoMoreThan(20);
        actor.attemptsTo(Click.on(BanistmoHomePage.OPCION_PRESTAMOS));

        WaitUntil.the(BanistmoHomePage.PRESTAMO_AUTO, isEnabled()).forNoMoreThan(60);
        actor.attemptsTo(Click.on(BanistmoHomePage.PRESTAMO_AUTO));

        WaitUntil.the(BanistmoHomePage.TASAS_TARIFAS, isVisible()).forNoMoreThan(30);
        actor.attemptsTo(Click.on(BanistmoHomePage.TASAS_TARIFAS));

        WaitUntil.the(BanistmoHomePage.TASAS_TARIFAS, isVisible()).forNoMoreThan(30);
        actor.attemptsTo(Scroll.to(BanistmoHomePage.TASAS_TARIFAS));
        actor.attemptsTo(Click.on(BanistmoHomePage.TASAS_TARIFAS));


    }

    public static IngresarALaPagina deBanistmo() {
        return Tasks.instrumented(IngresarALaPagina.class);

    }
}
