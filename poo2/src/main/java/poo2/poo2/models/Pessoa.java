package poo2.poo2.models;

public class Pessoa {
    private int codigo;
    private String nome;
    private String telefone;

    public Pessoa() {
        this.codigo = 0;
        this.nome = "";
        this.telefone = "";
    }

    public Pessoa(int codigo, String nome, String telefone) {
        setCodigo(codigo);
        setNome(nome);
        setTelefone(telefone);
    }

    public void mostrar() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) {
        try {
            if (codigo < 0) throw new IllegalArgumentException("Parâmetro inválido");
            this.codigo = codigo;
        } catch (Exception e) {
            this.codigo = 0;
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        try {
            if (nome == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.nome = nome;
        } catch (Exception e) {
            this.nome = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {
        try {
            if (telefone == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.telefone = telefone;
        } catch (Exception e) {
            this.telefone = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }
}
