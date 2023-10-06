package co.com.activos.JSEL0034.Interfaces;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.activos.JSEL0034.Controller.TSelNucleoFamiliarDAO;
import co.com.activos.JSEL0034.ClassAbstract.TSelNucleoFamiliarDAOInterface;
import co.com.activos.JSEL0034.Entidad.TSelNucleoFamiliar;
import co.com.activos.JSEL0034.Entidad.TipoDocumento;
import co.com.activos.JSEL0034.util.GestionRetornoObjeto;
import co.com.activos.JSEL0034.util.GestorDocumentalBhv;

/**
 * Delegado de datos nucleo familiar empleado.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedTSelNucleoFamiliarDAO {

    static TSelNucleoFamiliarDAOInterface tselNucleoFamiliarDAO = new TSelNucleoFamiliarDAO();

    /**
     * Retorna el nucleo familiar el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public static List<TSelNucleoFamiliar> cargarNucleoFamiliarEmpleado(String tdcTd, Long eplNd) {

        return tselNucleoFamiliarDAO.cargarNucleoFamiliarEmpleado(tdcTd, eplNd);
    }

    /**
     * Persistencia registro nuclero familiar
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public static void guardarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception {

        tselNucleoFamiliarDAO.guardarRegistroNucleoFamiliar(nucleoFamiliar);
    }

    /**
     * Borrado registro Nucleo Familiar.
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public static void eliminarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception {

        tselNucleoFamiliarDAO.eliminarRegistroNucleoFamiliar(nucleoFamiliar);
    }

    /**
     * *
     * Retorna la lista dependiendo del tipo invocado.
     *
     * @param tipo
     * @return
     */
    public static List<SelectItem> cargarListaDependenciasNucleoFamiliar(String tipo) {

        return tselNucleoFamiliarDAO.cargarListaDependenciasNucleoFamiliar(tipo);
    }

    public static String desEncriptarParametrosServlet(String desEncriptar) {

        return tselNucleoFamiliarDAO.desEncriptarParametrosServlet(desEncriptar);
    }

    public static GestionRetornoObjeto wsCargarArchivo(Long idDirectorio, String nombreArchivo) {

        return tselNucleoFamiliarDAO.wsCargarArchivo(idDirectorio, nombreArchivo);
    }

    public static GestorDocumentalBhv crearDeaCodigo(String deaCodigo, Long tipoDoc, String usuario, String nombreArchivo) {
        return tselNucleoFamiliarDAO.crearDeaCodigo(deaCodigo, tipoDoc, usuario, nombreArchivo);
    }

    public static GestionRetornoObjeto procesarRespuestaWs(String xmlInput, String respuesta) {
        return tselNucleoFamiliarDAO.procesarRespuestaWs(xmlInput, respuesta);
    }

    public static GestionRetornoObjeto actualizaAzCodigoCli(Long deaCodigo, String idArchivo, String fileName) {
        return tselNucleoFamiliarDAO.actualizaAzCodigoCli(deaCodigo, idArchivo, fileName);
    }

    public static TipoDocumento obtenerTipoDocumento(String documento) {
        return tselNucleoFamiliarDAO.obtenerTipoDocumento(documento);
    }

    public static GestionRetornoObjeto generarPdf(String tdcTd, Long eplNd) {
        return tselNucleoFamiliarDAO.generarPdf(tdcTd, eplNd);
    }

    public static GestionRetornoObjeto eliminarDataErp(Long deaCodigo) {
        return tselNucleoFamiliarDAO.eliminarDataErp(deaCodigo);
    }
}
