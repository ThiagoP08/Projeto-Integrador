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
import model.Admin;
import service.AdminService;

@Path("admin")
public class AdminResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getAdmins() {
		AdminService service = new AdminService();
		List<Admin> lista = service.listarAdmins();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("admins/{id}")
	public Response getAdminsPorId(@PathParam("id") Integer id) {
		AdminService service = new AdminService();
		Admin admin = service.buscarAdminPorId(id);
		
		Response response = null;
		
		if(admin != null) {
			response = Response.status(Response.Status.OK).entity(admin).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("admins/{id}")
	public Response setDeletarAdmin(@PathParam("id") Integer id) {
		AdminService service = new AdminService();
		boolean retorno = service.excluirAdmin(id);
		
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
	public Response setIncluirAdmin(Admin admin) {
		AdminService service = new AdminService();
		boolean retorno = service.incluirAdmin(admin);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(admin).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a inclusão.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("admins")
	public Response setAlterarAdmin(Admin admin) {
		AdminService service = new AdminService();
		boolean retorno = service.alterarAdmin(admin);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(admin).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a alteração.").build();
		}
		
		return response;
	}
}
