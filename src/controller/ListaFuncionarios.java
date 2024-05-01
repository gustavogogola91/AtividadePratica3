package controller;

import java.util.ArrayList;
import java.util.List;

import interfaces.Trabalhavel;
import model.Desenvolvedor;

public class ListaFuncionarios {

    private static List<Trabalhavel> listaFuncionarios = new ArrayList<>();

    public static void adicionarFuncionario(Trabalhavel func) {
        listaFuncionarios.add(func);
    }

    public static boolean verificarMatricula(int matricula) {
        for (Trabalhavel trabalhavel : listaFuncionarios) {
            if (matricula == trabalhavel.getMatricula()) {
                return true;
            }
        }
        return false;
    }

    public static List<Trabalhavel> getFuncionarios() {
        return listaFuncionarios;
    }

    public static Trabalhavel buscarFuncionario(int matricula) {
        for (Trabalhavel funcionario : listaFuncionarios) {
            if (funcionario.getMatricula() == matricula) {
                return funcionario;
            }
        }
        return null;
    }

    public static Trabalhavel buscarDesenvolvedor(int matricula) {
        for (Trabalhavel funcionario : listaFuncionarios) {
            if (funcionario.getMatricula() == matricula) {
                if (funcionario instanceof Desenvolvedor) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    public static boolean removerFuncionarios(int matricula) {

        Trabalhavel temp = buscarFuncionario(matricula);
        if (temp == null) {
            return false;
        } else {
            listaFuncionarios.remove(temp);
            return true;
        }
    }

}
