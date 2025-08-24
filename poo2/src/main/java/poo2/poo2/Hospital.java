package poo2.poo2;

public class Hospital {
    public static void main(String[] args) {
       
        Paciente paciente = new Paciente("João Silva", "12345678900", "(11)99999-0000", "M", 30);
        Medico medico = new Medico("Dra. Ana", "CRM12345", "(11)3333-4444", "Cardiologia", "senha123");
        Recepcionista recepcionista = new Recepcionista("Maria", "98765432100", "(11)2222-3333", "senha456");

        Agenda agenda = new Agenda("2025-08-24", "10:00", medico, paciente);
        Consulta consulta = new Consulta("2025-08-24", "10:00", medico, paciente, "Dor no peito", "Sem histórico");
        Receita receita = new Receita(consulta, "2025-08-24", "Dipirona 500mg - 1 comprimido a cada 8h");
        Exame exame = new Exame(consulta, "2025-08-25", "Hemograma completo");

        
        paciente.mostrar();
        medico.mostrar();
        recepcionista.mostrar();
        agenda.mostrar();
        consulta.mostrar();
        receita.mostrar();
        exame.mostrar();
    }
}

class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String genero;
    private int idade;

    public Paciente() {}

    public Paciente(String nome, String cpf, String telefone, String genero, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.genero = genero;
        this.idade = idade;
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

    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
}

class Medico {
    private String nome;
    private String crm;
    private String telefone;
    private String especialidade;
    private String senha;

    public Medico() {}

    public Medico(String nome, String crm, String telefone, String especialidade, String senha) {
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.senha = senha;
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
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

class Recepcionista {
    private String nome;
    private String cpf;
    private String telefone;
    private String senha;

    public Recepcionista() {}

    public Recepcionista(String nome, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
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
    }

    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

class Agenda {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;

    public Agenda() {}

    public Agenda(String data, String hora, Medico medico, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public void consultar() {
        System.out.println("Consultando agenda em " + data + " " + hora);
    }

    public void mostrar() {
        System.out.println("--- Agenda ---");
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        if (medico != null) System.out.println("Médico: " + medico.getNome());
        if (paciente != null) System.out.println("Paciente: " + paciente.getNome());
    }

    // getters/setters
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}

class Consulta {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private String motivo;
    private String historico;
    private boolean realizada;

    public Consulta() {}

    public Consulta(String data, String hora, Medico medico, Paciente paciente, String motivo, String historico) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.motivo = motivo;
        this.historico = historico;
        this.realizada = false;
    }

    public void marcar(String data, String hora) {
        this.data = data;
        this.hora = hora;
        System.out.println("Consulta marcada para " + data + " " + hora);
    }

    public void cancelar() {
        System.out.println("Consulta cancelada em " + data + " " + hora);
        this.data = null;
        this.hora = null;
    }

    public void consultar() {
        System.out.println("Consultando consulta: " + (motivo != null ? motivo : "(sem motivo)"));
    }

    public void realizar() {
        this.realizada = true;
        System.out.println("Consulta realizada em " + data + " " + hora);
    }

    public void atualizar(String novoMotivo, String novoHistorico) {
        this.motivo = novoMotivo;
        this.historico = novoHistorico;
        System.out.println("Consulta atualizada: " + novoMotivo);
    }

    public void mostrar() {
        System.out.println("--- Consulta ---");
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        if (medico != null) System.out.println("Médico: " + medico.getNome());
        if (paciente != null) System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Motivo: " + motivo);
        System.out.println("Histórico: " + historico);
        System.out.println("Realizada: " + realizada);
    }

    
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getHistorico() { return historico; }
    public void setHistorico(String historico) { this.historico = historico; }
}

class Receita {
    private Consulta consulta;
    private String data;
    private String descritivo;

    public Receita() {}

    public Receita(Consulta consulta, String data, String descritivo) {
        this.consulta = consulta;
        this.data = data;
        this.descritivo = descritivo;
    }

    public void prescrever(String texto) {
        this.descritivo = texto;
        System.out.println("Prescrição: " + texto);
    }

    public void consultar() {
        System.out.println("Consultando receita de " + data + ": " + descritivo);
    }

    public void mostrar() {
        System.out.println("--- Receita ---");
        System.out.println("Data: " + data);
        if (consulta != null) System.out.println("Consulta em: " + consulta.getData() + " " + consulta.getHora());
        System.out.println("Descritivo: " + descritivo);
    }

    
    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getDescritivo() { return descritivo; }
    public void setDescritivo(String descritivo) { this.descritivo = descritivo; }
}

class Exame {
    private Consulta consulta;
    private String data;
    private String descritivo;

    public Exame() {}

    public Exame(Consulta consulta, String data, String descritivo) {
        this.consulta = consulta;
        this.data = data;
        this.descritivo = descritivo;
    }

    public void solicitar(String info) {
        this.descritivo = info;
        System.out.println("Solicitado exame: " + info);
    }

    public void consultar() {
        System.out.println("Consultando exame: " + descritivo + " em " + data);
    }

    public void mostrar() {
        System.out.println("--- Exame ---");
        System.out.println("Data: " + data);
        if (consulta != null) System.out.println("Consulta: " + consulta.getData() + " " + consulta.getHora());
        System.out.println("Descritivo: " + descritivo);
    }

    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getDescritivo() { return descritivo; }
    public void setDescritivo(String descritivo) { this.descritivo = descritivo; }
}
