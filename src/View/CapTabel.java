package View;

public class CapTabel {
    public CapTabel() {     //constructor implicit
    }

    public static void capTabel1() {        //capul de tabel pentru tabelul care afiseaza procentul de lungime
        String sir = "| Rau      | Lungime     | Proc. din lungimea maxima  |";
        String linii = "=======================================================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }

    public static void capTabel2() {        //capul de tabel pentru care afiseaza elementele din repo
        String sir = "|Rau       | Lungime     |";
        String linii = "==========================";
        System.out.println(linii);
        System.out.println(sir);
        System.out.println(linii);
    }
}
