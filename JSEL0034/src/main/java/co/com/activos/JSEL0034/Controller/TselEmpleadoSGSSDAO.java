package co.com.activos.JSEL0034.Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.JSEL0034.ClassAbstract.TselEmpleadoSGSSDAOInterface;
import co.com.activos.JSEL0034.Entidad.EmpresaEntity;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoSGSSSimpleEntity;

/**
 * Controlador de datos TselEmpleadoSGSS
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TselEmpleadoSGSSDAO implements TselEmpleadoSGSSDAOInterface {

    public TselEmpleadoSGSSDAO() {
    }

    /**
     * Retorna la informacion SGSS del empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public TselEmpleadoSGSSSimpleEntity cargarInformacionSGSSEmpleado(String tdcTd, Long eplNd) {
        TselEmpleadoSGSSSimpleEntity informacion = new TselEmpleadoSGSSSimpleEntity(tdcTd, eplNd);
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_SGSS_EMPLEADO(?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);

                while (rs.next()) {
                    informacion.setTdcTd(rs.getString("TDC_TD_EPL"));
                    informacion.setEplNd(rs.getLong("EPL_ND"));
                    informacion.setTipoBeneficiario(rs.getInt("ESG_SUBTIPO_COTIZANTE"));
                    informacion.setEps(rs.getString("TDC_TD_EPS") + "<>" + rs.getLong("EMP_ND_EPS"));
                    informacion.setAfp(rs.getString("TDC_TD_AFP") + "<>" + rs.getLong("EMP_ND_AFP"));
                }
            } else {
                System.out.println("TselEmpleadoSGSSDAO.cargarInformacionSGSSEmpleado> " + cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("TselEmpleadoSGSSDAO.cargarInformacionSGSSEmpleado> Error cargando informacion SGSS Empleado, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return informacion;
    }

    /**
     * Procesa el guardado de la informacion SGSS del empleado
     *
     * @param infoSGSS
     * @throws Exception
     */
    public void guardarInformacionSGSSEmpleado(TselEmpleadoSGSSSimpleEntity infoSGSS) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_GUARDAR_SGSS_EMPLEADO(?,?,?,?,?,?,?,?)}");
            cs.setString(1, infoSGSS.getTdcTd());
            cs.setLong(2, infoSGSS.getEplNd());
            cs.setInt(3, infoSGSS.getTipoBeneficiario());

            if (!infoSGSS.getEps().equals("NA<>0")) {
                cs.setString(4, infoSGSS.getEps().split("<>")[0]);
                cs.setLong(5, new Long(infoSGSS.getEps().split("<>")[1]));
            } else {
                cs.setObject(4, null);
                cs.setObject(5, null);
            }

            if (!infoSGSS.getAfp().equals("NA<>0")) {
                cs.setString(6, infoSGSS.getAfp().split("<>")[0]);
                cs.setLong(7, new Long(infoSGSS.getAfp().split("<>")[1]));
            } else {
                cs.setObject(6, null);
                cs.setObject(7, null);
            }
            cs.registerOutParameter(8, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(8) == null)) {
                throw new Exception("TselEmpleadoSGSSDAO.guardarInformacionSGSSEmpleado> " + cs.getString(8));
            }
        } catch (Exception e) {
            throw new Exception("TselEmpleadoSGSSDAO.guardarInformacionSGSSEmpleado> Error guardando informacion SGSS, causado por  " + e);
        } finally {
            conexion.close();
        }
    }

    /**
     * Retorna la lista de empresas por Tipo (EPS y AFP)
     *
     * @param tipo
     * @return
     */
    public List<EmpresaEntity> cargarEmpresasSGSS(String tipo) {
        List<EmpresaEntity> empresas = new ArrayList<EmpresaEntity>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_LISTA_EMPRESAS(?,?,?)}");
            cs.setString(1, tipo);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(2) == null) {
                ResultSet rs = (ResultSet) cs.getObject(3);
                while (rs.next()) {
                    empresas.add(new EmpresaEntity(rs.getString("TDC_TD"), rs.getLong("EMP_ND"), rs.getString("EMP_NOMBRE")));
                }
            } else {
                System.out.println("TselEmpleadoSGSSDAO.cargarEmpresasSGSS> " + cs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("TselEmpleadoSGSSDAO.cargarEmpresasSGSS> Error cargando lista de empresa by Tipo, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empresas;
    }
}
