package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Utente;

import java.util.List;

public interface UtenteDao {
    public List<Utente> findAll();
    public Utente findByPrimaryKey(String username);
    public void save(Utente utente);
    public void delete(Utente utente);
}
