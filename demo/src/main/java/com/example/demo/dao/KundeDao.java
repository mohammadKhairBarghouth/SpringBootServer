package com.example.demo.dao;

import com.example.demo.model.Kunde;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KundeDao {
    int insertKunde(Integer id ,Integer adressei, Integer messlokationid, String vorname, String nachanme );

    default int insertKunde(Kunde k){
        return insertKunde(k.getKundeid(), k.getAdresseid(), k.getMesslokationid(), k.getVorname(), k.getNachname());
    }

    public List<Kunde> getAll();
}
