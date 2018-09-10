export interface IntefaceModel<T> {
    initJSON(json: any): T;
    toJSON();
}