export interface InterfaceModel<T> {
    initJSON(json: any): T;
    toJSON();
}