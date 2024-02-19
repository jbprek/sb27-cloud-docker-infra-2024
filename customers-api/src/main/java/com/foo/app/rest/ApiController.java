package com.foo.app.rest;

import com.foo.app.db.CustomerEntityRepository;
import com.foo.app.service.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${app.api.path}")
public class ApiController {

    private final CustomerMapper mapper;
    private final CustomerEntityRepository repository;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody final CustomerDto dto) {
        var entity = mapper.dtoToEntity(dto);
        var resEntity = repository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDTO(resEntity));
    }

    @GetMapping("/{id}")
    public CustomerDto read(@PathVariable final long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mapper.entityToDTO(entity);
    }

    @GetMapping(path = "/all")
    public List<CustomerDto> readAll() {
        return mapper.entityToDTO(repository.findAll());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto dto) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        mapper.dtoToEntity(dto, entity);
        var updatedEntity = repository.save(entity);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.entityToDTO(updatedEntity));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.delete(entity);
    }


}