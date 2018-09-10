package br.com.guilhermevillaca.modelo;

/**
 *
 * @author guilherme.villaca
 */
public class Produto {

    private Integer prdCodigo;
    private String prdDescricao;
    private String prdTitulo;
    private Double prdValor;
    private Categoria categoria;

    public Integer getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(Integer prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public String getPrdDescricao() {
        return prdDescricao;
    }

    public void setPrdDescricao(String prdDescricao) {
        this.prdDescricao = prdDescricao;
    }

    public String getPrdTitulo() {
        return prdTitulo;
    }

    public void setPrdTitulo(String prdTitulo) {
        this.prdTitulo = prdTitulo;
    }

    public Double getPrdValor() {
        return prdValor;
    }

    public void setPrdValor(Double prdValor) {
        this.prdValor = prdValor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
