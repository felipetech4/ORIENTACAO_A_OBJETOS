package apppilotos;

public abstract class Pessoa 
{
    private String nome;
    private String cpf;

    public Pessoa()
    {

    }
    
    public Pessoa(String nome, String cpf) 
    {
        this.setNome(nome);
        this.setCpf(cpf);
    }

    public abstract Piloto pilotoAbstrato();

    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getCpf() 
    {
        return cpf;
    }
    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }
}
