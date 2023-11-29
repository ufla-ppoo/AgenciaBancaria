public class SaldoInsuficienteException extends RuntimeException{
    private int nroConta;
    private double saldo;
    public SaldoInsuficienteException(int nroConta, double saldo){
        super("Saldo insuficiente na conta " + nroConta);

        this.nroConta = nroConta;
        this.saldo = saldo;
    }

    public int getNroConta(){
        return nroConta;
    }
    
}
