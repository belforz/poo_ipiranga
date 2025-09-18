package poo2.poo2.models;

public class Recepcionista {
    private String nome;
    private String cpf;
    private String telefone;
    private String senha;
    // agregação: recepcionista pode gerenciar várias agendas
    private java.util.List<Agenda> agendas = new java.util.ArrayList<>();

    public Recepcionista() {
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.senha = "";
    }

    public Recepcionista(String nome, String cpf, String telefone, String senha) {
        try {
            if (nome == null || cpf == null || telefone == null || senha == null) {
                throw new IllegalArgumentException("Parâmetro inválido");
            }

            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.senha = senha;
        } catch (Exception e) {
            this.nome = "Erro de Exceção";
            this.cpf = "Erro de Exceção";
            this.telefone = "Erro de Exceção";
            this.senha = "Erro de Exceção";
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
    }

    public boolean acessar(String senha) {
        boolean ok = this.senha != null && this.senha.equals(senha);
        System.out.println("Acesso recepcionista (" + nome + "): " + (ok ? "OK" : "NEGADO"));
        return ok;
    }

    public void mostrar() {
        System.out.println("--- Recepcionista ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        if (!agendas.isEmpty()) {
            System.out.println("Agendas sob responsabilidade:");
            for (Agenda a : agendas) {
                System.out.println(" - " + a.getData() + " " + a.getHora());
            }
        }
    }

    public void adicionarAgenda(Agenda agenda) { if (agenda != null && !agendas.contains(agenda)) agendas.add(agenda); }
    public void removerAgenda(Agenda agenda) { agendas.remove(agenda); }

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

    public String getSenha() {
        return senha;
    }

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
