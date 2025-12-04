package it.unical.informatica.webapp24.recensioniristoranti.controller;

import it.unical.informatica.webapp24.recensioniristoranti.persistence.DbManager;
import it.unical.informatica.webapp24.recensioniristoranti.persistence.model.dto.MezzoTrasporto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MezziDiTrasportoController {
    @PostMapping("/mezziTrasporto")
    public List<MezzoTrasporto> mezziTrasportoService(){
        List<MezzoTrasporto> mezziTrasporto = DbManager.getInstance().mezziTrasportoDao().findAll();
        return  mezziTrasporto;
    }
}
