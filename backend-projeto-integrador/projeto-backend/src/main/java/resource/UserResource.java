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
import model.User;
import service.UserService;

@Path("user")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getUsers() {
		UserService service = new UserService();
		List<User> lista = service.listarUsers();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("users/{id}")
	public Response getUsersPorId(@PathParam("id") Integer id) {
		UserService service = new UserService();
		User user = service.buscarUserPorId(id);
		
		Response response = null;
		
		if(user != null) {
			response = Response.status(Response.Status.OK).entity(user).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("users/{id}")
	public Response setDeletarUser(@PathParam("id") Integer id) {
		UserService service = new UserService();
		boolean retorno = service.excluirUser(id);
		
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
	public Response setIncluirUser(User user) {
		UserService service = new UserService();
		boolean retorno = service.incluirUser(user);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(user).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a inclusão.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAlterarUser(User user) {
		UserService service = new UserService();
		boolean retorno = service.incluirUser(user);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(user).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a alteração.").build();
		}
		
		return response;
	}
	
}
