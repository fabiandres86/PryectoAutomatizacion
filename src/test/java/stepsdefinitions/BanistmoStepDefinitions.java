package stepsdefinitions;

import com.ejercicios.automatizacion.abilities.ReadPdf;
import com.ejercicios.automatizacion.hooks.DeletePdfFiles;
import com.ejercicios.automatizacion.questions.RespuestaComparacion;
import com.ejercicios.automatizacion.taks.IngresarALaPagina;
import com.ejercicios.automatizacion.taks.IngresarPrestamoAutos;
import com.ejercicios.automatizacion.userinterfaces.BanistmoHomePage;
import com.ejercicios.automatizacion.utils.Archivo;
import com.ejercicios.automatizacion.utils.Constantes;
import com.ejercicios.automatizacion.utils.Wait;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilBuilder;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.FileInputStream;
import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BanistmoStepDefinitions {

    private EnvironmentVariables environmentVariables;
    private String rutaDirectorio;
    private String nombreArchivoPdf;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before
    public void eliminarArchivos() {
        DeletePdfFiles.statementsDownloaded();
    }

    @Dado("que carolina esta en la pagina de banistmo")
    public void queCarolinaEstaEnLaPaginaDeBanistmo() {
        theActorCalled("Carolina").attemptsTo(Open.browserOn().the(BanistmoHomePage.class));
        rutaDirectorio = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalAccessError::new);
        nombreArchivoPdf = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalAccessError::new);

    }

    @Cuando("ingresa a la opcion de prestamos de auto")
    public void ingresaALaOpcionDePrestamosDeAuto() {
        theActorInTheSpotlight().attemptsTo(IngresarALaPagina.deBanistmo());
        theActorInTheSpotlight().attemptsTo(IngresarPrestamoAutos.con());

    }

    @Cuando("descarga el archivo pdf")
    public void descargaElArchivoPdf() throws IOException {
        Wait.ForSeconds(5000);
        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(rutaDirectorio + "/" + nombreArchivoPdf));

    }

    @Entonces("muestra el archivo correcto en formato pdf")
    public void muestraElArchivoCorrectoEnFormatoPdf() throws IOException {
        FileInputStream archivo = ReadPdf.as(theActorInTheSpotlight()).getFile();
        theActorInTheSpotlight().should(seeThat(RespuestaComparacion.con(archivo)));

    }


}
