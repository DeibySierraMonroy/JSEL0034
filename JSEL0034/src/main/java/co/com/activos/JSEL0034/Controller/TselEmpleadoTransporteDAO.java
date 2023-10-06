package co.com.activos.JSEL0034.Controller;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

import oracle.jdbc.OracleTypes;

import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.JSEL0034.ClassAbstract.TselEmpleadoTransporteDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoTransporteEntity;

/**
 * Controlador de acceso a datos Empleado Transporte.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TselEmpleadoTransporteDAO implements TselEmpleadoTransporteDAOInterface {

    /**
     * Retorna la informacion de transporte asociada al empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public List<TselEmpleadoTransporteEntity> cargarInformacionEmpleadoTransporte(String tdcTd, Long eplNd) {

        List<TselEmpleadoTransporteEntity> empleadoTransporte = new ArrayList<TselEmpleadoTransporteEntity>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_INFO_TRANSPORTE(?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);
                TselEmpleadoTransporteEntity tmp;
                while (rs.next()) {
                    tmp = new TselEmpleadoTransporteEntity();
                    tmp.setAudFecha(rs.getDate("AUD_FECHA"));
                    tmp.setAudUser(rs.getString("AUD_USER"));
                    tmp.setEplNd(rs.getLong("EPL_ND"));
                    tmp.setItem(rs.getLong("ITEM"));
                    tmp.setTdcTd(rs.getString("TDC_TD"));
                    tmp.setTetMarca(rs.getLong("TET_MARCA"));
                    tmp.setTetModelo(rs.getString("TET_MODELO"));
                    tmp.setTetPropio(rs.getString("TET_PROPIO"));
                    tmp.setTveIdTipoVehiculo(rs.getLong("TVE_ID_TIPO_VEHICULO"));
                    tmp.setNuevoRegistro(false);
                    empleadoTransporte.add(tmp);
                }
            } else {
                System.out.println("TselEmpleadoTransporteDAO.cargarInformacionEmpleadoTransporte ->" + cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("TselEmpleadoTransporteDAO.cargarInformacionEmpleadoTransporte -> Error cargando informacion transporte empleado, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empleadoTransporte;
    }

    /**
     * Retorna la lista de tipos de transporte
     *
     * @return
     */
    public List<SelectItem> cargarListaTiposTransporte() {
        List<SelectItem> listaTiposTransporte = new ArrayList<SelectItem>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_LISTA_TIPOS_TRANS(?,?)}");
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(1) == null) {
                ResultSet rs = (ResultSet) cs.getObject(2);

                while (rs.next()) {
                    listaTiposTransporte.add(new SelectItem(rs.getLong("VALUE"), rs.getString("LABEL")));
                }
            } else {
                System.out.println("TselEmpleadoTransporteDAO.cargarListaTiposTransporte ->" + cs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("TselEmpleadoTransporteDAO.cargarListaTiposTransporte -> Error cargando lista tipos transporte, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaTiposTransporte;
    }

    /**
     * Guardado Informacion Empleado Transporte
     *
     * @param empleadoTransporte
     * @throws Exception
     */
    public void guardarInformacionEmpleadoTransporte(TselEmpleadoTransporteEntity empleadoTransporte) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_GUARDAR_INFO_TRANSPORTE(?,?,?,?,?,?)}");
            cs.setString(1, empleadoTransporte.getTdcTd());
            cs.setLong(2, empleadoTransporte.getEplNd());
            cs.setLong(3, empleadoTransporte.getItem());
            cs.setString(4, empleadoTransporte.getTetPropio());

            try {
                cs.setLong(5, empleadoTransporte.getTveIdTipoVehiculo());
            } catch (Exception e) {
                cs.setObject(5, null);
            }

            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(6) == null)) {
                throw new Exception(cs.getString(6));
            }
        } catch (Exception e) {
            throw new Exception("TselEmpleadoTransporteDAO.guardarInformacionEmpleadoTransporte -> Error guardando informacion transporte empleado, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Elimina los tipo de transporte no seleccionados
     */
    public void eliminarInfoTransporte(TselEmpleadoTransporteEntity empleadoTransporte) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_ELIMINAR_INFO_TRANSPORTE(?,?,?,?)}");
            cs.setString(1, empleadoTransporte.getTdcTd());
            cs.setLong(2, empleadoTransporte.getEplNd());
            cs.setLong(3, empleadoTransporte.getTveIdTipoVehiculo());
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(4) == null)) {
                throw new Exception(cs.getString(6));
            }
        } catch (Exception e) {
            throw new Exception("TselEmpleadoTransporteDAO.eliminarInfoTransporte -> Error eliminando informacion transporte empleado, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
