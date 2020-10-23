package com.example.demo.DataSource;


import com.example.demo.model.Kunde;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KundeMapper implements RowMapper<Kunde> {
    @Override
    public Kunde mapRow(ResultSet rs, int rowNum) throws SQLException {
        int kundeid = rs.getInt("kundeid");
        int adresseid = rs.getInt("adresseid");
        int msid = rs.getInt("messlokationid");
        String fname = rs.getString("vorname");
        String lname = rs.getString("nachname");
        return new Kunde(kundeid, adresseid, msid, fname, lname);
    }
}
