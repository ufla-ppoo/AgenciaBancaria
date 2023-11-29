
import java.util.Scanner;

/**
 * Interface de usuário para o programa
 * 
 * @author Julio César Alves
 */
public class InterfaceUsuario {
    private Agencia agencia;
    private Scanner entrada;
    private final int opcaoSair = 6;

    public InterfaceUsuario(String nomeAgencia) {
        agencia = new Agencia(nomeAgencia);
        entrada = new Scanner(System.in);
    }
    
    public void exibir() {        
        int opcao;
        do {
            opcao = exibirMenu();
            tratarOpcaoMenu(opcao);
        } while (opcao != opcaoSair);
    }

    private int exibirMenu() {
        System.out.println("Bem-vindo à agência " + agencia.getNome() + "!\n");
        System.out.println(
                "1 - Criar conta\n" +
                "2 - Relatório\n" +
                "3 - Depósito\n" +
                "4 - Saque\n" +
                "5 - Transferência\n" +
                "6 - Sair\n" );
        System.out.print("Digite sua opcao: ");
        return Integer.parseInt(entrada.nextLine());
    }

    private void tratarOpcaoMenu(int opcao) {
        System.out.println();
        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                exibirRelatorio();				
                break;
            case 3:
                fazerDeposito();
                break;
            case 4:
                fazerSaque();
                break;
            case 5:
                fazerTransferencia();
                break;
            case 6:
                System.out.println("\nObrigado por usar os servicos da Agencia " + agencia.getNome() + "!\n");
                break;
            default:
                System.out.println("\nOpcao invalida!\n");
                break;
        }

        if (opcao != opcaoSair) {
            aguardarEnter();
        }
    }

    private void criarConta() {
        try {
            int nroConta = agencia.criarConta();
            System.out.println("Conta " + nroConta + " criada!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void exibirRelatorio() {
        System.out.println(agencia.gerarRelatorio());
    }

    private int pedirConta() {
        System.out.print("Digite o numero da conta: ");
        return Integer.parseInt(entrada.nextLine());
    }

    private void aguardarEnter() {
        System.out.print("\n... pressione ENTER para continuar...");
        entrada.nextLine();
        System.out.println("\n");
    }

    private double pedirValor() {
        System.out.print("Digite o valor: ");
        return Double.parseDouble(entrada.nextLine());
    }

    private void fazerDeposito() {		
        try {
            agencia.depositar(pedirConta(), pedirValor());
            System.out.println("Deposito realizado com sucesso!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fazerSaque() {	
        try {
            agencia.sacar(pedirConta(), pedirValor());
            System.out.println("Saque realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Não foi possível sacar!");
        }
    }

    private void fazerTransferencia() {	
        try {
            agencia.transferir(pedirConta(), pedirConta(), pedirValor());
            System.out.println("Transferencia realizada com sucesso!");		
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Não foi possível transferir!");
        }
    }
}
