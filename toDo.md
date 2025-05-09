## FrontEnd

1. Menu para o usuário
    1. Ler Arquivo 
        1. Aluno
        2. Cursos
        3. Notas
            - Digite o nome do arquivo no formato "NomeDoCurso_periodo_ano"
    
    2. Escrever no Arquivo
        1. Aluno
        2. Cursos
        3. Notas
            - Digite o nome do arquivo no formato "NomeDoCurso_periodo_ano"

## Acesso

### aluno: 
``` 
    // Cria o Path
    FilePath alunoPath = new FilePath("aluno.csv", null);`

    // Cria a Lista alunos
    AlunoFileAccess alunoAccess = new AlunoFileAccess();

    // Acessa a lista
    List<Aluno> alunos = alunoAccess.loadData(alunoPath.toString());

    // Leia os arquivos
    for (Aluno aluno : alunos)
    {
        System,out.println(aluno);
    }

    // ================ Escrita
        alunoAccess.save(
             alunos, 
             alunoPath.toString(), 
             aluno -> String.format("%04d,%s", aluno.getID(), aluno.getNome()),
             "Joaquim Costa"); // Tem que ser o Output do usuário

```
### curso
```
    // Cria o Path
    FilePath cursoPath = new FilePath("cursos.csv", null);`

    // Cria a Lista curso
    CursosFileAccess cursoAccess = new CursosFileAccess();

    // Acessa a lista
    List<Curso> cursos = cursoAccess.loadData(cursoPath.toString());

    for (Curso curso : cursos)
    {
        System.out.println(curso);
    }

    // ============= Escrita
         cursoAccess.save(
              cursos,
              cursoPath.toString(),
              curso -> String.format("%s,%d,%d", curso.getNomeCurso(), curso.getPeriodo(), curso.getAno()),
              "Geometria", 1, 2006  // Output do usuário
              );                 
```

### Notas

```
String nomeArquivo;

nomeArquivo = String.format("%s.csv", inputUsuario);

FilePath NotasPath = new FilePath(nomeArquivo, "Cursos");
```
