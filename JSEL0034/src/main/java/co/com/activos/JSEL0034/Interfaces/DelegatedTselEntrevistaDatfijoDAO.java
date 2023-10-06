package co.com.activos.JSEL0034.Interfaces;

import co.com.activos.JSEL0034.Controller.TselEntrevistaDatfijoDAO;
import co.com.activos.JSEL0034.ClassAbstract.TselEntrevistaDatfijoDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselEntrevistaDatfijo;

/**
 *
 * Delegado de datos entidad TSEL_ENTREVISTA_DATFIJO
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JJDK1.6
 *
 */
public class DelegatedTselEntrevistaDatfijoDAO {

    /**
     * Retorna los datos encontrados en tsel_entrevista_dat fijo para el modulo
     * qbjsel0011.
     *
     * @param tdcTdEpl
     * @param eplNd
     * @return
     */
    public static TselEntrevistaDatfijo cargarEntrevistaDatFijoEmpleado(String tdcTdEpl, Long eplNd) {
        TselEntrevistaDatfijoDAOInterface tselEntrevistaDatfijoDAOInterface = new TselEntrevistaDatfijoDAO();
        return tselEntrevistaDatfijoDAOInterface.cargarEntrevistaDatFijoEmpleado(tdcTdEpl, eplNd);

    }

    /**
     * Proceso de persistencia valores de entrevista DatFijo
     *
     * @param darFijo
     */
    public static void guardarEntrevistaDatFijo(TselEntrevistaDatfijo datFijo) throws Exception {
        TselEntrevistaDatfijoDAOInterface tselEntrevistaDatfijoDAOInterface = new TselEntrevistaDatfijoDAO();
        tselEntrevistaDatfijoDAOInterface.guardarEntrevistaDatFijo(datFijo);
    }
}
