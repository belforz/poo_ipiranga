package poo2.poo2.models;

public class Agenda {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;

    public Agenda() {

        this.data = "";
        this.hora = "";
        this.medico = null;
        this.paciente = null;

    }

    public Agenda(String data, String hora, Medico medico, Paciente paciente) {
        try {
            if (data == null || hora == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.data = data;
            this.hora = hora;
            this.medico = medico;
            this.paciente = paciente;
        } catch (Exception e) {
            this.data = "";
            this.hora = "";
            this.medico = null;
            this.paciente = null;
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }

    }

    public void consultar() {
        System.out.println("Consultando agenda em " + data + " " + hora);
    }

    public void mostrar() {
        System.out.println("--- Agenda ---");
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        if (medico != null)
            System.out.println("Médico: " + medico.getNome());
        if (paciente != null)
            System.out.println("Paciente: " + paciente.getNome());
    }

    
    public String getData() {
        return data;

    }

    public String getHora() {
        return hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setData(String data) {
        try {
            if (data == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.data = data;
        } catch (Exception e) {
            this.data = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public void setHora(String hora) {
        try {
            if (hora == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.hora = hora;
        } catch (Exception e) {
            this.hora = "";
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public void setMedico(Medico medico) {
        try {
            this.medico = medico;
        } catch (Exception e) {
            this.medico = null;
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    public void setPaciente(Paciente paciente) {
        try {
            this.paciente = paciente;
        } catch (Exception e) {
            this.paciente = null;
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }}
