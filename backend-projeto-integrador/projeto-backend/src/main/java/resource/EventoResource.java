package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Evento;
import service.EventoService;

@Path("evento")
public class EventoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getEventos() {
		EventoService service = new EventoService();
		List<Evento> lista = service.listarEventos();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("eventos/{id}")
	public Response getEventosPorId(@PathParam("id") Integer id) {
		EventoService service = new EventoService();
		Evento evento = service.buscarEventoPorId(id);
		
		Response response = null;
		
		if(evento != null) {
			response = Response.status(Response.Status.OK).entity(evento).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos.").build();
		}
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("listarRandom")
	public Response getRandomEvento() {
		EventoService service = new EventoService();
		Evento evento = service.listarRandom();
		
		Response response = null;
		
		if(evento != null) {
			response = Response.status(Response.Status.OK).entity(evento).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("eventos/{id}")
	public Response setDeletarEvento(@PathParam("id") Integer id) {
		EventoService service = new EventoService();
		boolean retorno = service.excluirEvento(id);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a exclusão.").build();
		}
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setIncluirEvento(Evento evento) {
		EventoService service = new EventoService();
		boolean retorno = service.incluirEvento(evento);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(evento).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a inclusão.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAlterarEvento(Evento evento) {
		EventoService service = new EventoService();
		boolean retorno = service.alterarEvento(evento);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(evento).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a alteração.").build();
		}
		
		return response;
	}
}
