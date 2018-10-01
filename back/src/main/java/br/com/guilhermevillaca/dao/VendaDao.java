package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.core.Operacao;
import br.com.guilhermevillaca.modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
public class VendaDao implements InterfaceDao<Venda> {
    
    @Inject
    private JsonResult jsonResult;
    @Override
    public void create(Venda object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Venda(Vnd_ValorTotal, Usr_Codigo, FrmPgt_Codigo, Vnd_PgtoConfirmado) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, object.getVndValorTotal());
            stmt.setInt(2, object.getUsuario().getUsrCodigo());
            stmt.setInt(3, object.getFormaPagamento().getFrmPgtCodigo());
            stmt.setString(4, object.getVndPgtoConfirmado());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {   
                    object.setVndCodigo(generatedKeys.getInt(1));
                }
            }
            jsonResult.from(object, Operacao.CREATE);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void update(Venda object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
