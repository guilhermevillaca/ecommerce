package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.dao.CategoriaDao;
import br.com.guilhermevillaca.modelo.Categoria;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Controller
@Path("/categoria/")
public class CategoriaController extends AbstractController implements InterfaceController<Categoria> {

    @Inject
    private CategoriaDao dao;
    public CategoriaController() {
    }

    @Path("adiciona")
    @Override
    public void adiciona(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Path("atualiza")
    @Override
    public void atualiza(Categoria object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Path("remove")
    @Override
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Path("pesquisa")
    @Override
    public void pesquisa() {
        this.dao.list();
    }

    @Path("pesquisa/{id}")
    @Override
    public void pesquisa(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
