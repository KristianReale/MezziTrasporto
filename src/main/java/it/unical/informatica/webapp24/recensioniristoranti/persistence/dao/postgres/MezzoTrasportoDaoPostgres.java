package it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.postgres;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.DbManager;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.BigliettoDao;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.MezzoTrasportoDao;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Biglietto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.MezzoTrasporto;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MezzoTrasportoDaoPostgres implements MezzoTrasportoDao {
    Connection connection;

    public MezzoTrasportoDaoPostgres(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<MezzoTrasporto> findAll() {
        List<MezzoTrasporto> mezziTrasporto = new ArrayList<MezzoTrasporto>();
        String query = "SELECT * FROM mezzo_trasporto";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MezzoTrasporto mezzoTrasporto = new MezzoTrasporto();
                mezzoTrasporto.setId(rs.getInt("id"));
                mezzoTrasporto.setTipologia(rs.getString("tipologia"));
                mezzoTrasporto.setCapienza(rs.getInt("capienza"));

                BigliettoDao bigliettoDao = DbManager.getInstance().bigliettoDao();
                List<Biglietto> biglietti = bigliettoDao.findAllByMezzoDiMezzoDiTrasporto(mezzoTrasporto);

                mezzoTrasporto.setBiglietti(biglietti);

                mezziTrasporto.add(mezzoTrasporto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mezziTrasporto;
    }

    @Override
    public MezzoTrasporto findByPrimaryKey(Integer id) {
        String query = "SELECT * FROM mezzo_trasporto WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                MezzoTrasporto mezzoTrasporto = new MezzoTrasporto();
                mezzoTrasporto.setId(rs.getInt("id"));
                mezzoTrasporto.setTipologia(rs.getString("tipologia"));
                mezzoTrasporto.setCapienza(rs.getInt("capienza"));

                BigliettoDao bigliettoDao = DbManager.getInstance().bigliettoDao();
                List<Biglietto> biglietti = bigliettoDao.findAllByMezzoDiMezzoDiTrasporto(mezzoTrasporto);

                mezzoTrasporto.setBiglietti(biglietti);

                return mezzoTrasporto;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void save(MezzoTrasporto mezzoTrasporto) {

    }

    @Override
    public void delete(MezzoTrasporto mezzoTrasporto) {

    }
}
