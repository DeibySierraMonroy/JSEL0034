package co.com.activos.JSEL0034.Interfaces;

import java.util.List;

import co.com.activos.JSEL0034.Controller.TselEmpleadoSGSSDAO;
import co.com.activos.JSEL0034.ClassAbstract.TselEmpleadoSGSSDAOInterface;
import co.com.activos.JSEL0034.Entidad.EmpresaEntity;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoSGSSSimpleEntity;

/**
 * Delegated entidad TselEmpleadoSGSS
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedTselEmpleadoSGSSDAO {

    /**
     * Retorna la informacion SGSS del empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public static TselEmpleadoSGSSSimpleEntity cargarInformacionSGSSEmpleado(String tdcTd, Long eplNd) {
        TselEmpleadoSGSSDAOInterface tselEmpleadoSGSSDAO = new TselEmpleadoSGSSDAO();
        return tselEmpleadoSGSSDAO.cargarInformacionSGSSEmpleado(tdcTd, eplNd);
    }

    /**
     * Procesa el guardado de la informacion SGSS del empleado
     *
     * @param infoSGSS
     * @throws Exception
     */
    public static void guardarInformacionSGSSEmpleado(TselEmpleadoSGSSSimpleEntity infoSGSS) throws Exception {
        TselEmpleadoSGSSDAOInterface tselEmpleadoSGSSDAO = new TselEmpleadoSGSSDAO();
        tselEmpleadoSGSSDAO.guardarInformacionSGSSEmpleado(infoSGSS);
    }

    /**
     * Retorna la lista de empresas por Tipo (EPS y AFP)
     *
     * @param tipo
     * @return
     */
    public static List<EmpresaEntity> cargarEmpresasSGSS(String tipo) {
        TselEmpleadoSGSSDAOInterface tselEmpleadoSGSSDAO = new TselEmpleadoSGSSDAO();
        return tselEmpleadoSGSSDAO.cargarEmpresasSGSS(tipo);
    }
}
