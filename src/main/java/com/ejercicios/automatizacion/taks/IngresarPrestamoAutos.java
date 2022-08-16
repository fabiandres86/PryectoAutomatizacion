package com.ejercicios.automatizacion.taks;

import com.ejercicios.automatizacion.interactions.SwitchToNewWindow;
import com.ejercicios.automatizacion.userinterfaces.BanistmoHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarPrestamoAutos implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(BanistmoHomePage.TASAS_TARIFAS, isVisible()).forNoMoreThan(30);
        actor.attemptsTo(Scroll.to(BanistmoHomePage.TASAS_TARIFAS));
        actor.attemptsTo(Click.on(BanistmoHomePage.TASAS_TARIFAS));

        WaitUntil.the(BanistmoHomePage.PDF_PROHIBICIONES, isVisible()).forNoMoreThan(30);
        actor.attemptsTo(Scroll.to(BanistmoHomePage.PDF_PROHIBICIONES));
        actor.attemptsTo(Click.on(BanistmoHomePage.PDF_PROHIBICIONES));

        actor.attemptsTo(SwitchToNewWindow.change());


    }

    public static IngresarPrestamoAutos con() {
        return Tasks.instrumented(IngresarPrestamoAutos.class);

    }
}
