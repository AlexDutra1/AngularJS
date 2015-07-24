package br.com.WebService_basico.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.WebService_basico.modelo.Banda;

@Path("/bandas")
public class BandaResource {
	// vamos utilizar um Map estático para "simular" uma base de dados
	
	static private Map<Integer, Banda> bandasMap;

	static {
		bandasMap = new HashMap<Integer, Banda>();

		Banda b1 = new Banda();
		b1.setId(1);
		b1.setNome("Led Zeppelin");
		b1.setAnoDeFormacao(1968);

		bandasMap.put(b1.getId(), b1);

		Banda b2 = new Banda();
		b2.setId(2);
		b2.setNome("AC/DC");
		b2.setAnoDeFormacao(1973);

		bandasMap.put(b2.getId(), b2);
	}
	
	//@Produces("application/json")//RETORNA UM JSON PARA O CLIENT
	@GET // utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso
	@Produces("text/xml") //RETORNA UM XML PARA O CLIENT
	public List<Banda> getBandas() {
		return new ArrayList<Banda>(bandasMap.values());
	}
	// continua depois ...
	// Digite http://localhost:8080/WebService_basico/bandas
}
