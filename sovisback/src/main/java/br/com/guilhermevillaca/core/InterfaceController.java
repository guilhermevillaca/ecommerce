/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
