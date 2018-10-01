package br.com.guilhermevillaca.core;

/**
 *
 * @author Guilherme Villaca <guilherme.villaca>
 */
public interface InterfaceDao<T> {

    public void create(T object);

    public void delete(Integer id);

    public void update(T object);

    public void list();

    public void getById(Integer id);
}
