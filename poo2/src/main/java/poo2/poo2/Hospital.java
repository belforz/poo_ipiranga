package poo2.poo2;

import poo2.poo2.models.Agenda;
import poo2.poo2.models.Consulta;
import poo2.poo2.models.Exame;
import poo2.poo2.models.Medico;
import poo2.poo2.models.Paciente;
import poo2.poo2.models.Receita;
import poo2.poo2.models.Recepcionista;

public class Hospital {
    public static void main(String[] args) {

        try {
       
        Paciente paciente = new Paciente("João Silva", "12345678900", "(11)99999-0000", "M", 30);
        Medico medico = new Medico("Dra. Ana", "CRM12345", "(11)3333-4444", "Cardiologia", "senha123");
        Recepcionista recepcionista = new Recepcionista("Larissa", "98765432100", "(11)2222-3333", "senha456");

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
       
    } catch (Exception e) {
        System.out.println("Erro ao executar o sistema do hospital: " + e.getMessage());
    }

}}
