package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.dao.MensagemEmailDao;
import br.com.guilhermevillaca.modelo.MensagemEmail;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Controller
@Path("/mensagememail/")
public class MensagemEmailController extends AbstractController implements InterfaceController<MensagemEmail> {

    @Inject
    private MensagemEmailDao dao;
    public MensagemEmailController() {
    }

    @Path("adiciona")
    @Override
    public void adiciona(MensagemEmail mensagemEmail) {
        this.dao.create(mensagemEmail);
    }

    @Override
    public void atualiza(MensagemEmail object) {
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
