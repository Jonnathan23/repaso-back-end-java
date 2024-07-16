package bussines.repaso;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
public class Inicio {
	
	@PostConstruct
	public void init() {
		System.out.println("hola mundo ejb");
	}

}
