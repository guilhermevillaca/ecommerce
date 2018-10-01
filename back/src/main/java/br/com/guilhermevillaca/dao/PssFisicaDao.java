package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.core.Operacao;
import br.com.guilhermevillaca.modelo.PssFisica;
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
 * @author guilherme.villaca
 */
public class PssFisicaDao implements InterfaceDao<PssFisica> {

    @Inject
    private JsonResult jsonResult;

    @Override
    public void create(PssFisica object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = con.prepareStatement("INSERT INTO pssFisica(PssFsc_Nome, PssFsc_CPF, PssFsc_Email) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);            
            stmt.setString(1, object.getPssFscNome());
            stmt.setString(2, object.getPssFscCPF());
            stmt.setString(3, object.getPssFscEmail());
            stmt.executeUpdate();
            //criar usuario ao mesmo tempo da pessoa fisica, poderia ser feito no dao usuario.            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {                    
                    stmt2 = con.prepareStatement("INSERT INTO usuario(Usr_Senha, Usr_Login, PssFsc_Codigo) VALUES (?,?,?)");
                    stmt2.setString(1, "sovis");
                    stmt2.setString(2, object.getPssFscEmail());
                    stmt2.setInt(3, generatedKeys.getInt(1));
                    stmt2.executeUpdate();
                } else {
                    jsonResult.message("Houve um erro ao criar o usuário");
                }
            }
            jsonResult.clear();
            jsonResult.message("Salvo com sucesso", Operacao.CREATE);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.clear();
            jsonResult.message("Houve um erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void update(PssFisica object) {
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
