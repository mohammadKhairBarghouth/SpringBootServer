package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;

@SpringBootApplication
public class Kundeu {
    private String vorname;
    private String nachname;
    private Integer adresseid;
    private Integer mlID;

    public Kundeu(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Kundeu(Integer adresseid, Integer mlID, String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresseid = adresseid;
        this.mlID = mlID;
    }


    public Kundeu() {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresseid = adresseid;
        this.mlID = mlID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getAdresseid() {
        return adresseid;
    }

    public void setAdresseid(Integer adresseid) {
        this.adresseid = adresseid;
    }

    public Integer getMlID() {
        return mlID;
    }

    public void setMlID(Integer mlID) {
        this.mlID = mlID;
    }



    public void addToDB(Kundeu k, JdbcTemplate con) {
        String sql = "insert into kunde(vorname, nachname , adresseid) values ('mohammad','Khair',2);";

    }

    public static String Bedingung(Kundeu k, String and) {
        String vorn = "", nachm = "", adresseid = "", mldi = "", where ="";
        if ( k.getVorname() != null) {
            vorn = " vorname = '"+ k.getVorname()+ "'";
            where= "where";
        }
        if ( k.getNachname() != null) {
            if(k.getVorname() != null) {
                nachm=  and + " nachname = '" + k.getNachname()+ "'";
            }else {
                nachm = " nachname = '" +  k.getNachname() + "'";
            }
            where= "where";
        }
        if ( k.getAdresseid() != null) {
            if(k.getNachname() != null || k.getVorname() != null) {
                adresseid = and + " adresseid = "+ k.getAdresseid();
            }else {
                adresseid = " adresseid = "+ k.getAdresseid() +"";
            }
            where= "where";
        }
        if ( k.getMlID() != null) {
            if(k.getNachname() != null || k.getVorname() != null || k.getAdresseid() != null) {
                mldi = and + " messlokationid = "+ k.getMlID() ;
            }else {
                mldi = " messlokationid = "+ k.getMlID()  +"";
            }
            where= "where";
        }

        String sql = " " + where + vorn + nachm + adresseid +mldi;
        return sql;
    }

    public static ArrayList<Kundeu> setResultSet(Kundeu k, JdbcTemplate con) {
        String query = "select * from kunde " + Kundeu.Bedingung(k,  " and ");

        System.out.println(query);
        ArrayList<Kundeu> kunden = new ArrayList<Kundeu>();

        try {
            con.update(query);
        }catch(Exception e) {
            System.out.println("a problem occurred ");
        }

        return kunden;
    }

    public static void Drop(Kundeu k, JdbcTemplate con) {
        String query = "delete from kunde " + Kundeu.Bedingung(k, " and ");
        System.out.println(query);
        try {
            //Statement s = con.createStatement();
            //s.execute(query);
            con.update(query);
            System.out.println("success ");
        }catch(Exception e) {
            System.out.println("a problem occurred... ");
            e.printStackTrace();
        }
    }

      /*public static int getId(Kundeu k, JdbcTemplate con) {
        ArrayList<Kundeu> kunden = setResultSet(k, con);
        try {
            if(r.next() && (Integer)r.getInt("kundeid") != null ) {
                return  r.getInt("kundeid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

  public static void Update(Kundeu a1, Kundeu a2, JdbcTemplate con) {
        ArrayList<Kundeu> kunden = setResultSet(a1, con);
        //List <Integer> ids = new ArrayList();
        String ids = "";
        /*try {
            int c = 0;
            if(r.next() && (Integer)r.getInt("kundeid") != null ) {
                ids = r.getInt("kundeid") +"";
                c++;
            }
            while(r.next()) {
                if(c != 0 && (Integer)r.getInt("kundeid") != null){
                    ids = ids + ", "+ r.getInt("kundeid");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < kunden.size(); i++){
            if(i == 0){
                ids = kunden.get(i).get;
            }else{

            }
        }
        String updates = Bedingung(a2,con, ", ");
        updates = updates.substring(6);
        String sql =  "update kunde set "+updates +" where kundeid in ("+ids+")";
        System.out.println(sql);
        Statement s;
        try {
            s = con.createStatement();
            if(!ids.equals(""))
                s.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }*/

    public void addToDB(JdbcTemplate con) {
        String and = " , ";
        String value ="(";
        String value1 ="(";
        if ( this.getVorname() != null) {
            value = value+" vorname ";
            value1 = value1+ "'"+ this.getVorname()+ "'";
        }
        if ( this.getNachname() != null) {
            if(this.getVorname() != null) {
                value  = value + and + " nachname " ;
                value1 = value1+  and +"'"+this.getNachname()+ "'";
            }else {
                value = " nachname ";
                value1 = value1+"'" + this.getNachname() + "'";
            }
        }
        if ( this.getAdresseid()!= null) {
            if(this.getVorname() != null || this.getVorname() != null) {
                value  = value + and + "adresseid " ;
                value1 = value1+ and + this.getAdresseid();
            }else {
                value = " adresseid ";
                value1 = value1+this.getAdresseid();
            }
        }

        if ( this.getMlID() != null) {
            if(this.getVorname() != null || this.getVorname() != null || this.getAdresseid() != null) {
                value  = value + and + "  messlokationid" ;
                value1 = value1+ and +this.getMlID();
            }else {
                value = "  messlokationid ";
                value1 = value1+ this.getMlID();
            }
        }
        value = value+")";
        value1 = value1+")";

        String sql = "insert into kunde"+value+" values"+value1;
        con.execute(sql);
        System.out.println(sql);
    }

    public static void main(String [] args){

        SpringApplication.run(Kundeu.class, args);
        /*Connection c = DriverManager.
                getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
                        ,"user","password");*/
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/messstellenbetrieb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        JdbcTemplate i = new JdbcTemplate();
        Kundeu j = new Kundeu(4,null, "Hannah",".");
        j.addToDB(i);

    }

}

