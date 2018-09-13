package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.core.Operacao;
import br.com.guilhermevillaca.modelo.Categoria;
import br.com.guilhermevillaca.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author guilherme.villaca
 */
@RequestScoped
public class ProdutoDao implements InterfaceDao<Produto> {

    @Inject
    private JsonResult jsonResult;

    @Override
    public void create(Produto object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produto(Prd_Descricao, Prd_Titulo, Ctg_Codigo, Prd_Valor) VALUES (?,?,?,?)");
            stmt.setString(1, object.getPrdDescricao());
            stmt.setString(2, object.getPrdTitulo());
            stmt.setInt(3, object.getCategoria().getCtgCodigo());
            stmt.setDouble(4, object.getPrdValor());
            stmt.executeUpdate();
            jsonResult.message("Salvo com sucesso", Operacao.CREATE);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao salvar: " + ex);
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
            jsonResult.message("Removido com sucesso", Operacao.DELETE);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao remover: " + ex);
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
            jsonResult.message("Atualizado com sucesso", Operacao.UPDATE);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void list() {
        List<Produto> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setPrdCodigo(rs.getInt("Prd_Codigo"));
                p.setPrdDescricao(rs.getString("Prd_Descricao"));
                p.setPrdTitulo(rs.getString("Prd_Titulo"));
                p.setPrdValor(rs.getDouble("Prd_Valor"));
                stmt2 = con.prepareStatement("SELECT * FROM Categoria where Ctg_Codigo=?");
                stmt2.setInt(1, rs.getInt("Ctg_Codigo"));
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    Categoria c = new Categoria();
                    c.setCtgCodigo(rs2.getInt("Ctg_Codigo"));
                    c.setCtgDescricao(rs2.getString("Ctg_Descricao"));
                    p.setCategoria(c);
                }
                lista.add(p);
            }
            jsonResult.clear();
            jsonResult.from(lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao listar os produtos: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void getById(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE Prd_Codigo=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setPrdCodigo(rs.getInt("Prd_Codigo"));
                p.setPrdDescricao(rs.getString("Prd_Descricao"));
                p.setPrdTitulo(rs.getString("Prd_Titulo"));
                p.setPrdValor(rs.getDouble("Prd_Valor"));
                stmt2 = con.prepareStatement("SELECT * FROM Categoria where Ctg_Codigo=?");
                stmt2.setInt(1, rs.getInt("Ctg_Codigo"));
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    Categoria c = new Categoria();
                    c.setCtgCodigo(rs2.getInt("Ctg_Codigo"));
                    c.setCtgDescricao(rs2.getString("Ctg_Descricao"));
                    p.setCategoria(c);
                }
                jsonResult.from(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao buscar o produto: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void getByCat(Integer id) {        
        List<Produto> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE Ctg_Codigo=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setPrdCodigo(rs.getInt("Prd_Codigo"));
                p.setPrdDescricao(rs.getString("Prd_Descricao"));
                p.setPrdTitulo(rs.getString("Prd_Titulo"));
                p.setPrdValor(rs.getDouble("Prd_Valor"));
                stmt2 = con.prepareStatement("SELECT * FROM Categoria where Ctg_Codigo=?");
                stmt2.setInt(1, rs.getInt("Ctg_Codigo"));
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    Categoria c = new Categoria();
                    c.setCtgCodigo(rs2.getInt("Ctg_Codigo"));
                    c.setCtgDescricao(rs2.getString("Ctg_Descricao"));
                    p.setCategoria(c);
                }
                lista.add(p);
            }
            jsonResult.clear();
            jsonResult.from(lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao pesquisar a categoria: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
