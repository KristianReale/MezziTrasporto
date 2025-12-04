package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Biglietto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.MezzoTrasporto;

import java.util.List;

public interface MezzoTrasportoDao {
    public List<MezzoTrasporto> findAll();
    public MezzoTrasporto findByPrimaryKey(Integer numero);
    public void save(MezzoTrasporto mezzoTrasporto);
    public void delete(MezzoTrasporto mezzoTrasporto);
}
