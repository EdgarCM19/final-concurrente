import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Jpmi.*;

public class Escrutinio implements Proceso {
    
    public CanalSimple entrada, salida;

    public Escrutinio(CanalSimple entrada, CanalSimple salida){
        this.entrada = entrada;
        this.salida = salida;
    }

    public void run(){
        // while(true){
            MsgAdm msg = (MsgAdm)entrada.receive();
            int numeroGanador = msg.numero;
            for(int i = 0; i < msg.jugadores.length; i++)
                if(msg.jugadores[i].dato == numeroGanador)
                    msg.jugadores[i].ganador();
            guardarArchivo(msg.jugadores);
            salida.send(msg);
        // }
    }

    private void guardarArchivo(MsgJugador [] jugadores){
        final String fileName = "resultados.txt";
        File file = new File(fileName);
        StringBuffer cad = new StringBuffer("");
        if(!(file.exists() && !file.isDirectory()))
            cad.append("| 1 |\t| 2 |\t| 3 |\t| 4 |\t| 5 |\t| 6 |\t| 7 |\t| 8 |\t| 9 |\t| 10 |\n");
        for(int i = 0; i < jugadores.length; i++)
            cad.append(((jugadores[i].ganador) ? "| G |" : "| P |") + "\t");
        cad.append("\n");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(cad.toString());
            fw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

/*
En la clace del 1 de marzo explica el funcionamiento del proyecto final
Del minuto 20:10 al 20:40 especifica que el proceso jugador debe ejecutarse de 
manera infinita, pero despues, del minuto 26:10-26:30 nos indica que debemos dar
la opcion de preguntar si se vuelve a ejecutar un juego del bingo o no.
La duda es si el proceso jugador si tiene que ser infinito o no, puesto que al 
requerir preguntar si se desea seguir ejecutando no tendria sentido que sea infinito,
incluso se podria bloquear el programa ya que jugador estaria a la espera de datos
que no pueden ser enviados. Por lo que pensamos que el proceso jugador no debe ser 
infinito y se manda a llamar cuando se decida realizar una nueva ejecución. 

Suposición 1: Al referirse a que jugador se debe ejecutar infinitamente, es si se 
programa con memoria compartida, y el ciclo inifito seria para el wait.
Suposición 2: El juego y el preguntar se deben ejecutar de manera paralela y comunicar
si se desea jugar de nuevo o no, con pase de mensaje.
 */