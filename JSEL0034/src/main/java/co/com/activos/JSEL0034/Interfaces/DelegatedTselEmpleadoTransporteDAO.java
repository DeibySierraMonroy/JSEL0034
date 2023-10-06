package co.com.activos.JSEL0034.Interfaces;

import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import co.com.activos.JSEL0034.Controller.TselEmpleadoTransporteDAO;
import co.com.activos.JSEL0034.ClassAbstract.TselEmpleadoTransporteDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoTransporteEntity;

/**
 * Delegado de datos tipo transporte empleado.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedTselEmpleadoTransporteDAO {

    /**
     * Retorna la informacion de transporte asociada al empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public static List<TselEmpleadoTransporteEntity> cargarInformacionEmpleadoTransporte(String tdcTd, Long eplNd) {
        TselEmpleadoTransporteDAOInterface tselEmpleadoTransporteDAOInterface = new TselEmpleadoTransporteDAO();
        return tselEmpleadoTransporteDAOInterface.cargarInformacionEmpleadoTransporte(tdcTd, eplNd);
    }

    /**
     * Retorna la lista de tipos de transporte.
     *
     * @return
     */
    public static List<SelectItem> cargarListaTiposTransporte() {
        TselEmpleadoTransporteDAOInterface tselEmpleadoTransporteDAOInterface = new TselEmpleadoTransporteDAO();
        return tselEmpleadoTransporteDAOInterface.cargarListaTiposTransporte();
    }

    /**
     * Guardado Informacion Empleado Transporte
     *
     * @param empleadoTransporte
     * @throws Exception
     */
    public static void guardarInformacionEmpleadoTransporte(List<TselEmpleadoTransporteEntity> empleadoTransporte) throws Exception {
        for (TselEmpleadoTransporteEntity empTrans : empleadoTransporte) {
            TselEmpleadoTransporteDAOInterface tselEmpleadoTransporteDAOInterface = new TselEmpleadoTransporteDAO();
            tselEmpleadoTransporteDAOInterface.guardarInformacionEmpleadoTransporte(empTrans);
        }
    }

    public static void eliminarIInformacionEmpleadoTransporte(String tdcTd, Long eplNd, Long idTrans) throws Exception {
        TselEmpleadoTransporteEntity empTrans = new TselEmpleadoTransporteEntity();
        empTrans.setEplNd(eplNd);
        empTrans.setTdcTd(tdcTd);
        empTrans.setTveIdTipoVehiculo(idTrans);
        TselEmpleadoTransporteDAOInterface tselEmpleadoTransporteDAOInterface = new TselEmpleadoTransporteDAO();
        tselEmpleadoTransporteDAOInterface.eliminarInfoTransporte(empTrans);
    }
}
