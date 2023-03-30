package com.avdhoot.jerseyrest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepo repo = new AlienRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") long id) {
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien a1) {
		repo.createAlien(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien updateAlien(Alien a1) {
		if(repo.getAlien(a1.getId()).getId() == 0) {
			repo.createAlien(a1);
		}
		else {
			repo.updateAlien(a1);
		}
		return a1;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien killAlien(@PathParam("id") int id) {
		Alien retAlien = repo.getAlien(id);
		if(repo.getAlien(retAlien.getId()).getId() != 0) {
			repo.delete(id);
		}
		
		return retAlien;
	}
	
}
