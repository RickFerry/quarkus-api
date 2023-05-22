package com.github.rickferry.controller;

import java.util.List;

import com.github.rickferry.model.Produto;
import com.github.rickferry.model.dto.CadastroProdutoDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("produtos")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @GET
    public List<Produto> getProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void cadastraProduto(CadastroProdutoDTO dto) {
        Produto.persist(new Produto(dto));
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateProduto(@PathParam("id") Long id, CadastroProdutoDTO dto) {
        Produto produto = (Produto) Produto.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Produto inexistente"));
        produto.nome = dto.nome();
        produto.valor = dto.valor();
        Produto.persist(produto);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteProduto(@PathParam("id") Long id) {
        Produto produto = (Produto) Produto.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Produto inexistente"));
        produto.delete();
    }
}
