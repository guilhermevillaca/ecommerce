package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.core.Operacao;
import br.com.guilhermevillaca.modelo.PssFisica;
import br.com.guilhermevillaca.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
public class UsuarioDao implements InterfaceDao<Usuario> {
    
    @Inject
    private JsonResult jsonResult;
    
    @Override
    public void create(Usuario object) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO usuario(Usr_Senha, Usr_Login, PssFsc_Codigo) VALUES (?,?,?)");
            stmt.setString(1, object.getUsrSenha());
            stmt.setString(2, object.getUsrLogin());
            stmt.setInt(3, object.getPssFisica().getPssFscCodigo());
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
    public void update(Usuario object) {
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
    
    public void getByUsuario(Usuario usuario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE Usr_Login=? and Usr_Senha=?");
            stmt.setString(1, usuario.getUsrLogin());
            stmt.setString(2, usuario.getUsrSenha());
            ResultSet rs = stmt.executeQuery();
            Usuario u = new Usuario();
            while (rs.next()) {                
                u.setUsrCodigo(rs.getInt("Usr_Codigo"));
                u.setUsrLogin(rs.getString("Usr_Login"));                                
                stmt2 = con.prepareStatement("SELECT * FROM pssFisica where PssFsc_Codigo=?");
                stmt2.setInt(1, rs.getInt("PssFsc_Codigo"));
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    PssFisica p = new PssFisica();
                    p.setPssFscCodigo(rs2.getInt("PssFsc_Codigo"));
                    p.setPssFscNome(rs2.getString("PssFsc_Nome"));
                    p.setPssFscEmail(rs2.getString("PssFsc_Email"));
                    p.setPssFscCPF(rs2.getString("PssFsc_CPF"));
                    u.setPssFisica(p);
                }                
            }
            jsonResult.clear();
            if(u.getUsrCodigo() == null){
                   jsonResult.message("usuario_invalido");
            }else{
                jsonResult.from(u);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            jsonResult.message("Houve um erro ao buscar o produto: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
