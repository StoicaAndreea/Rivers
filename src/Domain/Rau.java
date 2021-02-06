package Domain;

public class Rau {
    private String nume;
    private long lungime;

    public Rau(){       //constructor implicit
        nume= "";
        lungime=0;
    }

    public Rau(String nume, long lungime){      //constructor cu parametri
        this.nume=nume;
        this.lungime=lungime;
    }

    public Rau(Rau r){      //constructor de copiere
        nume=r.getNume();
        lungime=r.getLungime();
    }

    public void setRau(Rau r){      //functia seteaza un rau in functie de alt rau
        nume=r.getNume();
        lungime=r.getLungime();
    }

    public String getNume() {       //functia returneaza numele raului
        return nume;
    }

    public long getLungime() {      //functia returneaza lungimea raului
        return lungime;
    }

    public void setNume(String nume) {      //functia seteaza numele raului
        this.nume = nume;
    }

    public void setLungime(long lungime) {      //functia seteaza lungimea raului
        this.lungime = lungime;
    }

    @Override
    public String toString() {      //functia converteste la string
        return "Rau{" +
                "nume='" + nume + '\'' +
                ", lungime=" + lungime +
                '}';
    }

    public boolean maiMareLungime(Rau r){       //arata daca raul curent are lungimea mai mare decat a alui rau
        return this.lungime>r.getLungime();
    }

    public boolean maiMareAlfabetic(Rau r){     //arata data raul curent este alfabetic mai mare decat un alt rau
        return this.nume.compareTo(r.getNume())<0;
    }
}
