package com.example.demo.dao;


import com.example.demo.model.Kunde;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class currentKundneData implements KundeDao{
    private ArrayList<Kunde> kunden = new ArrayList<Kunde>();

    @Override
    public int insertKunde(Integer id, Integer adressei, Integer messlokationid, String vorname, String nachanme) {
        kunden.add(new Kunde(Kunde.getIdLevel(), adressei, messlokationid, vorname, nachanme));
        return 1;
    }

    public List<Kunde> getAll(){
        return kunden;
    }


}
