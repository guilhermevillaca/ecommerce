package br.com.guilhermevillaca.core;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
public interface InterfaceController<T> {

    public void adiciona(T object);

    public void atualiza(T object);

    public void remove(Integer id);

    public void pesquisa();

    public void pesquisa(Integer id);
}
