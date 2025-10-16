package poo2.poo2.models;

public class Paciente extends Pessoa {
    private String cpf;
    private String genero;
    private int idade;
    // associação: um paciente pode ter várias consultas (agregação)
    private java.util.List<Consulta> consultas = new java.util.ArrayList<>();

    public Paciente() { super(); this.cpf = ""; this.genero = ""; this.idade = 0; }

    public Paciente(int codigo, String nome, String cpf, String telefone, String genero, int idade) {
        super(codigo, nome, telefone);
        try {
            if (cpf == null || genero == null) throw new IllegalArgumentException("Parâmetro inválido");
            this.cpf = cpf;
            this.genero = genero;
            this.idade = idade;
        } catch (Exception e) {
            this.cpf = "";
            this.genero = "";
            this.idade = 0;
            System.out.println("Ocorreu uma exceção – Valores padrões definidos");
        }
    }

    
    public Paciente(String nome, String cpf, String telefone, String genero, int idade) {
        this(0, nome, cpf, telefone, genero, idade);
    }

    public void cadastrar() {
        System.out.println("Cadastrando paciente: " + getNome());
    }

    public void consultar() {
        System.out.println("Consultando paciente: " + getNome());
    }

    @Override
    public void mostrar() {
    System.out.println("--- Paciente ---");
    super.mostrar();
    System.out.println("CPF: " + cpf);
    System.out.println("Gênero: " + genero);
    System.out.println("Idade: " + idade);
        if (!consultas.isEmpty()) {
            System.out.println("Consultas do paciente:");
            for (Consulta c : consultas) {
                System.out.println(" - " + c.getData() + " " + c.getHora() + " (" + (c.getMotivo()==null?"":c.getMotivo()) + ")");
            }
        }
    }

    public void adicionarConsulta(Consulta consulta) {
        if (consulta != null && !consultas.contains(consulta)) {
            consultas.add(consulta);
        }
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
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
