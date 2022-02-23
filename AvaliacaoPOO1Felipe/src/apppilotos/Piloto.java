package apppilotos;

public class Piloto extends Pessoa
{
    private String breve;
    private String matricula;
    private Aeronave av1;

    public Piloto()
    {

    }
    
    public Piloto (String nome, String cpf, String breve, String matricula)
    {
        super.setNome(nome);
        super.setCpf(cpf);
        this.setBreve(breve);
        this.setMatricula(matricula);
    }

    public Piloto pilotoAbstrato()
    {
        return this;
    }

    public String getBreve() 
    {
        return breve;
    }
    public void setBreve(String breve) 
    {
        this.breve = breve;
    }

    public String getMatricula() 
    {
        return matricula;
    }
    public void setMatricula(String matricula) 
    {
        this.matricula = matricula;
    }

    public Aeronave getAv1() 
    {
        return av1;
    }
    public void setAv1(Aeronave av1) 
    {
        this.av1 = av1;
    }
}
