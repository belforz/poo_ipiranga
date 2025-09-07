package poo2.poo2.models;

public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String genero;
    private int idade;

    public Paciente() {
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.genero = "";
        this.idade = 0;
    }

    public Paciente(String nome, String cpf, String telefone, String genero, int idade) {
        try {
            if (nome == null || cpf == null || telefone == null || genero == null) {
                throw new IllegalArgumentException("Parâmetro inválido");
            }

            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.genero = genero;
            this.idade = idade;
        } catch (Exception e) {
            this.nome = "";
            this.cpf = "";
            this.telefone = "";
            this.genero = "";
            this.idade = 0;
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
    }

    public void cadastrar() {
        System.out.println("Cadastrando paciente: " + nome);
    }

    public void consultar() {
        System.out.println("Consultando paciente: " + nome);
    }

    public void mostrar() {
        System.out.println("--- Paciente ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Gênero: " + genero);
        System.out.println("Idade: " + idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if (nome == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.nome = nome;
        } catch (Exception e) {
            this.nome = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        try {
            if (cpf == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.cpf = cpf;
        } catch (Exception e) {
            this.cpf = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
        

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try {
            if (telefone == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.telefone = telefone;
        } catch (Exception e) {
            this.telefone = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
        
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        try {
            if (genero == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.genero = genero;
        } catch (Exception e) {
            this.genero = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        try {
            if (idade < 0) throw new IllegalArgumentException("Idade inválida");
            this.idade = idade;
        } catch (Exception e) {
            this.idade = 0;
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }
}
