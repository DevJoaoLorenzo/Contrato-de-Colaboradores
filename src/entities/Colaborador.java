package entities;

import entities.enums.NivelColaborador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Colaborador {
    private String nome;    //atributo
    private NivelColaborador nivel; //atributo
    private Double salarioBase; //atributo

    private Setor setor;    //associaçao com outro objeto
    private List<Contrato> contratos = new ArrayList<>();   //associaçao com outro objeto, como pode ter mais de um contrato criei a lista;

    public Colaborador() {
    }

    public Colaborador(String nome, NivelColaborador nivel, Double salarioBase, Setor setor) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.setor = setor;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public NivelColaborador getNivel() {
        return nivel;
    }

    public void setNivel(NivelColaborador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void addContrato(Contrato contrato){
        contratos.add(contrato);
    }
    public void removeContrato(Contrato contrato){
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();
        for(Contrato c : contratos){
            cal.setTime(c.getDate()); //declarei que a data do calendario é a data do contrato "c"
            int c_ano = cal.get(Calendar.YEAR); //ano do contrato "c"
            int c_mes = 1+cal.get(Calendar.MONTH); //mes do contrato"c" +1 pq começa em 0
            if (ano == c_ano && mes == c_mes){ //se a data que o usuario entrou for igual a do contrato "c"
                soma+= c.valorTotal();
            }
        }
        return soma;
    }

}
