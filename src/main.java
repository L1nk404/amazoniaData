import dataAccess.*;
import dataClasses.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import util.Utils;

public class main 
{
    // Variaveis arquivo aluno
    FilePath alunoPath = new FilePath("aluno.csv", null);
    AlunoFileAccess alunoAccess = new AlunoFileAccess();
    List<Aluno> alunos = alunoAccess.loadData(alunoPath.toString());
    
    // Variaveis curso
    FilePath cursoPath = new FilePath("cursos.csv", null);
    CursosFileAccess cursoAccess = new CursosFileAccess();
    List<Curso> cursos = cursoAccess.loadData(cursoPath.toString());

    // Identificador OS
    String OS = Utils.osIdentifier();


    
    public static void main(String[] args) throws Exception
    {        
        while(true)
        {
            Utils.clearScreen();
            Menu();
            
            
        }
    }
    
    public static void Menu() throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        String input2;
        String input3;

        Utils.boldPrint("Bem vindo!\n");
        
        System.out.printf("[1] Aluno\n[2] Cursos\n[3] Notas\n");
        
        System.out.printf("\nDigite a opção do arquivo que deseja acessar: ");
        String input1 = scanner.nextLine();

        switch (input1) 
        {
            case "1" -> // Aluno ===================================================
            {
                input2 = subMenu("Aluno");
            }
            case "2" -> // Cursos ==================================================
            {
                input2 = subMenu("Cursos");
            }
            case "3" -> // Notas ===================================================
            {
                // Variáveis de acesso
                NotasCursosAccess notasOBJ = new NotasCursosAccess();

                FilePath notasPath;
                NotasCursosAccess notas;
                List<NotasCursos> notasAccess;

                // Limpa tela
                Utils.clearScreen();

                // Header
                Utils.boldPrint("Notas");
                Utils.boldPrint("\nArquivos:");

                // Lista arquivos 
                List<String> fileList = Utils.listFiles();

                System.out.printf("Selecione a opção do arquivo desejada: ");

                input2 = scanner.nextLine();

                // Verificando se é digito positivo usando Regex
                if (input2.matches("\\d+"))
                {
                    int index = Integer.parseInt(input2);                    
                    index --;  // subtrai 1 do input

                    // Checa se o valor está no range da lista
                    if (index < fileList.size())
                    {
                        // Inicializando variáveis
                        notasPath = new FilePath(fileList.get(index), "Cursos"); //FilePath
                        notas = new NotasCursosAccess(); // NotasCursosAccess
                        notasAccess = notas.loadData(notasPath.toString()); // List<NotasCursos>

                        Utils.clearScreen();
                        System.out.printf("[1] Ler Arquivo\n[2] Escrever no Arquivo\n");
                        System.out.printf("Insira a opção desejada: ");
                        input3 = scanner.nextLine();

                        Utils.clearScreen();
                        switch (input3) 
                        {
                            case "1" ->
                            {
                                for (NotasCursos aluno: notasAccess)
                                {
                                    System.out.println(aluno);
                                }
                                break;
                            }
                            case "2" ->
                            {
                                notasOBJ.saveDataHandle(notasPath, notas, notasAccess);
                                break;
                            }
                            default ->
                            {
                                System.out.printf("Opção inválida! Pressione ENTER para continuar");
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                    scanner.nextLine();
                }

            }
            default -> {
                Utils.clearScreen();
                System.out.printf("Opção inválida, digite apenas opção [1],[2] ou [3]!\nDigite Enter para continuar!\n");

                // Espera pelo Enter
                scanner.nextLine();
            }
        }
    }

    public static String subMenu(String Title)
    {
        Scanner scanner = new Scanner(System.in);


        Utils.clearScreen();

        System.out.printf("%s%s%s\n","\033[1m", Title, "\033[0m");

        System.out.printf("[1] Ler Arquivo\n");
        System.out.printf("[2] Escrever no Arquivo\n");
        
        System.out.printf("\nDigite a opção desejada: ");
        String input1 = scanner.nextLine();

        switch (input1) 
        {
            case "1":  // Ler
                return input1;
            case "2": // Escrever
                return input1;
            default:

                Utils.clearScreen();
                System.out.printf("Opção inválida, digite apenas opção [1] ou [2]!\nDigite Enter para continuar!\n");

                // Espera pelo Enter
                scanner.nextLine();

                return subMenu(Title);        
        }        
    }




    public void acessarAlunos()
    {

    }

    public void criarCurso()
    {

    }
}
