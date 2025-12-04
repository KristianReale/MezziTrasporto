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
}
