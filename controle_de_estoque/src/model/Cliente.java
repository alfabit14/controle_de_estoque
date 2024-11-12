package model;

public class Cliente extends Pessoa {
    double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "saldo=" + saldo +
                ", nome='" + nome + '\'' +
                ", cfp='" + cfp + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
