package br.com.guilhermevillaca.controller;

import br.com.caelum.vraptor.Path;
import br.com.guilhermevillaca.core.AbstractController;
import br.com.guilhermevillaca.core.InterfaceController;
import br.com.guilhermevillaca.dao.ProdutoDao;
import br.com.guilhermevillaca.modelo.Produto;
import javax.inject.Inject;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
@Path("/produto/")
public class ProdutoController extends AbstractController implements InterfaceController<Produto> {

    @Inject
    private ProdutoDao dao;

    @Path("adiciona")
    @Override
    public void adiciona(Produto produto) {
        this.dao.create(produto);
    }

    @Path("atualiza")
    @Override
    public void atualiza(Produto produto) {
        this.dao.update(produto);
    }

    @Path("remove")
    @Override
    public void remove(Integer prdCodigo) {
        this.dao.delete(prdCodigo);
    }
    
    @Path("pesquisa")
    @Override
    public void pesquisa(){
        this.dao.list();
    }
    
    @Path("pesquisa/{id}")
    @Override
    public void pesquisa(Integer id){
        this.dao.getById(id);
    }

}
