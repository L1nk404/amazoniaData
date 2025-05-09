package dataClasses;

public class NotasCursos
{
    int ID;
    double NP1;
    double NP2;
    double reposicao;
    double exame;
    
    // Constructor
    public NotasCursos(int ID, double nP1, double nP2, double reposicao, double exame) 
    {
        this.ID = ID;
        NP1 = nP1;
        NP2 = nP2;
        this.reposicao = reposicao;
        this.exame = exame;
    }

    @Override
    public String toString() 
    {
        String output = String.format("ID: %04d | NP1: %.2f | NP2: %.2f | Reposição: %.2f | Exame: %.2f  ",
         ID,
         NP1,
         NP2,
         reposicao,
         exame);

        return output;
    }

    // Getter and setters
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public double getNP1() {
        return NP1;
    }

    public void setNP1(double nP1) {
        NP1 = nP1;
    }

    public double getNP2() {
        return NP2;
    }

    public void setNP2(double nP2) {
        NP2 = nP2;
    }

    public double getReposicao() {
        return reposicao;
    }

    public void setReposicao(double reposicao) {
        this.reposicao = reposicao;
    }

    public double getExame() {
        return exame;
    }

    public void setExame(double exame) {
        this.exame = exame;
    }
}
