
import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma agência bancária.
 * 
 * Uma agência possui um nome e uma lista de contas. E permite realizar 
 * operações sobre as contas (a partir de seus números de identificação).
 * 
 * @author Julio César Alves
 */
public class Agencia {
    // nome da agência
    private String nome;    
    // guarda as contas da agência
    private Map<Integer,Conta> contas;
    
    /**
     * Cria uma agência com um nome (inicializa a coleção de contas)
     * 
     * @param nome Nome da agência.
     */
    public Agencia(String nome) {
        this.nome = nome;
        contas = new HashMap<>();
    }
    
    /**
     * Retorna o nome da agência.
     * 
     * @return Nome da agência.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cria uma conta na agência (com saldo zerado)
     * 
     * @return O número da conta criada
     */
    public int criarConta() {
        Conta conta = new Conta();
        contas.put(conta.getNumero(), conta);
        return conta.getNumero();
    }

    /**
     * Deposita um valor em uma conta.
     * 
     * @param nroConta Número da conta a ter valor depositado.
     * @param valor Valor a ser depositado na conta.
     */
    public void depositar(int nroConta, double valor) {
        // Busca a conta cujo número foi passado e, se existir, realiza o depósito
        Conta conta = contas.get(nroConta);        
        if (conta != null) {
            conta.depositar(valor);
        }
        else {
            throw new RuntimeException("Conta inválida!!!");
        }
    }

    /**
     * Realiza o saque de um valor em uma conta.
     * 
     * @param nroConta Número da conta a ter um valor sacado.
     * @param valor Valor a ser sacado da conta.
     */
    public void sacar(int nroConta, double valor) {
        // Busca a conta cujo número foi passado e, se existir, realiza o saque
        Conta conta = contas.get(nroConta);        
        if (conta != null) {
            conta.sacar(valor);
        }
        else {
            throw new RuntimeException("Conta inválida!!!");
        }
    }

    /**
     * Realiza a transferência de um valor de uma conta pra outra.
     * 
     * @param nroContaOrigem Conta da qual sairá o valor.
     * @param nroContaDestino Conta para a qual o valor será transferido.
     * @param valor Valor a ser transferido
     */
    public void transferir(int nroContaOrigem, int nroContaDestino, double valor) {
        
        // Busca as contas de origem e destino e, se existirem, tenta fazer a transferência
        Conta contaOrigem = contas.get(nroContaOrigem);
        Conta contaDestino = contas.get(nroContaDestino);

        if(contaOrigem == null){
            throw new RuntimeException("Conta de origem inválida!!!");
        }

        if(contaDestino == null){
            throw new RuntimeException("Conta de destino inválida!!!");
        }

        contaOrigem.transferir(contaDestino, valor);
  
    }

    /**
     * Retorna um relatório da agência com os dados das contas
     */
    public String gerarRelatorio() {        
        String relatorio = "\n==== Agência " + nome + " ====\n";
        if (contas.size() > 0) {
            for (int numero : contas.keySet()) {
                relatorio += contas.get(numero).extrato() + "\n";
            }
        }
        else {
            relatorio += "Não há contas nessa agência.\n";
        }
        return relatorio;
    }
}