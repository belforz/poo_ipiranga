package poo2.poo2.models;
public class Medico {
    private String nome;
    private String crm;
    private String telefone;
    private String especialidade;
    private String senha;
    // associação: um médico pode ter várias consultas (agregação)
    private java.util.List<Consulta> consultas = new java.util.ArrayList<>();

    public Medico() {}

    public Medico(String nome, String crm, String telefone, String especialidade, String senha) {
        try {
            if (nome == null || crm == null || telefone == null || especialidade == null || senha == null) {
                throw new IllegalArgumentException("Parâmetro inválido");
            }

            this.nome = nome;
            this.crm = crm;
            this.telefone = telefone;
            this.especialidade = especialidade;
            this.senha = senha;
        } catch (Exception e) {
            this.nome = "";
            this.crm = "";
            this.telefone = "";
            this.especialidade = "";
            this.senha = "";
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
    }

    public boolean acessar(String senha) {
        boolean ok = this.senha != null && this.senha.equals(senha);
        System.out.println("Acesso médico (" + nome + "): " + (ok ? "OK" : "NEGADO"));
        return ok;
    }

    public void mostrar() {
        System.out.println("--- Médico ---");
        System.out.println("Nome: " + nome);
        System.out.println("CRM: " + crm);
        System.out.println("Telefone: " + telefone);
        System.out.println("Especialidade: " + especialidade);
        if (!consultas.isEmpty()) {
            System.out.println("Consultas do médico:");
            for (Consulta c : consultas) {
                System.out.println(" - " + c.getData() + " " + c.getHora() + " (" + (c.getMotivo()==null?"":c.getMotivo()) + ")");
            }
        }
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { try { if (crm==null) throw new IllegalArgumentException("Parâmetro inválido"); this.crm = crm; } catch (Exception e) { this.crm = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { try { if (telefone==null) throw new IllegalArgumentException("Parâmetro inválido"); this.telefone = telefone; } catch (Exception e) { this.telefone = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { try { if (especialidade==null) throw new IllegalArgumentException("Parâmetro inválido"); this.especialidade = especialidade; } catch (Exception e) { this.especialidade = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { try { if (senha==null) throw new IllegalArgumentException("Parâmetro inválido"); this.senha = senha; } catch (Exception e) { this.senha = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public void adicionarConsulta(Consulta consulta) { if (consulta != null && !consultas.contains(consulta)) consultas.add(consulta); }
    public void removerConsulta(Consulta consulta) { consultas.remove(consulta); }
}
