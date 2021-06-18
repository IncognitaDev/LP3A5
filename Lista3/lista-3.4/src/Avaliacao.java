public class Avaliacao {
    private String disciplina;
    private String  aluno;
    private int nota;

    public Avaliacao(String disciplina, String aluno, int nota) {
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getAluno() {
        return aluno;
    }

    public int getNota() {
        return nota;
    }
}
