package bussines.repaso;

import Dao.ProductoDao;
import Model.Productos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProducto {
	@Inject
	private ProductoDao productoDao;

	public Productos obtenerProducto(int codigo) throws Exception {
		Productos productoEncontrado = this.productoDao.buscarProducto(codigo);

		if (productoEncontrado == null) throw new Exception("Producto no existe");

		return productoEncontrado;
	}

	public void crearProducto(Productos producto) throws Exception {
		if (producto == null) throw new Exception("Producto invalido");

		productoDao.insertarProducto(producto);
	}

	public void actualizarProducto(Productos producto) throws Exception {
		if (producto == null) throw new Exception("Producto invalido");
		
		productoDao.update(producto);
	}
	
	

}
