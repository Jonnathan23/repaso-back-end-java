package Dao;

import java.util.List;

import Model.Productos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDao {

	@PersistenceContext
	private EntityManager em;

	public void insertarProducto(Productos producto) {
		try {
			em.persist(producto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void update(Productos producto) {
		try {
			em.merge(producto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Productos buscarProducto(int codigo) {
		try {
			return em.find(Productos.class, codigo);
		} catch (Exception e) {
			return null;
		}
	}

	public void delete(int codigo) {
		try {
			Productos econtrarProducto = this.buscarProducto(codigo);

			if (econtrarProducto == null)
				throw new Error("Producto no econtrado");

			em.remove(econtrarProducto);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Productos> listarProductos() {
		String jpql = "SELECT c From Productos c";
		Query query = em.createQuery(jpql, Productos.class);

		return query.getResultList();
	}

}
