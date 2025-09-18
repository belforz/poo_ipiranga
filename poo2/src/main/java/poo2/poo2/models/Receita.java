package poo2.poo2.models;

public class Receita {
    private Consulta consulta;
    private String data;
    private String descritivo;

    public Receita() {
        this.consulta = null;
        this.data = "";
        this.descritivo = "";
    }

    public Receita(Consulta consulta, String data, String descritivo) {
        try {
            if (data == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.consulta = consulta;
            this.data = data;
            this.descritivo = descritivo;
            // associar composição: vincular receita à consulta
            if (this.consulta != null) this.consulta.adicionarReceita(this);
        } catch (Exception e) {
            this.consulta = null;
            this.data = "";
            this.descritivo = "";
            System.out.println("Ocorreu uma exceção - Valores padrões definidos");
        }
        
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
    public String getData() { return data; }
    public String getDescritivo() { return descritivo; }
}
