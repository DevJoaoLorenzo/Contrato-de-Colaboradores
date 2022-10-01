package entities;

import java.util.Date;

public class Contrato {
    private Date data;
    private Double valorHora;
    private Integer horas;

    public Contrato() {
    }

    public Contrato(Date date, Double hourValue, Integer hours) {
        this.data = date;
        this.valorHora = hourValue;
        this.horas = hours;
    }

    public Integer getHours() {
        return horas;
    }

    public void setHours(Integer horas) {
        this.horas = horas;
    }

    public Double getHourValue() {
        return valorHora;
    }

    public void setHourValue(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public double valorTotal(){
        return valorHora*horas;
    }
}
