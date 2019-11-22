package com.clientes.daoImpl;

import com.clientes.bean.ClienteBean;
import com.clientes.dao.ClienteDAO;
import java.sql.*;
import java.util.List;
import com.clientes.util.UtilSql;
import org.apache.log4j.Logger;

public class ClienteDAOImpl implements ClienteDAO {

    private static Logger logger = Logger.getLogger(ClienteDAOImpl.class.getName());

    private UtilSql con;
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private CallableStatement cs;
    private String sql;
    private int flgOperacion = 0;

    @Override
    public int insertarCliente(Cliente cliente) {
        logger.info("insertar");

        sql = "insert into Cliente(id,ruc,razonSocial,direcion,telefono)" + "values(?,?,?,?,?)";

        System.out.println(sql + " consulta");

        try {
            con = new UtilSql();
            cn = con.getConnection();
            cn.setAutoCommit(false);

            ps = cn.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2,cliente.getRuc());
            ps.setString(3,cliente.getRazonSocial());
            ps.setString(4,cliente.getDireccion());
            ps.setString(4,cliente.getTelefono());

            flgOperacion = ps.executeUpdate();

            if (flgOperacion > 0){
                cn.commit();
                System.out.println(sql + " commit!!");
            }else{
                cn.rollback();
                System.out.printf(sql + "rollback!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return  flgOperacion;
    }

    @Override
    public List<Cliente> BuscarCliente(String razonSocial) {
        return null;
    }

    @Override
    public Cliente ObtenerPorId(int id) {
        return null;
    }

    @Override
    public int actualizar(Cliente cliente) {
        return 0;
    }

    @Override
    public int eliminar(int id) {
        return 0;
    }
}
