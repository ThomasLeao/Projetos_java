package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("+------------------------------------+");
        System.out.println("|   Bem vindo a nossa Agencia!       |");
        System.out.println("|                                    |");
        System.out.println("|   Selecione uma operação que       |");
        System.out.println("|   deseja realizar:                 |");
        System.out.println("|                                    |");
        System.out.println("|   1 - Criar conta                  |");
        System.out.println("|   2 - Depositar                    |");
        System.out.println("|   3 - Sacar                        |");
        System.out.println("|   4 - Transferir                   |");
        System.out.println("|   5 - Listar                       |");
        System.out.println("|   6 - Sair                         |");
        System.out.println("+------------------------------------+");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 -> criarConta();


            case 2 -> depositar();


            case 3 -> sacar();


            case 4 -> transferir();


            case 5 -> listarContas();


            case 6 -> {
                System.out.println("Ate a proxima ");
                System.exit(0);
            }
            default -> {
                System.out.println("Opcao invalida!");
                operacoes();
            }


        }
    }

    public static void criarConta() {
        System.out.println("\n Nome:");
        String nome = input.next();

        System.out.println("\n CPF:");
        String cpf = input.next();

        System.out.println("\n email:");
        String email = input.next();


        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("qual valor deseja depositar?");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta nao encontrada!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta nao encontrada!");
        }
        operacoes();

    }

    public static void transferir() {
        System.out.println("Numero da conta do remente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        if (contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if (contaDestinatario != null) {
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();

                contaRemetente.trasferir(contaDestinatario, valor);
            }
        }
        operacoes();


    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Nao ha contas cadastradas!");
        }
        operacoes();
    }


}
