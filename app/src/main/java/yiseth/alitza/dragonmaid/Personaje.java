package yiseth.alitza.dragonmaid;

import java.io.Serializable;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Personaje implements Serializable {

	
	private String personaje;
	private int tipo;
	private int sector;
	private PVector coordenadas;

	
	
	
	public Personaje(int tipo, PVector coordenadas) {
		
		
		this.tipo = tipo;
		if(tipo == 0){
			this.personaje = "./Imagenes/pUno.png";
			}else if(tipo == 1){
				this.personaje = "./Imagenes/pDos.png";
			}else if(tipo == 2){
				this.personaje = "./Imagenes/pTres.png";
			}
		this.coordenadas = coordenadas;
	}
	
	
	public int getTipo(){
		return tipo;
	}
	
	
	public String getPersonaje() {
		return personaje;
	}





	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}





	public int getSector() {
		return sector;
	}


	public void setSector(int sector) {
		this.sector = sector;
	}


	public void mover(float x, float y){
		coordenadas.x = coordenadas.x+x;
		coordenadas.y = coordenadas.y+y;
	}
	public PVector getCoordenadas(){
		return coordenadas;
	}
	public void setTipo(int tipo)
	{
	this.tipo = tipo;
	}
	
	public void ajustarSector(int tipo){
		if(tipo == 1){
			sector = 1;
		}else if(tipo == 2){
			sector = 2;
		}else{
			sector = 3;
		}
	}
	
	public void ajustarCoordenadas(){
		if(tipo == 0){
			coordenadas.x = 120;
			coordenadas.y = 120;
		}else if(tipo == 1){
			coordenadas.x = 335;
			coordenadas.y = 120;
		}else if(tipo == 2){
			coordenadas.x = 120;
			coordenadas.y = 330;
		}
	}
	public void ajustarImg(int tipo){
		    if(tipo == 0){
			this.personaje = "./Imagenes/pUno.png";
			}else if(tipo == 1){
				this.personaje = "./Imagenes/pDos.png";
			}else if(tipo == 2){
				this.personaje = "./Imagenes/pTres.png";
		}
	}
}
