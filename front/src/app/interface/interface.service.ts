export interface InterfaceService<T> {
    adiciona(item: T);
    atualiza(item: T);
    remove(id);
    pesquisa();    
}