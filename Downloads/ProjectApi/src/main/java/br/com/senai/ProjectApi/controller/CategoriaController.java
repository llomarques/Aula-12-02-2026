package br.com.senai.ProjectApi.controller;

import br.com.senai.ProjectApi.categoria.Categoria;
import br.com.senai.ProjectApi.categoria.CategoriaRepository;
import br.com.senai.ProjectApi.categoria.DadosCadastroCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")

public class CategoriaController {

    @Autowired //indica para o springboot que ele vai instanciar(criar) esse objeto
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados ){
        repository.save(new Categoria(dados));

    }

    @GetMapping
    public List<Categoria> listarCategoria(){
        return repository.findAll();
    }
}
