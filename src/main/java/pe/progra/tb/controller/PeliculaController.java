package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;

@Named
@RequestScoped
public class MotorController implements Serializable{
    @Inject
    private IMotorService mService;  
    
    private Motor motor;
    List<Motor> listaMotores;
    
    @PostConstruct
    public void init() {
    	System.out.println("PostContruct....");
    	this.listaMotores = new ArrayList<>();
    	this.motor =new Motor();
    	this.listar();//carga por defecto al listado
    	System.out.println("Cargo listado");
    }
    //un action lo puede invocar desde una pagina xhtml
    public String nuevoMotor() {
    	System.out.println("Nuevo motor");
    	this.setMotor(new Motor());
    	return "motor.xhtml";    	
    }
    
    public void insertar() {
    	System.out.println(motor.getNombreMotor() +"   " + motor.getFechaMotor());
    	mService.insertar(motor);//graba con los datos enviados del formulario
    	limpiarMotor();
    	this.listar();
    }
    
    public void eliminar(Motor motor) {
    	mService.eliminar(motor.getIdMotor());
    	this.listar();
    }
    
    public String actualizar(Motor motor) {
    	this.setMotor(motor);
    	return "motorU.xhtml";
    	
    }
    public void actualiza() {
    	mService.actualizar(motor);
    	this.listar();
    }
    
    public void limpiarMotor() {
    	this.init();
    }
    
    public void listar() {
    	listaMotores = mService.listar();
    }
    
    
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public List<Motor> getListaMotores() {
		return listaMotores;
	}
	public void setListaMotores(List<Motor> listaMotores) {
		this.listaMotores = listaMotores;
	}
}
