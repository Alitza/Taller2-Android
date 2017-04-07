package yiseth.alitza.dragonmaid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {
	private final int puerto = 5001;
	private MulticastSocket socket;
	private final String ADDRESS = "224.2.2.2";
	private InetAddress group;
	private AutoId id;
	private boolean hello;
	private ArrayList<Personaje> personajes;

	public Comunicacion() {
		id = new AutoId(0);
		hello =true;
        personajes = new ArrayList<Personaje>();
		try {
         group = InetAddress.getByName(ADDRESS);
         socket = new MulticastSocket(puerto);
         socket.joinGroup(group);
         String msg = "Hello";
         DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(),group, puerto);
         socket.send(hi);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		while (true) {
			try {
				byte[] buf = new byte[1000];
				DatagramPacket rcv = new DatagramPacket(buf, buf.length);
                socket.receive(rcv);
                respuesta(buf);
			} catch (Exception e) {
				

			}

		}
	}
	
	public void enviarObjeto(Object o){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.flush();
			byte[] ob = baos.toByteArray();
			   DatagramPacket hi = new DatagramPacket(ob, ob.length,group, puerto);	
			   socket.send(hi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void respuesta(byte[] arreglo){
		String a = new String(arreglo);
		Object o =null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(arreglo));
		     o = ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
	
		}
		if(o instanceof AutoId && hello){
			AutoId aut = (AutoId) o;
			if(aut.getId()>=id.getId()){
			id.setId(aut.getId()+1);
			}
			setChanged();
			notifyObservers(id);
			System.out.println(id.getId()+"----------------------------------------------------------------------------------------");
		}else if(a.trim().equals("Hello")){
			enviarObjeto(id);
			if(id.getId() != 0){
				hello = false;
			}
		}else if(o instanceof Personaje){
			Personaje p = (Personaje)o;
			agregarPersonaje(p);
			this.setChanged();
			notifyObservers(o);
		}else if(o instanceof Obstaculo){
			this.setChanged();
			notifyObservers(o);
		}
		
	}
	
	
	public void agregarPersonaje(Personaje p){
		boolean entro = false;
		for(int i=0;i<personajes.size();i++){
			if(p.getTipo() == personajes.get(i).getTipo()){
				entro = true;
			}
		}
		if(!entro){	
			personajes.add(p);
			this.setChanged();
			notifyObservers(personajes);
		}
		if(personajes.size() == 3){
			boolean comienza =true;
			setChanged();
			notifyObservers(comienza);
		}
		
	}
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		
		super.notifyObservers(arg);
	}


}