import dataAccess.*;
import dataClasses.*;
import java.util.List;
import util.Utils;

public class teste 
{
    public static void main(String[] args) throws Exception 
    {
        /*
         * 1º etapa:
         * Crie um objeto do tipo FilePath
         */
         


        Utils.clearScreen();

        FilePath alunoPath = new FilePath("aluno.csv", null);

        // AlunoFileAccess alunoAccess = new AlunoFileAccess();

        // List<Aluno> alunos = alunoAccess.loadData(alunoPath.toString());


        // alunoAccess.save(
        //     alunos, 
        //     alunoPath.toString(), 
        //     aluno -> String.format("%04d,%s", aluno.getID(), aluno.getNome()),
        //     "Joaquim Costa");

        //  FilePath cursoPath = new FilePath("cursos.csv", null);

        //  CursosFileAccess cursoAccess = new CursosFileAccess();

        //  List<Curso> cursos = cursoAccess.loadData(cursoPath.toString());

         
         
        //  cursoAccess.save(
        //      cursos,
        //      cursoPath.toString(),
        //      curso -> String.format("%s,%d,%d", curso.getNomeCurso(), curso.getPeriodo(), curso.getAno()),
        //      "Geometria", 1, 2006
        //      );
             
        //      for (Curso curso : cursos)
        //      {
        //          System.out.println(curso);
        //      }


        
        FilePath PathNotaGeometria = new FilePath("Geometria_1_2006.csv", "Cursos");

        NotasCursosAccess notasGeometria = new NotasCursosAccess();

        List<NotasCursos> geometriaAccess = notasGeometria.loadData(PathNotaGeometria.toString());

        for (NotasCursos aluno : geometriaAccess)
        {
            System.out.println(aluno);
        }

        notasGeometria.save(
            geometriaAccess, 
            PathNotaGeometria.toString(),
            aluno -> String.format("%d,%.2f,%.2f,%.2f,%.2f",
                aluno.getID(),
                aluno.getNP1(),
                aluno.getNP2(),
                aluno.getReposicao(),
                aluno.getExame()),
            9, 5.26, 6.2, 6.3, 7.5
        );

        System.out.printf("\n===============\n");

        for (NotasCursos aluno : geometriaAccess)
        {
        System.out.println(aluno);
        }

        
    }
}