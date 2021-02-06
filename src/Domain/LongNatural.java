package Domain;

public class LongNatural {		//clasa LongNatural, nr LongNatural cu cel mult DIM de cifre
    static int DIM=2000;		//DIM este numarul de cifre maximal
    byte       lung;		//lung=numarul de cifre al numarului
    int        cif[];		//spatiul de memorare al cifrelor
    //123 se va memora 321 !!!
    public LongNatural()  {		//constructor implicit
        lung=1;		//se initializeaza la 0, numarul alocat
        cif = new int[DIM];
        cif[0]=0;
    }
    public LongNatural(LongNatural n){				//constructor de copiere
        if (this!=n)
        {lung=n.lung;
            //System.out.println(this.lung);
            cif = new int[DIM];
            for(byte i=0;i<lung;i++)
                cif[i]=n.cif[i];
        }
    }
    public LongNatural(String sir){			//constructor creare din string de cifre
        int i,j;					// LongNatural n("000111111111111111111111111111111111");
        lung=(byte) sir.length();
        cif = new int[DIM];
        j  = 0;						//eliminare 0 nesemnificativi
        while ((j<lung) && (sir.charAt(j)=='0')) j++;
        if (j==lung) 					//daca j==lung atunci numarul e 0
        {lung=1;
            cif[0]=0;
        }
        else 						//altfel se pun cifrele caracter cu caracter
        {i=lung-1;					//dupa conventia 123 -> 321
            while (i>=j)
            {cif[lung - i-1]= (int)(sir.charAt(i)-'0');//se scade codul cifrei '0'
                i--;					  //sir[i] nu se poate!!!!
            }
            lung=(byte) (lung-j);				//se pune lungimea corecta
        }
        //System.out.println(lung);
    }

    private void EliminZero(){				//metoda privata, pentru eliminare 0  
        int j=lung-1;					//nesemnificativi
        while ((j>0) && (cif[j]==0))
            j--;
        if (j==0 && cif[0]==0) 					//cand avem 0, lung este 1 si cif[0]=0
            lung=1;
        else  	lung=(byte) (j+1);
    }


    public void Afisare(){					//afisare numar
        int i;
        i=lung-1;
        while (i>=0)						//afisare se face de la coada!!
        {System.out.print((cif[i]));
            i--;
        }
    }
    public boolean MaiMareEgal(LongNatural x){	//testeaza daca this >= x
        int i;
        boolean bool=false;
        if (lung>x.lung)				//daca lungimele difera concluzia e clara
            bool=true;
        else
        if (lung<x.lung)
            bool=false;
        else					//aici lungimile sunt egale
        {i=lung-1;
            while( (i>=0) && (cif[i]==x.cif[i])) i--;
            if (i<0) bool=true;
            else
            if  (cif[i]>x.cif[i])          //comparare lexicografica
                bool=true;
            else bool=false;
        }
        return bool;
    }
    public  boolean EgalZero(){					//test daca this are valoarea 0
        if ((lung==1) && (cif[0]==0))
            return true;
        return false;
    }

    public boolean  Egal(LongNatural a){			//testare daca this == a
        boolean bool;
        if (this.MaiMareEgal(a) &&  a.MaiMareEgal(this))
            bool=true;
        else bool=false;
        return bool;
    }
    public void Aduna(LongNatural a, LongNatural b) {//adunare this=a+b
        byte  LungMax,i;
        int   Transport,aux;
        if (a.MaiMareEgal(b)==true)			//se determina care dintre a si b are mai
        {  LungMax=(byte) a.lung;			//multe cifre
            this.lung=a.lung;
            for(i=(byte) (b.lung);  i<LungMax; i++)//se completeaza cu 0 cel mai mic 
                b.cif[i]=0;
        }
        else
        {
            LungMax=(byte) b.lung;
            this.lung=b.lung;
            for(i=(byte)(a.lung); i<LungMax;i++)//se completeaza cu 0 cel mai mic
                a.cif[i]=0;
        }
        Transport=0;							//incepe adunarea cifra cu cifra
        for (i=0 ;i<LungMax; i++){
            aux        = (a.cif[i]+b.cif[i]+Transport);
            cif[i]     = (int) (aux % 10);
            Transport  = (int) (aux / 10);
        }
        if (Transport>0){          				//daca exista transport la sfarsit
            lung++;
            cif[lung-1]=1; 				//se mareste lungimea  rezultatului
        }
        this.EliminZero();
    }

    public void Multiply(LongNatural a, LongNatural b){			//inmultire this=a*b
        byte i,j;
        int  Transport;
        if (a.EgalZero() || b.EgalZero())			//daca unul din factori e zero
        //produsul e nul
        {lung=1;
            cif[0]=0;
        }
        else
        {
            lung=(byte) (a.lung + b.lung+ 1);
            for (i=0; i< lung; i++)            	//initializare cifre produs cu 0
                cif[i]=0;
            for (i=0; i< a.lung;i++)
                for (j=0; j< b.lung;j++)
                {cif[i+j]=cif[i+j]+a.cif[i]*b.cif[j];
                    Transport =cif[i+j] / 10;
                    cif[i+j]=cif[i+j] % 10;
                    cif[i+j+1]+=Transport;  		//aduna transportul pozitiei urmatoare

                }
            EliminZero();  				//eliminare 0 nesemnificative}
        }
    }

    public boolean Modulo2()
    { if (this.cif[0] % 2 ==0) return true;
        return false;
    }
    public void Scade(LongNatural a){					//scadere 	this=this-a
        byte i;										//sau 		this=a-this
        LongNatural temp=new LongNatural();
        LongNatural dif =new LongNatural();
        if (a.MaiMareEgal(this))    				//interschimb a cu this
        { temp.lung=a.lung;						//temp<-a
            for(i=0;i<a.lung;i++) temp.cif[i]=a.cif[i];
            a.lung=this.lung;						//a<-this
            for(i=0;i<this.lung;i++) a.cif[i]=this.cif[i];
            this.lung=temp.lung;					//this<-temp
            for(i=0;i<temp.lung;i++) this.cif[i]=temp.cif[i];
        }
        for (i=a.lung; i<this.lung; i++)			//se pun cifrele lui a pe 0,
            a.cif[i]=0;								//pentru a egaliza lungimile
        dif.lung=this.lung;
        for (i=0; i<this.lung; i++)					//scadere cifra cu cifra
            if (this.cif[i]>=a.cif[i])
                dif.cif[i]=this.cif[i]-a.cif[i];      //scadere normala
            else
            {dif.cif[i]=this.cif[i]+10-a.cif[i]; 	//scadere cu imprumut
                this.cif[i+1]--;
            }
        dif.EliminZero();							//eliminare 0 nesemnificativi
        this.lung=dif.lung;							//copiere dif in this
        for(i=0;i<this.lung;i++) this.cif[i]=dif.cif[i];
    }

}



