package co.com.activos.JSEL0034.Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.jdbc.OracleTypes;
import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.JSEL0034.ClassAbstract.TselViviendaDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselVivienda;

/**
 * Gestor de datos entidad TSEL_VIVIENDA.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TselViviendaDAO implements Serializable, TselViviendaDAOInterface {

    private static final long serialVersionUID = 1L;

    /**
     * Carga la informacion de vivienda del empleado.
     *
     * @param tdcTdEpl
     * @param eplNd
     * @return
     */
    public TselVivienda cargarInformacionVivienda(String tdcTdEpl, Long eplNd) {
        TselVivienda vivienda = new TselVivienda(tdcTdEpl, eplNd);
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_INFO_VIVIENDA_EMPL(?,?,?,?)}");
            cs.setString(1, tdcTdEpl);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);

                while (rs.next()) {
                    vivienda.setTdcTdEpl(rs.getString("TDC_TD_EPL"));
                    vivienda.setEplNd(rs.getLong("EPL_ND"));
                    vivienda.setVivCodigo(rs.getLong("VIV_CODIGO"));
                    vivienda.setVivSecuencia(rs.getLong("VIV_SECUENCIA"));
                    vivienda.setTipCodigo(rs.getLong("TIP_CODIGO"));
                    vivienda.setTiempoVivienda(rs.getLong("TIEMPO_VIVIENDA"));
                    vivienda.setFechaInicial(rs.getDate("FECHA_INICIAL"));
                }
            } else {
                System.out.println("TselViviendaDAO>cargarInformacionVivienda. " + cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("TselViviendaDAO>cargarInformacionVivienda. error cargando informacion vivienda empleado " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vivienda;
    }

    /**
     * Guardado de la informacion de vivienda del empleado.
     *
     * @param viviendaEmpleado
     * @throws Exception
     */
    public void guardarInformacionViviendaEmpleado(TselVivienda viviendaEmpleado) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_GUARDAR_INFO_VIVIENDA_EMPL(?,?,?,?,?,?,?,?)}");
            cs.setString(1, viviendaEmpleado.getTdcTdEpl());
            if (viviendaEmpleado.getEplNd() != null) {
                cs.setLong(2, viviendaEmpleado.getEplNd());
            } else {
                cs.setString(2, null);
            }
            if(viviendaEmpleado.getVivCodigo() != null){
                cs.setLong(3, viviendaEmpleado.getVivCodigo());
            } else {
                cs.setString(3, null);
            }
            if(viviendaEmpleado.getVivSecuencia() != null){
                cs.setLong(4, viviendaEmpleado.getVivSecuencia());
            } else {
                cs.setString(4, null);
            }
            if(viviendaEmpleado.getTipCodigo() != null){
                cs.setLong(5, viviendaEmpleado.getTipCodigo());
            } else {
                cs.setString(5, null);
            }

            try {
                cs.setLong(6, viviendaEmpleado.getTiempoVivienda());
            } catch (Exception e) {
                cs.setObject(6, null);
            }

            try {
                cs.setDate(7, new java.sql.Date(viviendaEmpleado.getFechaInicial().getTime()));
            } catch (Exception e) {
                cs.setObject(7, null);
            }

            cs.registerOutParameter(8, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(8) == null)) {
                System.out.println("TselViviendaDAO>guardarInformacionViviendaEmpleado. Error guardando informacion vivienda empleado " + cs.getString(8));
            }
        } catch (Exception e) {
            throw new Exception("TselViviendaDAO>guardarInformacionViviendaEmpleado. error guardando informacion vivienda empleado " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retorna la lista de opciones para las llaves foraneas TSEL_VIVIENDA.
     *
     * @param tipo
     * @return
     */
    public List<SelectItem> cargarListaTipoLlaveVivienda(String tipo) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_LISTAS_VIVIENDA(?,?,?)}");
            cs.setString(1, tipo);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(3);
                while (rs.next()) {
                    lista.add(new SelectItem(rs.getLong("VALUE"), rs.getString("LABEL")));
                }
            } else {
                System.out.println("TselViviendaDAO>cargarListaTipoLlaveVivienda: " + cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("TselViviendaDAO>cargarListaTipoLlaveVivienda. Error cargando lista tipos: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
