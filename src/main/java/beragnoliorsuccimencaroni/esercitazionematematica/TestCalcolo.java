/*
 *Esercitazione Matematica e complementi di Matematica di:
 *- Beragnoli Jacopo;
 *- Orsucci Giacomo;
 *- Mencaroni Tommaso;
 */

package beragnoliorsuccimencaroni.esercitazionematematica;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Beragnoli, Orsucci & Mencaroni
 * @title Esercitazione Matematica
 */
public class TestCalcolo 
{
    /**
     * 
     * MAIN
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException
    {
        //inizializzo braccio e gli do i valori tramite il costruttore parametrizzato
        Calcolo c1 = new Calcolo(2, 1); //dove il primo valore equivale a l ed il secondo ad m
        
        //oggetto scanner per l'input da tastiera
        Scanner input = new Scanner(System.in); 
        String sceltaString;
        double x = 0;
        double y = 0;
        int sceltaMenu = 0;
        do
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("*******************************************************");
            Thread.sleep(200);
            System.out.println("*                                                     *");
            Thread.sleep(200);
            System.out.println("*           ESERCITAZIONE BRACCIO ROBOTICO            *");
            Thread.sleep(200);
            System.out.println("*                      MATEMATICA                     *");
            Thread.sleep(200);
            System.out.println("*          di Beragnoli, Orsucci e Mencaroni          *");
            Thread.sleep(200);
            System.out.println("*                                                     *");
            Thread.sleep(200);
            System.out.println("*******************************************************");
            Thread.sleep(800);
            System.out.println("\n\n\nLa stampa verrà riprodotta finchè non saranno inserite delle cooordinate raggiungibili dal braccio.");
            System.out.println("(NOTA: Il punto è raggiungibile se L-l<=sqrt(x^2+y^2)<=l+L; dove x e y sono le coordinate inserite e L vale 2 e l vale 1).");
            //Richiesta in input della coordinata X del punto A
            do 
            {           
                do 
                {
                    System.out.println("\n");
                    System.out.print("Inserisci la coordinata X del punto A (Separare le cifre intere da quelle decimali con un PUNTO).");
                    System.out.print("\nSCELTA: ");
                    sceltaString = input.next();
                    try 
                    {
                        x = Double.parseDouble(sceltaString);
                        break;
                    } 
                    catch(java.lang.NumberFormatException e) 
                    {
                        System.out.println("Per favore inserire un numero.");
                    }
                }while(1 != 2);
                do 
                {
                    System.out.println("\n");
                    System.out.print("Inserisci la coordinata Y del punto A (Separare le cifre intere da quelle decimali con un PUNTO).");
                    System.out.print("\nSCELTA: ");
                    sceltaString = input.next();
                    try 
                    {
                        y = Double.parseDouble(sceltaString);
                        break;
                    } 
                    catch(java.lang.NumberFormatException e) 
                    {
                        System.out.println("Per favore inserire un numero.");
                    }
                    }while(1 != 2);
                    c1.setAx(x);
                    c1.setAy(y);
                    if(!c1.puntoRaggiungibile()) 
                    {
                        System.out.println("\tPer favore re-inserire i valori.\n\tI valori inseriti non sono raggiungibili.");
                    }
            } while (!c1.puntoRaggiungibile());
            //Richiamo il metodo che riempie la matrice 
            c1.impostaMatrice();
            /*
            richiamo il metodo che ricerca il punto più vicino al punto inserito calcolando la distanza minore 
            tra il punto inserito e i punti della matrice contenuti in un certo range  
            */
            c1.cercaPunto();
            //GRAFICA
            //*******************
            JFrame f = new JFrame("Esercitazione Matematica");
            Container c = f.getContentPane();
            MyPanel panel = new MyPanel();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setX((int)x);
            panel.setY((int)y);
            panel.setAlpha(c1.getAlfaFinale());
            panel.setBeta(c1.getBetaFinale());
            c.add(panel);
            f.setSize(new Dimension(1280, 720));
            f.setVisible(true);
            //******************
            //Stampa valori di alpha e beta
            System.out.println("\n\n\n\n\n\n\nI valori di Alpha e Beta che danno coordinate più vicine a:\nAx: " + c1.getAx() + "\nAy: " + c1.getAy() +
                                "\nSONO" + "\nALPHA: " + c1.getAlfaFinale() + "°\nBETA: " + c1.getBetaFinale() + "°");
            do 
            {
                System.out.println("\n");
                System.out.println("ATTENZIONE:\nChiudere la finestra grafica comporterà l'uscita dal programma!");
                System.out.print("Vuoi uscire?\n\t1) NO.\n\t2) SI.\nSCELTA: ");
                sceltaString = input.next();
                try 
                {
                    sceltaMenu = Integer.parseInt(sceltaString);
                }catch(NumberFormatException ex) 
                {
                    System.out.println("Per favore inserire 1 o 2.");
                    sceltaMenu = -1;
                }
            }while(sceltaMenu!=2 && sceltaMenu!=1);
            f.setVisible(false);
        }while(sceltaMenu==1);
        System.exit(0);
    }
}
