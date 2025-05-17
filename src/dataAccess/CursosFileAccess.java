package dataAccess;

import dataClasses.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import util.Utils;

public class CursosFileAccess extends FileAccess<Curso>
{
    @Override
    protected Curso parse(String[] dataArray) 
    {
        String nome = dataArray[0];
        int periodo = Integer.parseInt((dataArray[1]));
        int ano = Integer.parseInt(dataArray[2]);

        Curso curso = new Curso(nome, periodo, ano);

        createCursoCSV(curso);

        return curso;
    }

    /**
     * @param nome (String)
     * @param periodo (int)
     * @param  ano (int)
     */
    @Override
    protected Curso createObjToSave(Object... args) 
    {
        Curso curso = new Curso((String) args[0], (int) args[1], (int) args[2]);

        // Chama método para criar arquivo CSV caso não exista
        createCursoCSV(curso);

        return curso;
    }
    /**
     * Cria um arquivo CSV para um curso caso ele não exista.
     * 
     * <p>O método gera um nome de arquivo no formato {@code NomeCurso_Periodo_Ano.csv} e verifica
     * se o arquivo já existe no diretório específico para o sistema operacional atual.
     * Se o arquivo não existir, cria um novo arquivo vazio.</p>
     * 
     * O diretório base é definido como:
     *  - {@code data\Cursos} no Windows</li>
     *  - {@code data/Cursos} em outros sistemas</li>
     * 
     * @param curso O objeto Curso contendo:
     *              - Nome do curso (será sanitizado no nome do arquivo)
     *              - Período
     *              - Ano
     * 
     * @throws SecurityException Se ocorrer um erro de permissão ao criar o arquivo
     * 
     * @implNote Este método cria apenas o arquivo vazio, sem adicionar cabeçalhos ou conteúdo.
     *           A estrutura de diretórios será criada automaticamente se não existir.
     * 
     * @example
     * // Para um curso de Engenharia no período 1 de 2023
     * Curso curso = new Curso("Engenharia", 1, 2023);
     * createCursoCSV(curso);
     * // Cria: data/Cursos/Engenharia_1_2023.csv (em Unix)
     * // ou: data\Cursos\Engenharia_1_2023.csv (em Windows)
     */
    public void createCursoCSV(Curso curso)
    {
        String OS = Utils.osIdentifier();

        String fileName = String.format("%s_%d_%d.csv", curso.getNomeCurso(), curso.getPeriodo(), curso.getAno());
        
        // Criando Path do diretório baseado no OS
        String directoryPath = (OS == "Windows") ?
            "data\\Cursos" : "data/Cursos";
        File directory = new File(directoryPath);

        // Criando o path completo no tipo File
        File csvFile = new File(directory, fileName);

        if (!csvFile.exists()) // SE o arquivo NÃO (!) existe
        {
            try 
            {
                // Cria o arquivo se ele não existe
                csvFile.createNewFile();
            } catch (Exception e) 
            {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    public void saveDataHandle
    (
        FilePath cursoPath,
        CursosFileAccess cursoAccess,
        List<Curso> cursos 
    )
    {
        Scanner scanner = new Scanner(System.in);

        String nome;
        String periodo_input;
        String ano_input;

        int periodo = 0;
        int ano = 0;

        Utils.clearScreen();
        Utils.boldPrint("Adicionar Curso");

        System.out.printf("Nome: ");
        nome = scanner.nextLine();

        System.out.printf("Período: ");
        periodo_input = scanner.nextLine();
        if (periodo_input.matches("\\d+"))
        {
            periodo = Integer.parseInt(periodo_input);
        }
        else
        {
            System.out.printf("Formato inválido, insira apenas números inteiros");
            scanner.nextLine();
            saveDataHandle(cursoPath, cursoAccess, cursos);
        }

        System.out.printf("Ano: ");
        ano_input = scanner.nextLine();
        if (ano_input.matches("\\d{4}"))
        {
            ano = Integer.parseInt(ano_input);
        }
        else
        {
            System.out.printf("Formato inválido, insira apenas números inteiros no formato AAAA");
            scanner.nextLine();
            saveDataHandle(cursoPath, cursoAccess, cursos);
        }

        // Salvando dados
        cursoAccess.save(
            cursos,
            cursoPath.toString(),
            curso -> String.format("%s,%d,%d", 
            curso.getNomeCurso(), 
            curso.getPeriodo(), 
            curso.getAno()),
            nome, periodo, ano
            );

        System.out.printf("Curso salvo com sucesso!\n");
        scanner.nextLine();
    }
}
