package it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.DbManager;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.BigliettoDao;

import java.util.List;

public class MezzoTrasportoProxy extends MezzoTrasporto{
    BigliettoDao bigliettoDao;

    public MezzoTrasportoProxy(){
        bigliettoDao = DbManager.getInstance().bigliettoDao();
    }

    @Override
    public List<Biglietto> getBiglietti() {
        List<Biglietto> biglietti = super.getBiglietti();
        if (biglietti == null) {
            super.setBiglietti(bigliettoDao.findAllByMezzoDiMezzoDiTrasporto(this));
        }
        return super.getBiglietti();
    }
}
