package view;

import controller.ListaFuncionarios;
import interfaces.Trabalhavel;
import model.*;

public abstract class Sistema {

    public static void executar() {
        menu();
    }

    private static void menu() {

        int op;

        do {
            System.out.println("\n\nSISTEMA DE CADASTRO DE FUNCIONÁRIO");
            System.out.println("Selecione:");
            System.out.println("1) Cadastrar Gerente");
            System.out.println("2) Cadastrar Desenvolvedor");
            System.out.println("3) Cadastrar Estagiario");
            System.out.println("4) Mostrar todos os funcionários cadastrados");
            System.out.println("5) Buscar funcionário");
            System.out.println("6) Excluir funcionário");
            System.out.println("0) Finalizar programa");
            System.out.print(">>");
            op = Console.lerInt();

            switch (op) {
                case 1:
                    cadastrarGerente();
                    break;
                case 2:
                    cadastrarDesenvolvedor();
                    break;
                case 3:
                    cadastrarEstagiario();
                    break;
                case 4:
                    for (Trabalhavel func : ListaFuncionarios.getFuncionarios()) {
                        System.out.println(func);
                    }
                    break;
                case 5:
                    buscarFuncionario();
                    break;
                case 6:
                    excluirFuncionario();
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        } while (op != 0);
    }

    private static void cadastrarGerente() {
        String nome;
        int matricula;
        double horasTrab;
        double valorH;
        String projeto;
        double bonusAnual;

        System.out.println("CADASTRO DE GERENTE");
        do {
            System.out.print("Insira a matrícula: ");
            matricula = Console.lerInt();

            if (ListaFuncionarios.verificarMatricula(matricula)) {
                System.out.printf("Matricula %d já está cadastrada, insira novamente.%n", matricula);
            } else {
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Horas trabalhadas: ");
                horasTrab = Console.lerDouble();
                System.out.print("Valor hora: R$ ");
                valorH = Console.lerDouble();
                System.out.print("Nome do projeto: ");
                projeto = Console.lerString();
                System.out.print("Bonus anual: R$ ");
                bonusAnual = Console.lerDouble();

                Gerente temp = new Gerente(nome, matricula, horasTrab, valorH, projeto, bonusAnual);
                ListaFuncionarios.adicionarFuncionario(temp);
                break;
            }
        } while (true);
    }

    private static void cadastrarDesenvolvedor() {
        String nome;
        int matricula;
        double horasTrab;
        double valorH;
        String tecnologia;
        double auxilioSaude;

        System.out.println("CADASTRO DE DESENVOLVEDOR");
        do {
            System.out.print("Insira a matrícula: ");
            matricula = Console.lerInt();

            if (ListaFuncionarios.verificarMatricula(matricula)) {
                System.out.printf("Matricula %d já está cadastrada, insira novamente.%n", matricula);
            } else {
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Horas trabalhadas: ");
                horasTrab = Console.lerDouble();
                System.out.print("Valor hora: R$ ");
                valorH = Console.lerDouble();
                System.out.print("Tecnologia: ");
                tecnologia = Console.lerString();
                System.out.print("Auxilio saúde: R$ ");
                auxilioSaude = Console.lerDouble();

                Desenvolvedor temp = new Desenvolvedor(nome, matricula, horasTrab, valorH, tecnologia, auxilioSaude);
                ListaFuncionarios.adicionarFuncionario(temp);
                break;
            }
        } while (true);
    }

    private static void cadastrarEstagiario() {
        String nome;
        int matricula;
        double horasTrab;
        double valorH;
        Trabalhavel supervisor;
        String curso;

        System.out.println("CADASTRO DE ESTAGIÁRIO");
        do {
            System.out.print("Insira a matrícula: ");
            matricula = Console.lerInt();

            if (ListaFuncionarios.verificarMatricula(matricula)) {
                System.out.printf("Matricula %d já está cadastrada, insira novamente.%n", matricula);
            } else {
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Horas trabalhadas: ");
                horasTrab = Console.lerDouble();
                System.out.print("Valor hora: R$ ");
                valorH = Console.lerDouble();
                supervisor = buscarSupervisor();
                System.out.print("Curso: ");
                curso = Console.lerString();

                Estagiario temp = new Estagiario(nome, matricula, horasTrab, valorH, supervisor, curso);
                ListaFuncionarios.adicionarFuncionario(temp);
                break;
            }
        } while (true);
    }

    private static Trabalhavel buscarSupervisor() {
        int matricula;
        do {
            System.out.print("Insira a matricula do supervisor: ");
            matricula = Console.lerInt();
            Trabalhavel temp = ListaFuncionarios.buscarFuncionario(matricula);

            if (temp == null) {
                System.out.println("Matricula não cadastrada, tente novamente.");
            } else {
                return temp;
            }
        } while (true);
    }

    private static void buscarFuncionario() {
        int matricula;
        System.out.println("BUSCA DE FUNCIONÁRIO");
        System.out.print("Insira a matricula do funcionario: ");
        matricula = Console.lerInt();
        Trabalhavel temp = ListaFuncionarios.buscarFuncionario(matricula);

        if (temp == null) {
            System.out.printf("Matricula %d não esta cadastrada.%n", matricula);
        } else {
            System.out.println(temp);
        }

    }

    private static void excluirFuncionario() {
        System.out.println("EXCLUSÃO DE FUNCIONÁRIO");
        int matricula;
        System.out.print("Insira a matricula do funcionario: ");
        matricula = Console.lerInt();

        if (ListaFuncionarios.verificarMatricula(matricula)) {
            if (ListaFuncionarios.removerFuncionarios(matricula)) {
                System.out.println("Funcionário removido");
            }
        } else {
            System.out.printf("Matricula %d não esta cadastrada.%n", matricula);
        }
    }
}
