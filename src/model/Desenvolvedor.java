package model;

import interfaces.Trabalhavel;

public class Desenvolvedor extends Funcionario implements Trabalhavel{
    
    private String tecnologiaDominada;
    private double salario;
    private double auxilioSaude;

    public Desenvolvedor() {}

    public Desenvolvedor(String nome, int matricula, double horasTrab, double valorH, String tecnologiaDominada, double auxilioSaude) {
        super(nome, matricula, horasTrab, valorH);
        this.tecnologiaDominada = tecnologiaDominada;
        this.auxilioSaude = auxilioSaude;
        calcularSalario(horasTrab, valorH);
    }

    public String getTecnologiaDominada() {
        return tecnologiaDominada;
    }

    public void setTecnologiaDominada(String tecnologiaDominada) {
        this.tecnologiaDominada = tecnologiaDominada;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAuxilioSaude() {
        return auxilioSaude;
    }

    public void setAuxilioSaude(double auxilioSaude) {
        this.auxilioSaude = auxilioSaude;
    }

    @Override
    public void trabalhar() {
        System.out.println("Codando");
    }
    @Override
    public void relatarProgresso() {
        System.out.println("Tarefa concluída!");
    }
    @Override
    public void calcularSalario(double horasTrab, double valorH) {
        double salario = horasTrab * valorH;
        this.salario = salario;
    }

    @Override
    public String toString() {
        String txt = super.toString() + "\nSalário: R$" + salario + "\nAuxílio saúde: " + auxilioSaude + "\nTecnologia Dominada: " + tecnologiaDominada;
        return txt;
    }
}
