/**
 * Classe para teste da Agência Bancária
 * 
 * @author Julio César Alves
 */
public class AgenciaTeste {
    public static void main(String[] args) {		
        // cria uma agência de nome "Banco da UFLA"
        Agencia agenciaUFLA = new Agencia("Banco da UFLA");        

        // cria duas contas na agencia guardando o numero das contas
        int nroConta1 = agenciaUFLA.criarConta();
        int nroConta2 = agenciaUFLA.criarConta();

        // faz depósitos nas contas e exibe um relatório

        System.out.println();
        System.out.println("Depositando 100 na conta " + nroConta1 + 
                           " e 200 na conta " + nroConta2);
        agenciaUFLA.depositar(nroConta1, 100);
        agenciaUFLA.depositar(nroConta2, 200);
        System.out.println(agenciaUFLA.gerarRelatorio());
        
        // faz saque na conta 1

        System.out.println();
        System.out.println("Sacando 50 da conta " + nroConta1);
        if (agenciaUFLA.sacar(nroConta1, 50)) {
            System.out.println("\tSaque realizado com sucesso!");
        }
        else {
            System.out.println("\tSaldo insuficiente ou conta inexistente!");
        }					
        System.out.println(agenciaUFLA.gerarRelatorio());

        // faz saque na conta 2

        System.out.println();
        System.out.println("Sacando 300 da conta " + nroConta1);
        if (agenciaUFLA.sacar(nroConta2, 300)) {
            System.out.println("\tSaque realizado com sucesso!");
        }
        else {
            System.out.println("\tSaldo insuficiente ou conta inexistente!!");
        }					
        System.out.println(agenciaUFLA.gerarRelatorio());

        // faz transferência entre as contas

        System.out.println();
        System.out.println("Transferindo 120 da conta " + nroConta2 + 
                           " para a conta " + nroConta1);
        if (agenciaUFLA.transferir(nroConta2, nroConta1, 120)) {
            System.out.println("\tTransferencia realizada com sucesso!");
        }
        else {
            System.out.println("\tSaldo insuficiente ou conta inexistente!!");
        }					
        System.out.println(agenciaUFLA.gerarRelatorio());
    }
}