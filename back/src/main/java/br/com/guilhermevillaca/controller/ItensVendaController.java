package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.dao.ItensVendaDao;
import br.com.guilhermevillaca.modelo.ItensVenda;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Controller
@Path("/itensvenda/")
public class ItensVendaController extends AbstractController implements InterfaceController<ItensVenda> {

    @Inject
    private ItensVendaDao dao;
    public ItensVendaController() {
    }

    @Override
    @Path("adiciona")
    public void adiciona(ItensVenda itensVenda) {        
        this.dao.create(itensVenda);
    }

    @Override
    public void atualiza(ItensVenda object) {
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
