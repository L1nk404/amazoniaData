package dataClasses;

public class Aluno
{
    private int ID;
    private String Nome;
    
    // Constructor
    public Aluno(int ID, String Nome) 
    {
        this.ID = ID;

        if (Nome.isEmpty())
        {
            System.out.printf("Nome não pode ser vazio!\n");
        }
        this.Nome = Nome;
    }

    @Override
    public String toString() 
    {
        // %04d formata para 4 dígitos preenchidos por 0 da direita pra esquerda
        String output = String.format("ID: %04d | Nome: %s", ID, Nome);
        return output;
    }
    
    // Getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
