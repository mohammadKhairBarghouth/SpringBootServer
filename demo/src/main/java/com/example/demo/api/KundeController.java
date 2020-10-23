package com.example.demo.api;

import com.example.demo.model.Kunde;
import com.example.demo.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/kunde")
@RestController
@CrossOrigin
public class KundeController {
    private final KundenService ps;
    @Autowired
    public KundeController(KundenService ps) {
        this.ps = ps;
    }

    @PostMapping("/add")
    public void addKunde(@RequestBody Kunde k){
        ps.addkunde(k);
    }

    @DeleteMapping("/")
    public ArrayList<Kunde> deleteKunde(@RequestBody Kunde k){
       return ps.dropKunde(k);
    }

    @GetMapping("/getAll")
    public List<Kunde> returnAllKunden(){
        return ps.getAll();
    }

    @PutMapping("/getKunde")
    public List<Kunde> returnKunde(@RequestBody Kunde k){
       return ps.searchFor(k);
    }

    @PutMapping("/")
    public void updateKunde(@RequestBody ArrayList<Kunde> k){
        ps.updateKunde(k);
    }
}
