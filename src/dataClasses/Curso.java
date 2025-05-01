package dataClasses;

public class Curso 
{
    private String NomeCurso;
    private int Periodo;
    private int ano;
    
    // Constructor
    public Curso(String nomeCurso, int periodo, int ano) 
    {
        this.NomeCurso = nomeCurso;
        this.Periodo = periodo;
        this.ano = ano;
    }

    @Override
    public String toString() 
    {
        String output = String.format("Curso: %10s | Período: %1d | Ano: %4d",
        NomeCurso, Periodo, ano);
        
        return  output;
    }

    
    

    // Getter and Setters
    public String getNomeCurso() {
        return NomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }
    public int getPeriodo() {
        return Periodo;
    }
    public void setPeriodo(int periodo) {
        Periodo = periodo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    
}
