package br.com.guilhermevillaca.dao;

import br.com.guilhermevillaca.core.ConnectionFactory;
import br.com.guilhermevillaca.core.InterfaceDao;
import br.com.guilhermevillaca.core.JsonResult;
import br.com.guilhermevillaca.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author guilherme.villaca
 */
public class CategoriaDao implements InterfaceDao<Categoria> {

    @Inject
    private JsonResult jsonResult;

    @Override
    public void create(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            List<Categoria> lista = new ArrayList<>();
            stmt = con.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCtgCodigo(rs.getInt("Ctg_Codigo"));
                c.setCtgDescricao(rs.getString("Ctg_Descricao"));
                lista.add(c);
            }
            jsonResult.from(lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            //result json com erro
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
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
