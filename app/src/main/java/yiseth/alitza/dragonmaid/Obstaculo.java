package yiseth.alitza.dragonmaid;

import java.io.Serializable;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Obstaculo implements Serializable{
	
	
	
	private int tipo;
	private String img;
	private PVector coordenadas;
	private int sector;
	
	
	
	
	public Obstaculo(int tipo) {
		super();
		this.tipo = tipo;
		
	}
	
	
	
	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public PVector getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(PVector coordenadas) {
		this.coordenadas = coordenadas;
	}
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	
	

}
