package Repository;

import Domain.Rau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RauRepository {
    private ArrayList<Rau> rauri;
    private int nr;

    public RauRepository(){     //constructor implict
        rauri=new ArrayList<Rau>();
        nr=0;
    }
    public RauRepository(RauRepository r){      //constructor de copiere
        rauri = new ArrayList<Rau>(r.getRauri());
        nr=r.getNr();
    }

    public  RauRepository(ArrayList<Rau>r){     //constructor cu un parametru
        rauri=new ArrayList<Rau>(r);
    }

    public ArrayList<Rau> getRauri() {      //returneaza lista de rauri
        return rauri;
    }

    public int getNr() {        //returneaza numarul de rauri din lista
        return nr;
    }

    public Rau getRau(int i){       //returneaza un rau  de la un anumit index
        return this.rauri.get(i);
    }
    public void setRau(int i,Rau r){    //modifica un anumit rau de la un anumit iindex
        this.rauri.set(i,r);
    }

    public void setNr(int nr) {     //modifica numarul de rauri
        this.nr = nr;
    }

    public int addEl (Rau r){       //adauga un rau
        if (r.getLungime()==0) return -1;
        rauri.add(r);
        nr++;
        return 0;
    }

    public void clearEl(){      //elimina elementele din lista
        nr=0;
        rauri.clear();
    }

    public void citireDinFisier() {     //functie care realizeaza citirea din fisier
        this.clearEl();
        try {
            BufferedReader fisIn = new BufferedReader(new FileReader("C:\\Users\\Andreea\\IdeaProjects\\Rivers\\Rauri.txt"));
            String s; //= fisIn.readLine();

            for(int i = 0; (s = fisIn.readLine()) != null; ++i) {
                String[] felii = s.split(",");
                String nume = felii[0];
                long lungime = Long.parseLong(felii[1]);
                Rau r = new Rau();
                r.setNume(nume);
                r.setLungime(lungime);
                this.addEl(r);
            }
            fisIn.close();
        } catch (Exception var9) {
            System.out.println(var9.getMessage());
            var9.printStackTrace();
        }
    }
}
