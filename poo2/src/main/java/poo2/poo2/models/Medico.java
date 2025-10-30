package poo2.poo2.models;
public class Medico extends Funcionario implements AcaoClinica, Mostravel {
    private String crm;
    private String especialidade;
    // associação: um médico pode ter várias consultas (agregação)
    private java.util.List<Consulta> consultas = new java.util.ArrayList<>();

    public Medico() { super(); this.crm = ""; this.especialidade = ""; }

    public Medico(int codigo, String nome, String crm, String telefone, String especialidade, String senha) {
        super(codigo, nome, telefone, senha);
        try {
            if (crm == null || especialidade == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.crm = crm;
            this.especialidade = especialidade;
        } catch (Exception e) {
            this.crm = "";
            this.especialidade = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    
    public Medico(String nome, String crm, String telefone, String especialidade, String senha) {
        this(0, nome, crm, telefone, especialidade, senha);
    }

    @Override
    public void mostrar() {
        System.out.println("--- Médico ---");
        super.mostrar();
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + especialidade);
        if (!consultas.isEmpty()) {
            System.out.println("Consultas do médico:");
            for (Consulta c : consultas) {
                System.out.println(" - " + c.getData() + " " + c.getHora() + " (" + (c.getMotivo()==null?"":c.getMotivo()) + ")");
            }
        }
    }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { try { if (crm==null) throw new IllegalArgumentException("Parâmetro inválido"); this.crm = crm; } catch (Exception e) { this.crm = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { try { if (especialidade==null) throw new IllegalArgumentException("Parâmetro inválido"); this.especialidade = especialidade; } catch (Exception e) { this.especialidade = ""; System.out.println("Ocorreu uma exceção – Valores padrões definidos"); } }
    public void adicionarConsulta(Consulta consulta) { if (consulta != null && !consultas.contains(consulta)) consultas.add(consulta); }
    public void removerConsulta(Consulta consulta) { consultas.remove(consulta); }

    public void consultar() {
        System.out.println("Consultando dados do médico: " + getNome());
    }

    // Polimorfismo: AcaoClinica
    @Override
    public void processar() {
        // comportamente padrão: emitir receita vazia se houver alguma consulta recente
        if (!consultas.isEmpty()) {
            Consulta c = consultas.get(0);
            if (c != null) {
                Receita r = new Receita(c, c.getData(), "Receita gerada via processar");
                c.adicionarReceita(r);
            }
        }
    }

    @Override
    public String resumo() {
        String crmV = (crm == null) ? "(sem crm)" : crm;
        String paciente = "(sem paciente)";
        if (!consultas.isEmpty() && consultas.get(0).getPaciente() != null) paciente = consultas.get(0).getPaciente().getNome();
        return "Médico [" + crmV + "] emitiu Ação para Paciente " + paciente;
    }

    @Override
    public void acessar() {
        System.out.println("Acesso perfil: MÉDICO");
    }
}
