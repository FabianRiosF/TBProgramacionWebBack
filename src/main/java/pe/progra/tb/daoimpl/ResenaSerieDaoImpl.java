package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;

public class MotorDaoImpl implements IMotorDao, Serializable{

	@PersistenceContext(unitName = "pmMotor") //nombre de persistence-unit de persistence.xml
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Motor motor) {
		em.persist(motor); //insertarlo en la base de  datos		
	}

	@Override
	public List<Motor> listar() {
		List<Motor> lista = new ArrayList<>();
		Query query = em.createQuery("select m from Motor m"); //JPA-QL
		      lista = (List<Motor>)query.getResultList();		
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idMotor) {
		Motor motor = new Motor();
		motor = em.getReference(Motor.class, idMotor);
		em.remove(motor);		
	}

	@Transactional
	@Override
	public void actualizar(Motor motor) {
		em.merge(motor);
		
	}

}
