package dataClasses;

public class NotasCursos extends Aluno
{
    int NP1;
    int NP2;
    int reposicao;
    int exame;
    
    public NotasCursos(int ID, String Nome, int nP1, int nP2, int reposicao, int exame) {
        super(ID, Nome);
        NP1 = nP1;
        NP2 = nP2;
        this.reposicao = reposicao;
        this.exame = exame;
    }

    // Getter and setters
    public int getNP1() {
        return NP1;
    }

    public void setNP1(int nP1) {
        NP1 = nP1;
    }

    public int getNP2() {
        return NP2;
    }

    public void setNP2(int nP2) {
        NP2 = nP2;
    }

    public int getReposicao() {
        return reposicao;
    }

    public void setReposicao(int reposicao) {
        this.reposicao = reposicao;
    }

    public int getExame() {
        return exame;
    }

    public void setExame(int exame) {
        this.exame = exame;
    }


    
}
