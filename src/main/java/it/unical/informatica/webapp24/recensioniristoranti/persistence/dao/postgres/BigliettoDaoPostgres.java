package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.postgres;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.DbManager;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.BigliettoDao;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Biglietto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.MezzoTrasporto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BigliettoDaoPostgres implements BigliettoDao {
    Connection connection;

    public BigliettoDaoPostgres(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Biglietto> findAll() {
        return List.of();
    }

    @Override
    public Biglietto findByPrimaryKey(Integer id){
        String query = "SELECT * FROM biglietti WHERE numero = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Biglietto biglietto = new Biglietto();
                biglietto.setNumero(rs.getInt("numero"));
                biglietto.setTipologia(rs.getString("tipologia"));
                biglietto.setPrezzo(rs.getFloat("prezzo"));
                biglietto.setTratta(rs.getString("tratta"));

                String username = rs.getString("username");
                Utente utente = DbManager.getInstance().utenteDao().findByPrimaryKey(username);
                biglietto.setUtente(utente);

                return biglietto;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void save(Biglietto biglietto) {

    }

    @Override
    public void delete(Biglietto biglietto) {

    }

    @Override
    public List<Biglietto> findAllByMezzoDiMezzoDiTrasporto(MezzoTrasporto mezzoTrasporto) {
        List<Biglietto> biglietti = new ArrayList<Biglietto>();
        Integer idMezzo = mezzoTrasporto.getId();
        String query = "SELECT * FROM biglietti WHERE id_mezzo = ?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, idMezzo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Biglietto biglietto = new Biglietto();
                biglietto.setNumero(rs.getInt("numero"));
                biglietto.setTipologia(rs.getString("tipologia"));
                biglietto.setPrezzo(rs.getFloat("prezzo"));
                biglietto.setTratta(rs.getString("tratta"));

                String username = rs.getString("username");
                Utente utente = DbManager.getInstance().utenteDao().findByPrimaryKey(username);
                biglietto.setUtente(utente);
                biglietti.add(biglietto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biglietti;
    }
}
