package classes;

public class Venda 
{
    private String dataVenda;
    private int qtdVend;
    private Produto prodVend;
    

    public Venda(String dataVenda, int qtdVend, Produto prodVend) 
    {
        this.dataVenda = dataVenda;
        this.qtdVend = qtdVend;
        this.prodVend = prodVend;
    }


    public String getDataVenda() 
    {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) 
    {
        this.dataVenda = dataVenda;
    }


    public int getQtdVend() 
    {
        return qtdVend;
    }
    public void setQtdVend(int qtdVend) 
    {
        this.qtdVend = qtdVend;
    }


    public Produto getProdVend() 
    {
        return prodVend;
    }
    public void setProdVend(Produto prodVend) 
    {
        this.prodVend = prodVend;
    }


    @Override
    public String toString() {
        return "Data da venda: " + dataVenda + "           " + "Produto vendido: " + prodVend.getNome() + "                " + 
        "Quantidade vendida: " + qtdVend + "\n";
    }  
     
}
