package it.unical.informatica.webapp24.recensioniristoranti.persistence;


import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.UtenteDao;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.dao.postgres.UtenteDaoPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    //Singlenton
    private static DbManager instance = null;
    public static DbManager getInstance(){
        if (instance == null){
            instance = new DbManager();
        }
        return instance;
    }

    Connection con = null;

    public Connection getConnection(){
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MezziTrasporto", "postgres", "postgres");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }


    public UtenteDao utenteDao(){
        return new UtenteDaoPostgres(getConnection());
    }

}
