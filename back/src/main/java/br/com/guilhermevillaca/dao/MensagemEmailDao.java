package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.core.Operacao;
import br.com.guilhermevillaca.modelo.MensagemEmail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
public class MensagemEmailDao implements InterfaceDao<MensagemEmail> {

    @Inject
    private JsonResult jsonResult;
    @Override
    public void create(MensagemEmail object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO mensagemEmail(MsgEml_Remetente, MsgEml_Destinatario, MsgEml_Assunto, MsgEml_Corpo, MsgEml_DtEnvio) VALUES (?,?,?,?,?)");
            stmt.setString(1, object.getMgsEmlRemetente());
            stmt.setString(2, object.getMsgEmlDestinatario());
            stmt.setString(3, object.getMsgEmlAssunto());
            stmt.setString(4, object.getMsgEmlCorpo());
            stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
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
    public void update(MensagemEmail object) {
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
