package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme.villaca
 */
public class ProdutoDao implements InterfaceDao<Produto> {

    @Override
    public void create(Produto object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produto(Prd_Descricao, Prd_Titulo, Ctg_Codigo, Prd_Valor) VALUES (?,?,?,?)");
            stmt.setString(0, object.getPrdDescricao());
            stmt.setString(1, object.getPrdTitulo());
            stmt.setInt(2, object.getCategoria().getCtgCodigo());
            stmt.setDouble(3, object.getPrdValor());
            stmt.executeUpdate();
            //result json com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM produto where Prd_Codigo=?");
            stmt.setInt(0, id);
            stmt.executeUpdate();
            //result json com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void update(Produto object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE produto set Prd_Descricao=?,Prd_Titulo=?,Ctg_Codigo=?Prd_Valor=? where Prd_Codigo=?");
            stmt.setString(0, object.getPrdDescricao());
            stmt.setString(1, object.getPrdTitulo());
            stmt.setInt(2, object.getCategoria().getCtgCodigo());
            stmt.setDouble(3, object.getPrdValor());
            stmt.setInt(4, object.getPrdCodigo());
            stmt.executeUpdate();
            //result json com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void list() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            stmt.executeUpdate();
            //result json com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void getById(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE Prd_Codigo=?");
            stmt.setInt(0, id);
            stmt.executeUpdate();
            //result json com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
