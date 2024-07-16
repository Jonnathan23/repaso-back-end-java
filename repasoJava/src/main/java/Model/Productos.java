package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {
	
	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "pro_codigo")
	private int pro_codigo;
	
	@Column(name = "pro_nombre")
	private String pro_nombre;
	
	@Column(name = "pro_precio")
	private Double pro_precio;
	
	
	public int getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(int pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	public Double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(Double pro_precio) {
		this.pro_precio = pro_precio;
	}	
	
}
