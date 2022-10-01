package application;

import entities.Colaborador;
import entities.Contrato;
import entities.Setor;
import entities.enums.NivelColaborador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o setor: ");
        String setor = sc.nextLine();
        System.out.println("Entre com as informaçoes do colaborador");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nivel (JUNIOR, PLENO OU SENIOR): ");
        String nivel = sc.nextLine();
        System.out.print("Salario base: ");
        double salarioBase = sc.nextDouble();
        Colaborador colaborador = new Colaborador(nome, NivelColaborador.valueOf(nivel), salarioBase, new Setor(setor));
        System.out.println("Entre com o número de contratos desse colaborador: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Contrato *"+(i+1)+": ");
            System.out.print("Data (DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();
            Contrato contrato = new Contrato(dataContrato, valorHora, horas); //apos pegar todos os dados necessario do contrato, instaciei o contrato
            colaborador.addContrato(contrato);  //chamada do metodo que adiciona o contrato na lista de contratos do colaborador
        }
        System.out.println();
        System.out.print("Entre com um mês e ano para calcular a renda total (MM/YYYY): ");
        String mesEAno = sc.next();
        int mes = Integer.parseInt(mesEAno.substring(0, 2));
        int ano = Integer.parseInt(mesEAno.substring(3));
        System.out.println("Colaborador: " +colaborador.getName());
        System.out.println("Setor: " +colaborador.getSetor().getNome());
        System.out.println("Renda de " +mesEAno+ ": " + String.format("%.2f", colaborador.renda(ano,mes)));


        sc.close();
    }
}
