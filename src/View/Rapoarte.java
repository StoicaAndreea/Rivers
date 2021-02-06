package View;

import Domain.Rau;
import Repository.RauRepository;
import Repository.Sortari;

public class Rapoarte {

    public Rapoarte(){      //constructor implicit
    }


    public static void afisNume(RauRepository r) {      //functia care afiseaza tabelul ordonat in functie de nume
        CapTabel.capTabel2();
        Sortari.sortareAlfabetic(r);
        for(int i = 0; i < r.getNr(); ++i) {
            System.out.format("|%-10s|%13s|\n", r.getRau(i).getNume(), r.getRau(i).getLungime());
        }

    }

    public static void afisTot(RauRepository r) {       //functia care afiseaza tabelul asa cum se afla in memorie
        CapTabel.capTabel2();
        for(int i = 0; i < r.getNr(); ++i) {
            System.out.format("|%-10s|%13s|\n", r.getRau(i).getNume(), r.getRau(i).getLungime());
        }

    }

    public static void afisProcent(RauRepository r) {       //functia care afiseaza tabelul ordonat in functie de
        CapTabel.capTabel1();                               //lungime si afiseaza procentul detinut in functie de cel mai lung rau
        Sortari.sortareLungime(r);
        Rau max=new Rau(r.getRau(0));

        for(int i = 0; i < r.getNr(); ++i) {
            double l=r.getRau(i).getLungime()/ (double)(max.getLungime())*100.0D;
            System.out.format("|%-10s|%13s|%28.2f|\n", r.getRau(i).getNume(), r.getRau(i).getLungime(),l);
        }

    }

}
