package Controller;

import Domain.Rau;
import Repository.RauRepository;
import View.Rapoarte;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public UI(){}       //constructor implicit

    public static int printMenu(){      //function that prints the menu and receives the option
        System.out.println("\n MENU:");
        System.out.println("    1) Citeste din fisier");
        System.out.println("    2) Afisare tot");
        System.out.println("    3) Afisare ordonat alfabetic");
        System.out.println("    4) Afisare ordonat dupa lungime");
        System.out.println("    5) Adauga un rau nou");
        System.out.println("    6) Adauga mai multe rauri, separate prin ';'");
        System.out.println("    0) Exit");
        System.out.print("Optiunea ta:");
        Scanner s=new Scanner(System.in);
        int option;
        try{option=s.nextInt();
            return option;}
        catch(Exception var) {
            System.out.print("Wrong! give integer");
            return printMenu();}
    }

    public Rau citireRau(){
        try
        {System.out.print("    Da un rau:");
        String input;
        Scanner s=new Scanner(System.in);
        input=s.nextLine();
        String[] list= (input.split(" "));
        long str=Long.parseLong(list[1]);
        return new Rau(list[0],str);
        }
        catch(Exception var){System.out.println("Aualeuuu, eroareee, nu ai citit bine raul");
        return citireRau();
        }
    }

    public ArrayList<Rau> citireRauri(){
        ArrayList<Rau>rauri=new ArrayList<Rau>();
        try
        {System.out.print("    Da raurile separate prin ';' (spatiu intre nume si lungime) :");
            String input;
            Scanner s=new Scanner(System.in);
            input=s.nextLine();
            String[] l=input.split(";");
            for (String el:l){
                String[] list= (el.split(" "));
                long str=Long.parseLong(list[1]);
                rauri.add(new Rau(list[0],str));
            }
            return rauri;
        }
        catch(Exception var){System.out.println("Aualeuuu, eroareee, nu ai citit bine un rau");
            return citireRauri();
        }
    }

    public void Main(){     //control
        int opt=printMenu();
        RauRepository repo=new RauRepository();
        while(opt!=0){
            switch(opt){
                case 1: {
                    repo.citireDinFisier();
                    System.out.println("Am citit din fisier");
                    break;
                }
                case 2: {
                    Rapoarte.afisTot(repo);
                    break;
                }
                case 3: {
                    Rapoarte.afisNume(repo);
                    break;
                }
                case 4: {
                    Rapoarte.afisProcent(repo);
                    break;
                }
                case 5:{
                    repo.addEl(citireRau());
                    break;
                }
                case 6: {
                    ArrayList<Rau> raur=new ArrayList<Rau>(citireRauri());
                    for (Rau r:raur) {
                        if (repo.addEl(r) != 0) break;
                    }
                    break;
                }
                default: {System.out.println("wrong option");}
            }
            opt=printMenu();
        }
        System.out.println("bye...");

    }
}
