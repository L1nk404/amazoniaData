package dataAccess;

import dataClasses.*;
import java.util.List;
import java.util.Scanner;
import util.Utils;

public class NotasCursosAccess extends FileAccess<NotasCursos>
{

    @Override
    protected NotasCursos parse(String[] dataArray) 
    {
        int ID = Integer.parseInt(dataArray[0]);
        double NP1 = Double.parseDouble(dataArray[1]);
        double NP2 = Double.parseDouble(dataArray[2]);
        double reposicao = Double.parseDouble(dataArray[3]);
        double exame = Double.parseDouble(dataArray[4]);
        
        return new NotasCursos(ID, NP1, NP2, reposicao, exame);
    }

    @Override
    protected NotasCursos createObjToSave(Object... args) 
    {
        return new NotasCursos(
            (int) args[0],
            (double) args[1], 
            (double) args[2], 
            (double) args[3], 
            (double) args[4]);
    }
    
    public void saveDataHandle
    (
        FilePath notasPath,
        NotasCursosAccess notas,
        List<NotasCursos> DataList
    )
    {
        Scanner scanner = new Scanner(System.in);


        String ID_input;
        String NP1_input;
        String NP2_input;
        String reposicao_input;
        String exame_input;

        int ID = 0;
        double NP1 = 0;
        double NP2 = 0;
        double reposicao = 0;
        double exame = 0;
           

        // Limpa tela
        Utils.clearScreen();

        // Input de dados =================
        Utils.boldPrint("Inserir Notas Alunos");

        // Input 
        System.out.printf("ID: ");
        ID_input = scanner.nextLine();
        if (ID_input.matches("\\d+"))
        {
            ID = Integer.parseInt(ID_input);
        }
        else
        {
            System.out.printf("Input Inválido!\nPressione ENTER para continuar.");
            scanner.nextLine();

            // Recursividade
            saveDataHandle(notasPath, notas, DataList);
        }
        
        // NP1 =================================
        System.out.printf("NP1: ");
        NP1_input = scanner.nextLine();
        if (NP1_input.matches("\\d{1,2}.\\d{1,2}"))
        {
            NP1 = Double.parseDouble(NP1_input);
            if (NP1 > 10)
            {
                System.out.printf("valores devem ser menores ou iguais 10.00");
                
                // Recursividade
                saveDataHandle(notasPath, notas, DataList);
            }
        }
        else
        {
            System.out.printf(
                "Input Inválido! O valor deve estar no formato decimal.\nPressione ENTER para continuar.");
            scanner.nextLine();

            // Recursividade
            saveDataHandle(notasPath, notas, DataList);
        }


        // NP2 =================================
        System.out.printf("NP2: ");
        NP2_input = scanner.nextLine();
        if (NP2_input.matches("\\d{1,2}.\\d{1,2}"))
        {
            NP2 = Double.parseDouble(NP2_input);
            if (NP2 > 10)
            {
                System.out.printf("valores devem ser menores ou iguais 10.00");
                
                // Recursividade
                saveDataHandle(notasPath, notas, DataList);
            }
        }
        else
        {
            System.out.printf(
                "Input Inválido! O valor deve estar no formato decimal.\nPressione ENTER para continuar.");
            scanner.nextLine();

            // Recursividade
            saveDataHandle(notasPath, notas, DataList);
        }

        // Reposicao ===========================
        System.out.printf("Reposição: ");
        reposicao_input = scanner.nextLine();
        if (reposicao_input.matches("\\d{1,2}.\\d{1,2}"))
        {
            reposicao = Double.parseDouble(reposicao_input);
            if (reposicao > 10)
            {
                System.out.printf("valores devem ser menores ou iguais 10.00");
                
                // Recursividade
                saveDataHandle(notasPath, notas, DataList);
            }
        }
        else
        {
            System.out.printf(
                "Input Inválido! O valor deve estar no formato decimal.\nPressione ENTER para continuar.");
            scanner.nextLine();

            // Recursividade
            saveDataHandle(notasPath, notas, DataList);
        }

        // Exame ================================
        System.out.printf("Exame: ");
        exame_input = scanner.nextLine();
        if (exame_input.matches("\\d{1,2}.\\d{1,2}"))
        {
            exame = Double.parseDouble(exame_input);
            if (exame > 10)
            {
                System.out.printf("valores devem ser menores ou iguais 10.00");
                
                // Recursividade
                saveDataHandle(notasPath, notas, DataList);
            }
        }
        else
        {
            System.out.printf(
                "Input Inválido! O valor deve estar no formato decimal.\nPressione ENTER para continuar.");
            scanner.nextLine();

            // Recursividade
            saveDataHandle(notasPath, notas, DataList);
        }

        // Salvando os Dados
        notas.save(
            DataList, 
            notasPath.toString(),
            aluno -> String.format("%d,%.2f,%.2f,%.2f,%.2f",
                aluno.getID(),
                aluno.getNP1(),
                aluno.getNP2(),
                aluno.getReposicao(),
                aluno.getExame()),
            ID, NP1, NP2, reposicao, exame
        );

        // Mostrando os dados:
        Utils.clearScreen();

        System.out.printf("Valores salvos:\n");

        for (NotasCursos aluno : DataList)
        {
            System.out.println(aluno);
        }
    }


}

