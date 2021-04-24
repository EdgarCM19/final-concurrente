import Jpmi.*;
public class Lee implements Proceso {
   	CanalSimple canal_in;
   	MsgJugador msg;

   	public Lee(CanalSimple canal_in) {
		this.canal_in = canal_in;
   	}

   	public MsgJugador getMsg() {
	  	return msg;
   	}

   	public void run() {
	  	msg = (MsgJugador)canal_in.receive();
   	}
}
