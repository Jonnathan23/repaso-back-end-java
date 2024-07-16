package bussines.repaso;

import Dao.ProductoDao;
import Model.Productos;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject ProductoDao productoDao;
	
	@PostConstruct
	public void init() {
		System.out.println("hola mundo ejb");
		
		Productos producto = new Productos();
		producto.setPro_codigo(1);
		producto.setPro_nombre("Televisor");
		producto.setPro_precio(565.89);
		
		productoDao.insertarProducto(producto);
	}

}
