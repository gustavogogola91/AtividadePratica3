package model;

public abstract class Funcionario {

    private String nome;
    private int matricula;
    protected double horasTrab;
    protected double valorH;

    public Funcionario() {
    }

    public Funcionario(String nome, int matricula, double horasTrab, double valorH) {
        this.nome = nome;
        this.matricula = matricula;
        this.horasTrab = horasTrab;
        this.valorH = valorH;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(double horasTrab) {
        this.horasTrab = horasTrab;
    }

    public double getValorH() {
        return valorH;
    }

    public void setValorH(double valorH) {
        this.valorH = valorH;
    }

    public abstract void calcularSalario(double horasTrab, double valorH);

    @Override
    public String toString() {
        String txt = "\nNome: " + nome + "\nMatrícula: " + matricula + "\nHoras trabalhadas: " + horasTrab + "\nValor hora: " + valorH;
        return txt;
    }
}
