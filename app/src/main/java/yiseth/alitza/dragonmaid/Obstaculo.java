package yiseth.alitza.dragonmaid;

import java.io.Serializable;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Obstaculo implements Serializable{
	
	
	
	private int tipo;
	private PApplet app;
	private PImage img;
	private PVector coordenadas;
	private int sector;
	
	
	
	
	public Obstaculo(int tipo, PApplet app) {
		super();
		this.tipo = tipo;
		this.app = app;
	}
	
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}
	public PImage getImg() {
		return img;
	}
	public void setImg(PImage img) {
		this.img = img;
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
