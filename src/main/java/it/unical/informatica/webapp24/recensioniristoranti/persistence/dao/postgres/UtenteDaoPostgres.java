package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.postgres;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.DbManager;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.UtenteDao;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Biglietto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtenteDaoPostgres implements UtenteDao {
    Connection connection;

    public UtenteDaoPostgres(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Utente> findAll() {
        return List.of();
    }

    @Override
    public Utente findByPrimaryKey(String username) {
        String query = "SELECT * FROM utenti WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Utente utente = new Utente();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setNome(rs.getString("nome"));

                return utente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(Utente utente) {

    }

    @Override
    public void delete(Utente utente) {

    }
}
