import dataAccess.*;
import dataClasses.Aluno;
import java.util.List;
import util.Utils;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Utils.clearScreen();

        FilePath alunoPath = new FilePath("aluno.csv", null);

        AlunoFileAccess alunoAccess = new AlunoFileAccess();

        List<Aluno> alunos = alunoAccess.loadData("data/aluno.csv");

        for (Aluno aluno : alunos)
        {
            System.out.println(aluno);
        }        
    }
}