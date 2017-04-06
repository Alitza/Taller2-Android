package yiseth.alitza.dragonmaid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
	private String id;
	private int idh;
	private boolean hello;



	public Comunicacion() {
		hello =true;
        idh = -1;
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
	
	public void enviarPersonaje(Personaje p){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(p);
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
	
		System.out.println(a);
		if(a.trim().equals("Hello")){
			String res = "Welcome";
			DatagramPacket respuesta = new DatagramPacket(res.getBytes(), res.length(),group, puerto);
			try {
				socket.send(respuesta);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(idh!=-1){
				hello =false;
			}
		}else if(a.trim().equals("Welcome")){
			if(hello){
			idh++;
			}
			id = ""+idh;
			setChanged();
			notifyObservers(idh);
		}else{
			notifyObservers(arreglo);
			
		}
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		super.notifyObservers(arg);
	}


}