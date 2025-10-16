package poo2.poo2.models;
public class Exame implements AcaoClinica {
    private Consulta consulta;
    private String data;
    private String descritivo;

    public Exame() {}

    public Exame(Consulta consulta, String data, String descritivo) {
        try {
            if (data == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.consulta = consulta;
            this.data = data;
            this.descritivo = descritivo;
            if (this.consulta != null) this.consulta.adicionarExame(this);
        } catch (Exception e) {
            this.consulta = null;
            this.data = "";
            this.descritivo = "";
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
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

    // Polimorfismo: AcaoClinica
    @Override
    public void processar() {
        solicitar(descritivo == null ? "" : descritivo);
    }

    @Override
    public String resumo() {
        String medico = (consulta != null && consulta.getMedico() != null) ? consulta.getMedico().getCrm() : "(sem médico)";
        String paciente = (consulta != null && consulta.getPaciente() != null) ? consulta.getPaciente().getNome() : "(sem paciente)";
        return "Exame solicitado por Médico [" + medico + "] para Paciente " + paciente + ": " + (descritivo == null ? "" : descritivo) + " em " + (data == null ? "(sem data)" : data);
    }

    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getDescritivo() { return descritivo; }
    public void setDescritivo(String descritivo) { this.descritivo = descritivo; }
    
}
