package co.com.activos.JSEL0034.Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.JSEL0034.ClassAbstract.TselExpandoEmpleadoDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselExpandoEmpleadoEntity;

/**
 * Controlador acceso a datos modelo de ExpandoEmpleado
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TselExpandoEmpleadoDAO implements Serializable, TselExpandoEmpleadoDAOInterface {

    private static final long serialVersionUID = 1L;

    /**
     * Retorna el valor llave del ExpandoValue
     *
     * @param nombreConstante
     * @return
     */
    public Long cargarConstanteExpando(String nombreConstante) {
        long valorConstante = 0;
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{?= call par.fb_constante_num(?,sysdate,null,null,null,null,null,null)}");
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.setString(2, nombreConstante);
            cs.execute();
            valorConstante = cs.getLong(1);
        } catch (Exception e) {
            System.out.println("Error cargando constante Expando value, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valorConstante;
    }

    /**
     * Retorna la estructura de datos ExpandoEmpleado asociado al Tipo (HOBBY,
     * DEPORTES ......)
     *
     * @param tdcTd
     * @param eplNd
     * @param teiId
     * @return
     */
    public List<TselExpandoEmpleadoEntity> cargarEstrucutraExpandoEmpleado(String tdcTd, Long eplNd, Long teiId) {
        List<TselExpandoEmpleadoEntity> estructura = new ArrayList<TselExpandoEmpleadoEntity>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_EST_EXPANDO_EMPLEADO(?,?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.setLong(3, teiId);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(5) == null) {
                ResultSet rs = (ResultSet) cs.getObject(5);
                TselExpandoEmpleadoEntity tmp;
                while (rs.next()) {
                    tmp = new TselExpandoEmpleadoEntity();
                    tmp.setAudFecha(rs.getDate("AUD_FECHA"));
                    tmp.setAudUsuario(rs.getString("AUD_USUARIO"));
                    tmp.setEplNd(rs.getLong("EPL_ND"));
                    tmp.setTdcTdEpl(rs.getString("TDC_TD_EPL"));
                    tmp.setTeeId(rs.getLong("TEE_ID"));
                    tmp.setTeeOtroValor(rs.getString("TEE_OTRO_VALOR"));
                    tmp.setTevId(rs.getLong("TEV_ID"));
                    tmp.setTevValor(rs.getString("TEV_VALOR"));
                    estructura.add(tmp);
                }
            } else {
                System.out.println(cs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error cargando estructura ExpandoValue de Empleado causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estructura;
    }

    /**
     * Retorna el filtrado de la lista de opciones ExpandoValue
     *
     * @param tedId
     * @param filtro
     * @return
     */
    public List<String> cargarFiltroExpandoValue(Long tedId, String filtro) {
        List<String> listaFiltro = new ArrayList<String>();
        Connection conexion = OracleFactory.getConexion();

        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_OPCIONES_EXPANDO(?,?,?,?)}");
            cs.setString(1, filtro);
            cs.setLong(2, tedId);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);
                while (rs.next()) {
                    listaFiltro.add(rs.getString(1));
                }
            } else {
                System.out.println(cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error cargando cargarFiltroExpandoValue, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaFiltro;
    }

    /**
     * Asociar Expando Value al Empleado
     *
     * @param tdcTd
     * @param eplNd
     * @param teiId
     * @param valor
     * @throws Exception
     */
    public void asociarExpandoValueEmpleado(String tdcTd, Long eplNd, Long teiId, String valor) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_ASOCIAR_EXPANDO_VALUE(?,?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.setLong(3, teiId);
            cs.setString(4, valor);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(5) == null)) {
                throw new Exception(cs.getString(5));
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            conexion.close();
        }
    }

    /**
     * Eliminar asociacion del ExpandoValue con empleado.
     *
     * @param teeId
     * @throws Exception
     */
    public void eliminarExpandoValueEmpleado(Long teeId) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_DESVINCULAR_EXPANDO_VALUE(?,?)}");
            cs.setLong(1, teeId);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(2) == null)) {
                throw new Exception(cs.getString(2));
            }
        } catch (Exception e) {
            throw new Exception("Error eliminando expando value, causado por " + e);
        } finally {
            conexion.close();
        }
    }
}
