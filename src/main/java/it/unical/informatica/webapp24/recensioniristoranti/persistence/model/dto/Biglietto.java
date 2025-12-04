package it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto;

import lombok.Data;

@Data
public class Biglietto {
    private Integer numero;
    private Float prezzo;
    private String tratta;
    private String tipologia;
    private Utente utente;
    //private MezzoTrasporto mezzoTrasporto;
}
