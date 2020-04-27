package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;
@Named
@RequestScoped
public class MotorServiceImpl implements IMotorService, Serializable{

	@Inject
	private IMotorDao mD;// hacer referencia a la interface para usar su implementacion

	public void insertar(Motor motor) { 
		mD.insertar(motor);		
	}


	public List<Motor> listar() {
		return mD.listar();
	}


	public void eliminar(int idMotor) {
	  mD.eliminar(idMotor);		
	}


	public void actualizar(Motor motor) {
		mD.actualizar(motor);		
	}

}
