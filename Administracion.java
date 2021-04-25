import Jpmi.*;

public class Administracion implements Proceso{
    public CanalSimple  canal_in[];
    public CanalSimple  in_sorteo;
    public CanalSimple  out_escru;
    public CanalSimple  in_escru;
    public CanalSimple  canal_out[];
    public MsgJugador [] jugadores;
    public Integer num;
    
    public Administracion(CanalSimple  canal_in[],
                            CanalSimple  in_sorteo,
                            CanalSimple  out_escru,
                            CanalSimple  in_escru,
                            CanalSimple  canal_out[]){

        this.canal_in   = canal_in;
        this.in_sorteo  = in_sorteo;
        this.out_escru  = out_escru;
        this.in_escru   = in_escru;
        this.canal_out  = canal_out;
    }
    public void run(){
        Lee[] l = new Lee[canal_in.length];
        Escribe[] e = new EScribe[canal_out.length];
        
        while(true){
            for(int i = 0; i < l.length; i++)
                l[i] = new Lee(canal_in[i]);
            new Paralelo(l).run();
            jugadores = new MsgJugador[l.length];
            for(int i = 0; i < l.length; i++)
                jugadores[i] = ((MsgJugador)l[i]).getMsg();
            num = (Integer)in_sorteo.receive();
            out_escru.send(new MsgAdm(jugadores, num));
            jugadores = (MsgJugador)in_escru.receive();
            for(int i = 0; i < e.length; i++){
                e[i] = new Escribe(canal_out[i],jugadores[i]);
            }
            new Paralelo(e).run();
        }
    }
    
}
