package model;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario() {

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void curso_capacitacao(){
        salario = salario + (salario * 0.10);
        System.out.println("o salario agora é de: "+salario);
    }

    public void hora_extra(){
        salario = salario + (salario * 0.05);
        System.out.println("o salario agora é de: " + salario);
    }

    @Override
    public String toString() {
        return super.toString()   +
                "cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
