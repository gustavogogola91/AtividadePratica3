package model;

import interfaces.Trabalhavel;

public class Gerente extends Funcionario implements Trabalhavel{

    private String projeto;
    private double salario;
    private double bonusAnual;

    public Gerente() {}

    public Gerente(String nome, int matricula, double horasTrab, double valorH, String projeto, double bonusAnual) {
        super(nome, matricula, horasTrab, valorH);
        this.projeto = projeto;
        this.bonusAnual = bonusAnual;
        calcularSalario(horasTrab, valorH);
    }


    public String getProjeto() {
        return projeto;
    }
    
    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public void setBonusAnual(double bonusAnual) {
        this.bonusAnual = bonusAnual;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void calcularSalario(double horasTrab, double valorH) {
        double salario = horasTrab * valorH; // Gerente recebe bonificação de 5%
        salario += salario * 0.05;
        this.salario = salario;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerenciando projeto");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("");
    }

    @Override
    public String toString() {
        String txt = super.toString() + "\nProjeto gerenciado: " + projeto + "\nSalário: R$" + salario + "\nBonus anual: R$" + bonusAnual;
        return txt;
    }


}
