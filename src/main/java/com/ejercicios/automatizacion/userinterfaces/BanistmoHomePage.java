package com.ejercicios.automatizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class BanistmoHomePage extends PageObject {

    public final static Target MENU_ITEM = Target.the("Producto y servicios").locatedBy("#navbar-collapse-grid > ul > li:nth-child(3) > a");
    public final static Target OPCION_PRESTAMOS = Target.the("Opcion prestamos").locatedBy("#navbar-collapse-grid > ul > li.dropdown.menu-fw.open > ul > li > div.col-sm-6 > div:nth-child(2) > ul > li:nth-child(4) > a");
    public final static Target PRESTAMO_AUTO = Target.the("prestamo auto").locatedBy("#none > div > div > div.row-fluid.clearfix > div:nth-child(3) > div > div.col-xs-12.contenido > h2 > a");
    public final static Target TASAS_TARIFAS = Target.the("Tasas y tarifas").locatedBy("#filialTabs > li:nth-child(4) > a");
    public final static Target PDF_PROHIBICIONES = Target.the("PDF prohibiciones").locatedBy("#tab4 > table > tbody > tr:nth-child(2) > td:nth-child(2) > span > a");

}
