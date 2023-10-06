package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;
import javax.faces.model.SelectItem;
import co.com.activos.JSEL0034.Entidad.TSelNucleoFamiliar;
import co.com.activos.JSEL0034.Entidad.TipoDocumento;
import co.com.activos.JSEL0034.util.GestionRetornoObjeto;
import co.com.activos.JSEL0034.util.GestorDocumentalBhv;

/**
 * <interfaz>
 * Controlador de acceso a datos modelo Nucleo Familiar.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public interface TSelNucleoFamiliarDAOInterface {

    /**
     * Retorna el nucleo familiar el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public List<TSelNucleoFamiliar> cargarNucleoFamiliarEmpleado(String tdcTd, Long eplNd);

    /**
     * Persistencia registro nuclero familiar
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public void guardarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception;

    /**
     * Borrado registro Nucleo Familiar.
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public void eliminarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception;

    /**
     * *
     * Retorna la lista dependiendo del tipo invocado.
     *
     * @param tipo
     * @return
     */
    public List<SelectItem> cargarListaDependenciasNucleoFamiliar(String tipo);

    public String desEncriptarParametrosServlet(String desEncriptar);

    public GestionRetornoObjeto wsCargarArchivo(Long idDirectorio, String nombreArchivo);

    public GestorDocumentalBhv crearDeaCodigo(String deaCodigo, Long tipoDoc, String usuario, String nombreArchivo);

    public GestionRetornoObjeto procesarRespuestaWs(String xmlInput, String respuesta);

    public GestionRetornoObjeto actualizaAzCodigoCli(Long deaCodigo, String idArchivo, String fileName);

    public TipoDocumento obtenerTipoDocumento(String documento);

    public GestionRetornoObjeto generarPdf(String tdcTd, Long eplNd);

    public GestionRetornoObjeto eliminarDataErp(Long deaCodigo);

}
