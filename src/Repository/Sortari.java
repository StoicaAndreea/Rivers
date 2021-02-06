package Repository;

import Domain.Rau;

import java.util.ArrayList;

public class Sortari {
    public Sortari(){}  //constructor implicit

    public static void sortareAlfabetic(RauRepository r) {      //functia sorteaza alfabetic in functie de nume utilizand bubble sort
        int pozInter;                                           //bubblesort
        int poz = pozInter = r.getNr() - 1;

        boolean flag;
        do {
            flag = true;

            for(int i = 0; i < poz; ++i) {
                if (r.getRau(i + 1).maiMareAlfabetic(r.getRau(i))) {
                    Rau aux = r.getRau(i);
                    r.setRau(i,r.getRau(i+1));
                    r.setRau(i+1,aux);
                    pozInter = i;
                    flag = false;
                }
            }

            poz = pozInter;
        } while(!flag);

    }

    public static void sortareLungime(RauRepository r) {        //functia sorteaza crescator in functie de lungim, utilizand bubble sort
        int pozInter;
        int poz = pozInter = r.getNr() - 1;

        boolean flag;
        do {
            flag = true;

            for(int i = 0; i < poz; ++i) {
                if (r.getRau(i + 1).maiMareLungime(r.getRau(i))) {
                    Rau aux = r.getRau(i);
                    r.setRau(i,r.getRau(i+1));
                    r.setRau(i+1,aux);
                    pozInter = i;
                    flag = false;
                }
            }

            poz = pozInter;
        } while(!flag);

    }
}
