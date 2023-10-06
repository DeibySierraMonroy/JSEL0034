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
import co.com.activos.JSEL0034.ClassAbstract.EmpleadoSimpleDAOInterface;
import co.com.activos.JSEL0034.Entidad.EmpleadoSimpleEntity;
import co.com.activos.Utilidad.OracleFactory;

/**
 * Gestor de datos accedo a datos empleado
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class EmpleadoSimpleDAO implements Serializable, EmpleadoSimpleDAOInterface {

    private static final long serialVersionUID = 1L;

    public EmpleadoSimpleDAO() {
    }

    /**
     * Retorna la informacion adicional del empleado.
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public EmpleadoSimpleEntity cargarInformacionAdicionalEmpleado(String tdcTd, Long eplNd) {
        EmpleadoSimpleEntity empleadoEntity = new EmpleadoSimpleEntity();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_INFO_EXTRA_EMPLEADO(?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);

                while (rs.next()) {
                    empleadoEntity.setTdcTd(rs.getString("TDC_TD"));
                    empleadoEntity.setEplNd(rs.getLong("EPL_ND"));
                    empleadoEntity.setEplFuma(rs.getString("EPL_FUMA"));

                    try {
                        empleadoEntity.setFuma(rs.getString("EPL_FUMA").equals("S"));
                    } catch (Exception e) {
                        empleadoEntity.setFuma(false);
                    }

                    empleadoEntity.setEplTallaPantalon(rs.getString("EPL_TALLA_PANTALON"));
                    empleadoEntity.setEplTallaCamisa(rs.getString("EPL_TALLA_CAMISA"));
                    empleadoEntity.setEplTallaZapatos(rs.getString("EPL_TALLA_ZAPATOS"));
                    empleadoEntity.setEplToma(rs.getString("EPL_TOMA"));
                    empleadoEntity.setEplUsaLentes(rs.getString("USA_LENTES"));

                    try {
                        empleadoEntity.setUsalentes(rs.getString("USA_LENTES").equals("S"));
                    } catch (Exception e) {
                        empleadoEntity.setUsalentes(false);
                    }

                    empleadoEntity.setEstatura(rs.getInt("ESTATURA"));
                    empleadoEntity.setPeso(rs.getInt("PESO"));
                    empleadoEntity.setFechaNacimientoEmpleado(rs.getDate("EPL_FECNACIM"));
                }
            } else {
                System.out.println("EmpleadoSimpleDAO.cargarInformacionAdicionalEmpleado: " + cs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EmpleadoSimpleDAO.cargarInformacionAdicionalEmpleado: Error cargando informacion adicional empleado, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empleadoEntity;
    }

    /**
     * Procesa la informacion adicional del empleado en la base de datos
     *
     * @param empleadoInformacionAdicional
     * @throws Exception
     */
    public void guardarInformacionAdicionalEmpleado(EmpleadoSimpleEntity empleadoInformacionAdicional) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_ACTUALIZAR_INFO_EXTA_EPL(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, empleadoInformacionAdicional.getTdcTd());
            cs.setLong(2, empleadoInformacionAdicional.getEplNd());
            cs.setString(3, empleadoInformacionAdicional.isUsalentes() ? "S" : "N");
            cs.setString(4, empleadoInformacionAdicional.isFuma() ? "S" : "N");
            cs.setString(5, empleadoInformacionAdicional.getEplToma());
            cs.setString(6, empleadoInformacionAdicional.getEplTallaCamisa());
            cs.setString(7, empleadoInformacionAdicional.getEplTallaPantalon());
            cs.setString(8, empleadoInformacionAdicional.getEplTallaZapatos());
            cs.setInt(9, empleadoInformacionAdicional.getEstatura());
            cs.setInt(10, empleadoInformacionAdicional.getPeso());
            cs.registerOutParameter(11, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(11) == null)) {
                throw new Exception(cs.getString(11));
            }
        } catch (Exception e) {
            System.out.println("EmpleadoSimpleDAO.guardarInformacionAdicionalEmpleado: Error guardando informacion adicional empleado, causado por " + e);
            throw new Exception("Error guardando informacion adicional empleado, causado por " + e);
        } finally {
            conexion.close();
        }
    }

    /**
     * Retorna la lista de talla disponibles para el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @param tipoLista
     * @param aplicaGenero
     * @return
     */
    public List<SelectItem> cargarListaTallasEmpleado(String tdcTd, Long eplNd, String tipoLista, String aplicaGenero) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ call SEL.QB_APLICATION_JSEL0034.PL_CARGAR_LISTA_TALLA(?,?,?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.setString(3, tipoLista);
            cs.setString(4, aplicaGenero);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.registerOutParameter(6, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(5) == null) {
                ResultSet rs = (ResultSet) cs.getObject(6);
                while (rs.next()) {
                    lista.add(new SelectItem(rs.getString("VALUE"), rs.getString("LABEL")));
                }
            } else {
                System.out.println("EmpleadoSimpleDAO.cargarListaTallasEmpleado: " + cs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("EmpleadoSimpleDAO.cargarListaTallasEmpleado: Error cargando lista de tallas empleado, causado por " + e);
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
