package co.com.activos.JSEL0034.Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.JSEL0034.ClassAbstract.TselEntrevistaDatfijoDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselEntrevistaDatfijo;

/**
 * Controlador de acceso a datos entidad TSEL_ENTREVISTA_DATFIJO.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TselEntrevistaDatfijoDAO implements Serializable, TselEntrevistaDatfijoDAOInterface {

    private static final long serialVersionUID = 1L;

    /**
     * Retorna los datos encontrados en tsel_entrevista_dat fijo para el modulo
     * qbjsel0011.
     *
     * @param tdcTdEpl
     * @param eplNd
     * @return
     */
    public TselEntrevistaDatfijo cargarEntrevistaDatFijoEmpleado(String tdcTdEpl, Long eplNd) {
        TselEntrevistaDatfijo tdatfijo = new TselEntrevistaDatfijo(tdcTdEpl, eplNd);
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_ENTRE_DATFIJO_EMPL(?,?,?,?)}");
            cs.setString(1, tdcTdEpl);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);

                while (rs.next()) {
                    tdatfijo.setEdfAportaVivienda(rs.getString("EDF_APORTA_VIVIENDA"));
                    tdatfijo.setEdfNumeroHijos(rs.getInt("EDF_NUMERO_HIJOS"));
                    tdatfijo.setEdfNumHijosVivenCandt(rs.getInt("EDF_NUM_HIJOS_VIV_CANDT"));
                    tdatfijo.setEdfQuienCuidaHijos(rs.getString("EDF_QUIEN_CUIDA_HIJOS"));
                    tdatfijo.setEplNd(rs.getLong("EPL_ND"));
                    tdatfijo.setTdcTdEpl(rs.getString("TDC_TD_EPL"));
                }
            } else {
                System.out.println("TselEntrevistaDatfijoDAO.cargarEntrevistaDatFijoEmpleado> " + cs.getString(3));
            }

        } catch (Exception e) {
            System.out.println("TselEntrevistaDatfijoDAO.cargarEntrevistaDatFijoEmpleado> Error cargando informacion Entrevista DatFijo " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tdatfijo;
    }

    /**
     * Proceso de persistencia valores de entrevista DatFijo
     *
     * @param darFijo
     */
    public void guardarEntrevistaDatFijo(TselEntrevistaDatfijo datFijo) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_GUARDAR_ENTRE_DATFIJO_EMPL(?,?,?,?,?,?,?)}");
            cs.setString(1, datFijo.getTdcTdEpl());
            cs.setLong(2, datFijo.getEplNd());
            cs.setInt(3, datFijo.getEdfNumeroHijos());
            cs.setString(4, datFijo.getEdfQuienCuidaHijos());
            cs.setInt(5, datFijo.getEdfNumHijosVivenCandt());
            cs.setString(6, datFijo.getEdfAportaVivienda());
            cs.registerOutParameter(7, OracleTypes.VARCHAR);
            cs.execute();

            if (!(cs.getString(7) == null)) {
                System.out.println("TselEntrevistaDatfijoDAO.guardarEntrevistaDatFijo> " + cs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("TselEntrevistaDatfijoDAO.guardarEntrevistaDatFijo> Error guardando informacion Entrevista DatFijo " + e);
            throw new Exception("TselEntrevistaDatfijoDAO.guardarEntrevistaDatFijo> Error guardando informacion Entrevista DatFijo " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
