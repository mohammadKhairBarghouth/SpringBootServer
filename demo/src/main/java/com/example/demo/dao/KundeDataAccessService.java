package com.example.demo.dao;

import com.example.demo.DataSource.KundeMapper;
import com.example.demo.repository.KundeRepository;
import com.example.demo.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("postgresDB")
public class KundeDataAccessService implements KundeDao {
    @Autowired
    private  JdbcTemplate jdbcT;

    @Autowired
    KundeRepository b;

    public KundeDataAccessService(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }



    @Override
    public int insertKunde(Integer id, Integer adressei, Integer messlokationid, String vorname, String nachanme) {
        return 0;
    }

    @Override
    public int insertKunde(Kunde k) {
        b.save(k);
        return 1;
    }

    @Override
    public List<Kunde> getAll() {
        System.out.println("{INFO} get All request");
        return jdbcT.query("SELECT kundeid, adresseid, messlokationid, vorname, nachname FROM kunde order by kundeid",
                new KundeMapper());
    }
}
