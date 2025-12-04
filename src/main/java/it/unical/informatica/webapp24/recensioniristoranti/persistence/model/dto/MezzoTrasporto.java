package it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MezzoTrasporto {
    private Integer id;
    private String tipologia;
    private Integer capienza;
    private List<Biglietto> biglietti;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }
}
