package model;

import interfaces.Trabalhavel;

public class Estagiario extends Funcionario implements Trabalhavel {

    private double salario;
    private Trabalhavel supervisor;
    private String curso;

    public Estagiario(String nome, int matricula, double horasTrab, double valorH,
            Trabalhavel supervisor, String curso) {
        super(nome, matricula, horasTrab, valorH);
        this.supervisor = supervisor;
        this.curso = curso;
        calcularSalario(horasTrab, valorH);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Trabalhavel getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Trabalhavel supervisor) {
        this.supervisor = supervisor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void trabalhar() {
        System.out.println("Aprendendo e codando");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Terminei essa parte!");
    }

    @Override
    public void calcularSalario(double horasTrab, double valorH) {
        this.salario = horasTrab * valorH;
    }

    @Override
    public String toString() {
        String txt = super.toString() + "\nSupervisor: " + supervisor.getNome() + " Matricula:" + supervisor.getMatricula() + "\nCurso: " + curso;
        return txt;
    }

}
