package apppilotos;

public class Aeronave 
{
    private String modelo;
    private String categoria;
    private Piloto p2;
    
    public Aeronave ()
    {

    }

    public Aeronave(Piloto p2) 
    {
        this.p2 = p2;
    }

    public Aeronave(String modelo, String categoria) 
    {
        this.modelo = modelo;
        this.categoria = categoria;
    }

    public Piloto getP2() 
    {
        return p2;
    }
    public void setP2(Piloto p2) 
    {
        this.p2 = p2;
    }

    public String getModelo() 
    {
        return modelo;
    }
    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getCategoria() 
    {
        return categoria;
    }
    public void setCategoria(String categoria) 
    {
        this.categoria = categoria;
    }
}