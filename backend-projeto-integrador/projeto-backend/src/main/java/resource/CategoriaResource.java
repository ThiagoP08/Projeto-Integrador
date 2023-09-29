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
import model.Categoria;
import service.CategoriaService;


@Path("categoria")
public class CategoriaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getCategorias() {
		CategoriaService service = new CategoriaService();
		List<Categoria> lista = service.listarCategoria();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("categorias/{id}")
	public Response getCategoriasPorId(@PathParam("id") Integer id) {
		CategoriaService service = new CategoriaService();
		Categoria categoria = service.buscarCategoriaPorId(id);
		
		Response response = null;
		
		if(categoria != null) {
			response = Response.status(Response.Status.OK).entity(categoria).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("categorias/{id}")
	public Response setDeletarCategorias(@PathParam("id") Integer id) {
		CategoriaService service = new CategoriaService();
		boolean retorno = service.excluirCategoria(id);
		
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
	public Response setIncluirCategoria(Categoria categoria) {
		CategoriaService service = new CategoriaService();
		boolean retorno = service.incluirCategoria(categoria);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(categoria).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a inclusão.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAlterarCategoria(Categoria categoria) {
		CategoriaService service = new CategoriaService();
		boolean retorno = service.alterarCategoria(categoria);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(categoria).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a alteração.").build();
		}
		
		return response;
	}
}
