package Services;

import java.util.List;


import Model.Productos;
import bussines.repaso.GestionProducto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/productos")
public class ProductoServices {

	@Inject
	private GestionProducto gestionProducto;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Productos producto) {
		try {
			gestionProducto.crearProducto(producto);
			return Response.ok(producto).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Productos producto) {
		try {
			gestionProducto.actualizarProducto(producto);
			return Response.ok(producto).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
			
		}
	}
	
	@GET
	@Path("/{codigo}")
	@Produces("application/json")
	public Productos obtenerProducto(@PathParam("codigo") int codigo) throws Exception {
		try {
			return gestionProducto.obtenerProducto(codigo);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	@GET
	@Produces("application/json")
	public List<Productos> list(){
		List<Productos> productos = gestionProducto.listarProductos();
		return productos;
	}

}
