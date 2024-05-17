package br.com.una.aquaplantapi.api.v1.resources;

import br.com.una.aquaplantapi.model.domain.Cliente;
import br.com.una.aquaplantapi.model.repository.ClienteRepositorio;
import br.com.una.aquaplantapi.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResources {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente saved = clienteRepositorio.save(cliente);
        if (saved == null) {
            return ResponseEntity.noContent().build();
        }

        URI uri = RestUtil.getUri(saved.getId());
        return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable("id") Long id,
                                           @RequestBody Cliente cliente) {
        Optional<Cliente> clienteDoBanco = clienteRepositorio.findById(id);
        if (!clienteDoBanco.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clienteDoBanco.get().update(id, cliente);
        Cliente saved = clienteRepositorio.save(cliente);
        if (saved == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> get() {
        List<Cliente> clienteList = clienteRepositorio.findAll();
        if (clienteList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clienteList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        Optional<Cliente> clienteList = clienteRepositorio.findById(id);
        if (!clienteList.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clienteList.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        clienteRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
