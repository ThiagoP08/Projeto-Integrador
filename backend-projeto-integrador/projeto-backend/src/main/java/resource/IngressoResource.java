package resource;

import java.util.List;

import dao.IngressoDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Ingresso;

@Path("/ingressos")
public class IngressoResource {

    private final IngressoDAO ingressoDAO = new IngressoDAO();

    // buscar um ingresso pelo ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngresso(@PathParam("id") Integer id) {
        Ingresso ingresso = ingressoDAO.consultarPorId(id);
        if (ingresso.getId() != null) {
            return Response.ok(ingresso).build();
        } else {
            String mensagem = "Ingresso não encontrado para o ID: " + id;
            return Response.status(Response.Status.NOT_FOUND).entity(mensagem).build();
        }
    }

    // listar todos os ingressos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarIngressos() {
        List<Ingresso> ingressos = ingressoDAO.listar();
        String mensagem = "Nenhum ingresso encontrado.";
        return Response.ok(ingressos).entity(mensagem).build();
    }

    // criar um novo ingresso
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarIngresso(Ingresso ingresso) {
        boolean resultado = ingressoDAO.incluir(ingresso);

        if (resultado) {
        String mensagem = "Ingresso criado com sucesso.";
        return Response.status(Response.Status.CREATED)
                       .entity(mensagem)
                       .build();
        } else {
        String mensagem = "Não foi possível criar o ingresso.";
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(mensagem)
                       .build();
        }
    }

    // excluir um ingresso pelo ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirIngresso(@PathParam("id") Integer id) {
        boolean resultado = ingressoDAO.excluir(id);
        
        if (resultado) {
        String mensagem = "Ingresso excluído com sucesso.";
        return Response.noContent()
                       .entity(mensagem)
                       .build();
        } else {
        String mensagem = "Ingresso não encontrado para exclusão.";
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(mensagem)
                       .build();
        }
    }
}