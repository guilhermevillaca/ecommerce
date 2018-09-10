package br.com.guilhermevillaca.core;

import br.com.caelum.vraptor.Result;
import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import br.com.caelum.vraptor.view.Results;

@RequestScoped
public class JsonResult {

    private HashMap<String, Object> map = null;

    @Inject
    private Result result;

    public JsonResult() {
        this.map = new HashMap<>();
        map.put("success", true);
    }

    public void success(Boolean success) {
        map.put("success", success);
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }
    
    public void operacao(Operacao op){
        map.put("operacao", op.name());
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }

    public void from(Object data, Operacao op) {
        map.put("operacao", op.name());        
        map.put("data", data);
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }
    
    public void from(Object data) {
        map.put("data", data);
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }

    public void message(String message, Operacao op) {
        map.put("operacao", op.name());
        map.put("message", message);
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }
    
    public void message(String message) {
        map.put("message", message);
        result.use(Results.json()).from(map, "response").recursive().serialize();
    }

    public JsonResult status(Integer status) {
        result.use(Results.http()).setStatusCode(status);
        return this;
    }
    
    public void clear(){
        map.clear();
    }

}
