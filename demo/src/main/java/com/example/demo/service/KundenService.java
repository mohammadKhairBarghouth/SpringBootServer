package com.example.demo.service;

import com.example.demo.dao.KundeDao;
import com.example.demo.model.Kunde;
import com.example.demo.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KundenService {
    private final KundeDao kundenDao;

    @Autowired
    KundeRepository kundeRepository;

    @Autowired
    public KundenService(@Qualifier("postgresDB") KundeDao kundenDao) {
        this.kundenDao = kundenDao;
    }

    public ArrayList<Kunde> dropKunde( Kunde k){
        ArrayList<Kunde> kunden = searchFor(k);
        for(Kunde kunde : kunden) {
            kundeRepository.delete(k);
            System.out.println("{INFO} Kunde deleted");
        }
        return kunden;
    }

    public void addkunde( Kunde k){
        kundeRepository.save(k);
    }

    public List<Kunde> getAll(){
        return kundenDao.getAll();
    }

    public void updateKunde(ArrayList<Kunde> k){
        if(k.size() == 2){
            ArrayList<Kunde> j = searchFor(k.get(0));
            if(j.size() > 0 && j.get(0) != null) {
                int id = j.get(0).getKundeid();
                dropKunde(j.get(0));
                Kunde newKunde = k.get(1);
                newKunde.setKundeid(j.get(0).getKundeid());
                kundeRepository.save(newKunde);
            }
        }
    }

    public ArrayList<Kunde> searchFor(Kunde k){
        ArrayList outputkunden = new ArrayList<Kunde>();
        List<Kunde> allKunden = getAll();

        int c = 0, f = 0;
        if(k.getKundeid() != null){
            c++;
        }
        if(k.getAdresseid() != null){
            c++;
        }
        if(k.getMesslokationid() != null){
            c++;
        }
        if(k.getVorname() != null){
            c++;
        }
        if(k.getNachname() != null){
            c++;
        }

        for(int i = 0; i < allKunden.size(); i++){
            f = 0;
            if(k.getKundeid() != null && k.getKundeid() == allKunden.get(i).getKundeid()){
                f++;
            }
            if(k.getAdresseid() != null && k.getAdresseid() ==  allKunden.get(i).getAdresseid()){
                f++;
            }
            if(k.getMesslokationid() != null && k.getMesslokationid() ==  allKunden.get(i).getMesslokationid()){
                f++;
            }
            if(k.getVorname() != null && k.getVorname().equals(allKunden.get(i).getVorname())){
                f++;
            }
            if(k.getNachname() != null && k.getNachname().equals( allKunden.get(i).getNachname())){
                f++;
            }
            if(f == c){
                outputkunden.add(allKunden.get(i));
            }
        }
        return outputkunden;
    }

    public Kunde getKundeById(Integer id){
        Optional<Kunde> kunde = kundeRepository.findById(id);
        if(kunde.isPresent()){
            return kunde.get();
        }
        return new Kunde();
    }
}
