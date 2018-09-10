package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Controller;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.modelo.MensagemEmail;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Controller
public class MensagemEmailController extends AbstractController implements InterfaceController<MensagemEmail> {

    public MensagemEmailController() {
    }

    @Override
    public void adiciona(MensagemEmail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
