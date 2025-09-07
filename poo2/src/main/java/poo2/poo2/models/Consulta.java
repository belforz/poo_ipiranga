package poo2.poo2.models;

public class Consulta {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private String motivo;
    private String historico;
    private boolean realizada;

    public Consulta() {
        this.data = "";
        this.hora = "";
        this.medico = null;
        this.paciente = null;
        this.motivo = "";
        this.historico = "";
        this.realizada = false;
    }

    public Consulta(String data, String hora, Medico medico, Paciente paciente, String motivo, String historico) {
        try {
            if (data == null || hora == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.data = data;
            this.hora = hora;
            this.medico = medico;
            this.paciente = paciente;
            this.motivo = motivo;
            this.historico = historico;
            this.realizada = false;
        } catch (Exception e) {
            this.data = "";
            this.hora = "";
            this.medico = null;
            this.paciente = null;
            this.motivo = "";
            this.historico = "";
            this.realizada = false;
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
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
        if (medico != null)
            System.out.println("Médico: " + medico.getNome());
        if (paciente != null)
            System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Motivo: " + motivo);
        System.out.println("Histórico: " + historico);
        System.out.println("Realizada: " + realizada);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        try {
            this.data = data;
        } catch (Exception e) {
            this.data = "";
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        try {
            this.hora = hora;
        } catch (Exception e) {
            this.hora = "";
        }
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        try {
            this.medico = medico;
        } catch (Exception e) {
            this.medico = null;
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        try {
            this.paciente = paciente;
        } catch (Exception e) {
            this.paciente = null;
        }
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        try {
            this.motivo = motivo;
        } catch (Exception e) {
            this.motivo = "";
        }
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        try {
            this.historico = historico;
        } catch (Exception e) {
            this.historico = "";
        }
    }
}
