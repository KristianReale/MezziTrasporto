package it.unical.informatica.webapp24.recensioniristoranti.persistence;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.UtenteDao;

public class DbManager {

    //Singlenton
    private static DbManager instance = null;
    public static DbManager getInstance(){
        if (instance == null){
            instance = new DbManager();
        }
        return instance;
    }

    public UtenteDao utenteDao(){
        return new UtenteDaoPostgres();
    }
}
