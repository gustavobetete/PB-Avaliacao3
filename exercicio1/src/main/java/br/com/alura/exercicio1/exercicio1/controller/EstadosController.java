package br.com.alura.exercicio1.exercicio1.controller;

import br.com.alura.exercicio1.exercicio1.controller.dto.EstadoDto;
import br.com.alura.exercicio1.exercicio1.controller.form.AtualizacaoEstadoForm;
import br.com.alura.exercicio1.exercicio1.modelo.Estado;
import br.com.alura.exercicio1.exercicio1.modelo.StatusEstado;
import br.com.alura.exercicio1.exercicio1.repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/states")
public class EstadosController {

    @Autowired
    private EstadosRepository estadoRepository;

    @GetMapping // mesma url porem agora com metodo Get
    public Page<EstadoDto> lista(@RequestParam(required = false) StatusEstado regiao, @PageableDefault(sort="id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
                                                                                //@PageableDefault serve para indicar o padrão de paginação/ordenação ao Spring, quando o cliente da API não enviar tais informações
        if (regiao == null) {
            Page<Estado> estados = estadoRepository.findAll(paginacao);
            return EstadoDto.converter(estados);
        }else {
            Page<Estado> estados = estadoRepository.findByRegiao(regiao, paginacao);
            return EstadoDto.converter(estados);
        }

    }

    @PostMapping // mesma url porem agora com metodo Post
    @Transactional // se não fizer o @Transactional ele não atualiza o commit no banco de dados
    public ResponseEntity<Estado> cadastrar(@RequestBody @Valid Estado estado, UriComponentsBuilder uriBuilder){ // RequestBody indica ao String que os parâmetros enviados no corpo da requisição devem ser atribuidos ao parâmetro do método

        estadoRepository.save(estado);

        URI uri = uriBuilder.path("/api/states").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(estado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> detalhar(@PathVariable Long id){

        Optional<Estado> estado = estadoRepository.findById(id);
        if(estado.isPresent()){
            return ResponseEntity.ok(estado.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}") // put sobrescreve / atualiza todas informações que ja estão escritas.
    @Transactional
    public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoForm form ){
        Optional<Estado> optional = estadoRepository.findById(id);
        if(optional.isPresent()){
            Estado estado = form.atualizar(id, estadoRepository);
            return ResponseEntity.ok(new EstadoDto(estado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Estado> optional = estadoRepository.findById(id);
        if(optional.isPresent()) {
            estadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
