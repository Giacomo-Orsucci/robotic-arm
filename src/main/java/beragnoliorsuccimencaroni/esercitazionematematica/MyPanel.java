/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package beragnoliorsuccimencaroni.esercitazionematematica;
//importo le classi di cui ho bisogno
import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Beat
 */
public class MyPanel extends JPanel 
{   //costanti
    private static final int OFFSETX = 400;
    private static final int OFFSETY = 500;
    private static final int U = 50;
    //interi
    public int x;
    public int y;
    public int alpha;
    public int beta;
    //float
    private float l = 2; //equivalente di L del quad.
    private float m = 1; //equivalente di l del quad.
    //set e get che utilizzo
    public void setAlpha(int alpha) {this.alpha = alpha;}
    public void setBeta(int beta) {this.beta = beta;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Font titolo = new Font("Helvetica", Font.BOLD, 36);
        g.setFont(titolo);
        Font fo = new Font("Helvetica", Font.ITALIC, 18);
        g.setColor(Color.blue);
        g.drawString("ESERCITAZIONE MATEMATICA", 4, 60);
        g.setFont(fo);
        g.setColor(Color.black);
        g.drawString("di Beragnoli, Orsucci e Mencaroni", 100, 80);
        g.drawString("U = ", 670, 124);
        g.drawLine(715, 120, 750, 120);
        //PIANO CARTESIANO
        //*****************************
        g.drawString("Y", 370, 124);
        g.drawString("X", 900, 480);
        g.drawLine(400, 120, 400, 880);
        g.drawLine(1, 500, 900, 500);
        //****************************
        //Stampa del punto inserito dall'utente
        g.setColor(Color.red);
        if(x <= 0 && y < 0) 
        {
            g.fillOval(((OFFSETX-2) + (x*U)), ((OFFSETY-2) - (y*U)), 5, 5);
            g.drawString("A", ((OFFSETX + (x*U)) - 10), ((OFFSETY - (y*U)) - 10));
        } else if(x > 0 && y < 0) 
        {
            g.fillOval(((OFFSETX-2) + (x*U)), ((OFFSETY-2) - (y*U)), 5, 5);
            g.drawString("A", ((OFFSETX + (x*U)) - 10), ((OFFSETY - (y*U)) - 10));
        } else if(x <= 0 && y >= 0) 
        {
            g.fillOval(((OFFSETX-2) + (x*U)), ((OFFSETY-2) - (y*U)), 5, 5);
            g.drawString("A", ((OFFSETX + (x*U)) - 10), ((OFFSETY - (y*U)) - 10));
        } else 
        {
            g.fillOval(((OFFSETX-2) + (x*U)),((OFFSETY-2) - (y*U)), 5, 5);
            g.drawString("A", ((OFFSETX + (x*U)) - 10), ((OFFSETY - (y*U)) - 10));
        }
        
        //il modo di stampare le braccia varia al variare del valore dei punti
        //Stampa del primo braccio (l)
        
        g.setColor(Color.blue);
        int appoggiox = (int)(2 * Math.cos(Math.toRadians(alpha)));
        int appoggioy = (int)(2 * Math.sin(Math.toRadians(alpha)));
        int xbraccio = 0;
        int ybraccio = 0;
        if(appoggiox >= 0 && appoggioy <= 0)
        {
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
            xbraccio = (OFFSETX + (appoggiox*U));
            ybraccio = (OFFSETY - (appoggioy*U));
        }
        if(appoggiox<0 && appoggioy<0)
        {
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX - (appoggiox*U)), (OFFSETY + (appoggioy*U)));//
            xbraccio = (OFFSETX - (appoggiox*U));
            ybraccio =  (OFFSETY + (appoggioy*U));
        }
        if(appoggiox<0 && appoggioy>=0) 
        {
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
            xbraccio = (OFFSETX + (appoggiox*U));
            ybraccio =  (OFFSETY - (appoggioy*U));
        }
        if(appoggiox>0 && appoggioy>0)
        {
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
            xbraccio = (OFFSETX + (appoggiox*U));
            ybraccio = (OFFSETY - (appoggioy*U));
        }
        if(x >0 && y == 0)
        {   
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - U/2) );
            xbraccio = (OFFSETX + (appoggiox*U));
            ybraccio = (OFFSETY - U/2);
            g.setColor(Color.black);
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
        }
        if(x <0 && y == 0)
        {   
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - U/2) );
            xbraccio = (OFFSETX + (appoggiox*U));
            ybraccio = (OFFSETY - U/2);
            g.setColor(Color.black);
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
        }
        if(x == 0 && y> 0)
        {   
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + U), (OFFSETY - U) );
            xbraccio = (OFFSETX + U);
            ybraccio = (OFFSETY - U);
        }
        if(x == 0 && y< 0)
        {   
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX - U), (OFFSETY + U) );
            xbraccio = (OFFSETX - U);
            ybraccio = (OFFSETY + U); 
            g.setColor(Color.black);
            g.drawLine(OFFSETX, OFFSETY, (OFFSETX + (appoggiox*U)), (OFFSETY - (appoggioy*U)));
        }
        //stampa del secondo braccio (m)
        g.setColor(Color.green);
        appoggiox = (int) (1*Math.cos(Math.toRadians(alpha + beta)));
        appoggioy = (int) (1*Math.sin(Math.toRadians(alpha + beta)));
        if(appoggiox >= 0 && appoggioy < 0)
            g.drawLine(xbraccio, ybraccio, (xbraccio + (appoggiox*U)), (ybraccio - (appoggioy*U)));
        if(appoggiox < 0 && appoggioy < 0)
            g.drawLine(xbraccio, ybraccio, (xbraccio + (appoggiox*U)), (OFFSETY + (appoggioy*U)));
        if(appoggiox < 0 && appoggioy >= 0) 
            g.drawLine(xbraccio, ybraccio, (xbraccio + (appoggiox*U)), ybraccio);
        if(appoggiox >= 0 && appoggioy >= 0) 
            g.drawLine(xbraccio, ybraccio, (xbraccio + (appoggiox*U)), (ybraccio - appoggioy*U));
        if(x >0 && y == 0)
        {   
            g.drawLine(xbraccio, ybraccio, ((OFFSETX + (x*U))), (ybraccio + U/2));
        }
        if(x <0 && y == 0)
        {   
            g.drawLine(xbraccio, ybraccio, (OFFSETX + (x*U)), (ybraccio + U/2) );
        }
        if(x == 0 && y> 0)
        {   
            g.drawLine(xbraccio, ybraccio, (OFFSETX - (x*U)), (ybraccio - U) );
        }
        if(x == 0 && y< 0)
        {   
            g.drawLine(xbraccio, ybraccio, (OFFSETX + (x*U)), (ybraccio + U) );
        }
    }
}
