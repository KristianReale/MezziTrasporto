package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Biglietto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.MezzoTrasporto;


import java.util.List;

public interface BigliettoDao {
    public List<Biglietto> findAll();
    public Biglietto findByPrimaryKey(Integer id);
    public void save(Biglietto biglietto);
    public void delete(Biglietto biglietto);
    public List<Biglietto> findAllByMezzoDiMezzoDiTrasporto(MezzoTrasporto mezzoTrasporto);
}
