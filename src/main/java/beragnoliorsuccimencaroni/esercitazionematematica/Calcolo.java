/*
 *Esercitazione Matematica e complementi di Matematica di:
 *- Beragnoli Jacopo;
 *- Orsucci Giacomo;
 */

package beragnoliorsuccimencaroni.esercitazionematematica;

/**
 *
 * @author Beragnoli, Orsucci & Mencaroni
 * @title Esercitazione Matematica
 */

public class Calcolo 
{
    //COSTANTI
    private static final int ALPHAMAX = 361; //da 0 a 360, ma i valori di alfa=360 e beta=360 sono uguali a alfa=0 e beta=0. Perciò verranno stampati 0 e 0.
    private static final int BETAMAX = 361;
    private static final int RIGHE = ALPHAMAX * BETAMAX;
    private static final int COLONNE = 4;
    private static final double RANGE = 0.1;
    
    //Variabili INT
    private int alpha = 0;
    private int beta = -1;
    private int alfaFinale = 0;
    private int betaFinale = 0;
    
    //Variabili FLOAT
    private float l; //equivalente ad L
    private float m; //equivalente di l
    private float m1[][] = new float[RIGHE][COLONNE];
    
    //Variabili DOUBLE
    private double ax;
    private double ay;  //coordinate date in ingresso dall'utente
    
    //Costruttore vuoto
    public Calcolo(){}
    
    //Costruttore con in input la lunghezza delle due braccia
    public Calcolo(int l, int m)
    {
        this.l = l;
        this.m = m;
    }
    
    //Setter che uso
    public void setAx(double ax) {this.ax = ax;}
    
    public void setAy(double ay) {this.ay = ay;}
    
    
    //Getter che uso
    public double getAx() {return ax;}
    
    public double getAy() {return ay;}
    
    public float getL() {return l;}
    
    public float getM() {return m;}
    
    public int getAlfaFinale() {return alfaFinale;}
    
    public int getBetaFinale() {return betaFinale;}
    
    //Metodo per capire se il punto è raggiungibile
    public boolean puntoRaggiungibile()
    {
        return Math.sqrt(Math.pow(ax, 2) + Math.pow(ay, 2)) <= l + m && Math.sqrt(Math.pow(ax, 2) + Math.pow(ay, 2)) >= l - m;
    }
    
    //Metodo per impostare la matrice
    public void impostaMatrice() 
    {
        alpha = 0;
        beta = -1;
        for(int i=0; i<RIGHE; i++) //riempio la matrice con gli angoli alfa e beta (facendo 0-1, 0-2 fino a 0-360 poi 1-0 ecc...)
        {   
            beta++;
            m1[i][0] = alpha;
            m1[i][1] = beta;
            m1[i][2] = (float)(l * Math.cos(Math.toRadians(m1[i][0])) + m * Math.cos(Math.toRadians(m1[i][0] + m1[i][1]))); //mi calcolo la x
            m1[i][3] = (float)( l * Math.sin(Math.toRadians(m1[i][0])) + m * Math.sin(Math.toRadians(m1[i][0] + m1[i][1]))); //calcolo la y
            if(beta == 360)
            {   
                alpha++;
                beta = -1; //meno uno perchè poi appena ricomincia il ciclo per prima cosa incremento beta di 1
            }      
        }
    }
    
    //metodo per cercare il punto all'interno della matrice
    public void cercaPunto()
    {   
        double distanza;
        double distanzaAppoggio=10;
        for(int k=0; k<RIGHE; k++) //cerco il punto con distanza minore nel mio range all'interno della matrice
        {   
           if( (ax <= m1[k][2]+RANGE&&ax >= m1[k][2]-RANGE)||(ay <= m1[k][3]+RANGE&&ay >= m1[k][3]-RANGE)) //se il punto sta dentro il range
           {   
               distanza = Math.sqrt(Math.pow((m1[k][2] - ax), 2) + Math.pow((m1[k][3] - ay), 2));
               if(distanza<distanzaAppoggio)   //salvo il punto con la distanza minore all'interno del range
               {
                   distanzaAppoggio = distanza;
                   alfaFinale = (int) (m1[k][0]);
                   betaFinale = (int) (m1[k][1]);
               }
           }
        }
    }
}