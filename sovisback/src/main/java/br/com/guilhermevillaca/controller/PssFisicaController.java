package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.dao.PssFisicaDao;
import br.com.guilhermevillaca.dao.UsuarioDao;
import br.com.guilhermevillaca.modelo.PssFisica;
import br.com.guilhermevillaca.modelo.Usuario;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Controller
@Path("/pssFisica/")
public class PssFisicaController extends AbstractController implements InterfaceController<PssFisica> {

    @Inject
    private PssFisicaDao dao;    
    
    public PssFisicaController() {
    }

    @Path("adiciona")
    @Override
    public void adiciona(PssFisica pssFisica) {
        this.dao.create(pssFisica);        
    }

    @Override
    public void atualiza(PssFisica object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisa(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
