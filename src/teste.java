import dataAccess.*;
import dataClasses.*;
import java.util.List;
import util.Utils;

public class teste 
{
    public static void main(String[] args) throws Exception 
    {
        Utils.clearScreen();

        FilePath alunoPath = new FilePath("aluno.csv", null);

        AlunoFileAccess alunoAccess = new AlunoFileAccess();

        List<Aluno> alunos = alunoAccess.loadData(alunoPath.toString());


        alunoAccess.save(
            alunos, 
            alunoPath.toString(), 
            aluno -> String.format("%04d,%s", aluno.getID(), aluno.getNome()),
            "Joaquim Costa");

         FilePath cursoPath = new FilePath("cursos.csv", null);

         CursosFileAccess cursoAccess = new CursosFileAccess();

         List<Curso> cursos = cursoAccess.loadData(cursoPath.toString());

        for (Curso curso : cursos)
        {
            System.out.println(curso);
        }


        cursoAccess.save(
            cursos,
             cursoPath.toString(),
             curso -> String.format("%s,%d,%d", curso.getNomeCurso(), curso.getPeriodo(), curso.getAno()),
             "Geometria", 1, 2006
            );


    }
}