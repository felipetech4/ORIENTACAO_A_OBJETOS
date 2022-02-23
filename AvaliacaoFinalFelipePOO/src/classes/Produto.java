package classes;

public class Produto 
{   
    private String cod, nome;
    private double valor;
    private int estoque;

    
    public Produto() 
    {

    }


    public Produto(String n, String c, double v, int e) 
    {
        this.nome = n;
        this.cod = c;
        this.valor = v;
        this.estoque = e;
    }


    public String getCod() 
    {
        return cod;
    }
    public void setCod(String cod) 
    {
        this.cod = cod;
    }


    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }


    public double getValor() 
    {
        return valor;
    }
    public void setValor(double valor) 
    {
        this.valor = valor;
    }


    public int getEstoque() 
    {
        return estoque;
    }
    public void setEstoque(int estoque) 
    {
        this.estoque = estoque;
    }


    public void diminuirQuant (int diminuirQuant)
    {
        estoque = estoque - diminuirQuant;
    }

}
