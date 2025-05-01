package dataAccess;

import dataClasses.*;

public class CursosFileAccess extends FileAccess<Curso>
{
    FilePath cursoPath = new FilePath("cursos.csv", null);

    @Override
    protected Curso parse(String[] dataArray) 
    {
        String nome = dataArray[0];
        int periodo = Integer.parseInt((dataArray[1]));
        int ano = Integer.parseInt(dataArray[2]);

        return new Curso(nome, periodo, ano);
    }

    // public final void save(List<Curso> List, String nome, int periodo, int ano)
    // {
    //     List.add(new Curso(nome, periodo, ano));
        
    //     FileAccess.saveData(List, cursoPath.toString(),
    //     curso -> String.format("%s,%d,%d",
    //      curso.getNomeCurso(), curso.getPeriodo(), curso.getAno()));
    // }

    /**
     * @param nome (String)
     * @param periodo (int)
     * @param  ano (int)
     */
    @Override
    protected Curso createObjToSave(Object... args) 
    {
        // nome (String), periodo (int), ano (int)
        return new Curso((String) args[0], (int) args[1], (int) args[2]);
    }    
}
