package poo2.poo2.models;

public class Recepcionista extends Funcionario implements AcaoClinica {
    private String cpf;
    // agregação: recepcionista pode gerenciar várias agendas
    private java.util.List<Agenda> agendas = new java.util.ArrayList<>();

    public Recepcionista() { super(); this.cpf = ""; }

    public Recepcionista(int codigo, String nome, String cpf, String telefone, String senha) {
        super(codigo, nome, telefone, senha);
        try {
            if (cpf == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.cpf = cpf;
        } catch (Exception e) {
            this.cpf = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

  
    public Recepcionista(String nome, String cpf, String telefone, String senha) {
        this(0, nome, cpf, telefone, senha);
    }

    public boolean acessar(String senha) {
        boolean ok = getSenha() != null && getSenha().equals(senha);
        System.out.println("Acesso recepcionista (" + getNome() + "): " + (ok ? "OK" : "NEGADO"));
        return ok;
    }

    // Polimorfismo: AcaoClinica
    @Override
    public void processar() {
        // marca uma consulta de exemplo se houver agendas; sem parâmetros usamos um placeholder
        if (agendas.isEmpty()) {
            System.out.println("Sem agendas para processar");
            return;
        }
        Agenda a = agendas.get(0);
        if (a != null && a.getMedico()!=null && a.getPaciente()!=null) {
            marcar(a.getData(), a.getHora(), a.getMedico(), a.getPaciente(), "(agendada via processar)");
        }
    }

    @Override
    public String resumo() {
        return "Consulta marcada por Recepcionista [cpf: " + cpf + "]";
    }

    
    public Consulta marcar(String data, String hora, Medico medico, Paciente paciente, String motivo) {
        Consulta c = new Consulta(data, hora, medico, paciente, motivo, "");
        System.out.println("Recepcionista marcou consulta para " + data + " " + hora + ".");
        return c;
    }

    public void cadastrarPaciente(Paciente paciente) {
        if (paciente != null) {
            paciente.cadastrar();
            System.out.println("Recepcionista cadastrou paciente: " + paciente.getNome());
        }
    }

    public void consultar() {
        System.out.println("Consultando recepcionista: " + getNome());
    }

    @Override
    public void mostrar() {
        System.out.println("--- Recepcionista ---");
        super.mostrar();
        System.out.println("CPF: " + cpf);
        if (!agendas.isEmpty()) {
            System.out.println("Agendas sob responsabilidade:");
            for (Agenda a : agendas) {
                System.out.println(" - " + a.getData() + " " + a.getHora());
            }
        }
    }

    public void adicionarAgenda(Agenda agenda) { if (agenda != null && !agendas.contains(agenda)) agendas.add(agenda); }
    public void removerAgenda(Agenda agenda) { agendas.remove(agenda); }

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

    
}
