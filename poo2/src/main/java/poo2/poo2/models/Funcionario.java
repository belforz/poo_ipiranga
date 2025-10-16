package poo2.poo2.models;

public class Funcionario extends Pessoa {
    private String senha;

    public Funcionario() {
        super();
        this.senha = "";
    }

    public Funcionario(int codigo, String nome, String telefone, String senha) {
        super(codigo, nome, telefone);
        setSenha(senha);
    }

    public void acessar() {
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("(Senha protegida)");
    }

    public String getSenha() { return senha; }
    public void setSenha(String senha) {
        try {
            if (senha == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.senha = senha;
        } catch (Exception e) {
            this.senha = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }
}
