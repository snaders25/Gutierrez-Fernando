package com.codigo.GutierrezFernando.controller;

import com.codigo.GutierrezFernando.entity.EmpresaEntity;
import com.codigo.GutierrezFernando.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO EMPRESA",
        description = "Esta api contiene todos los end points para realizar el mantenimiento de la entidad empresa"
)
public class EmpresaController {

    private final EmpresaService empresaService;
                        //crear//

@PostMapping("/crear")
@Operation(summary = "Crear una nueva Empresa")
@ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Persona Creada exitosamente",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = EmpresaEntity.class))})
})
public ResponseEntity<EmpresaEntity>crear(@RequestBody EmpresaEntity empresaEntity){
    return ResponseEntity.ok(empresaService.Crear(empresaEntity));
}
    @Operation(summary = "Buscar Una Persona Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Persona Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })


                    //BuscarID//
@GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>>buscarxId(@PathVariable Long id) {
    return ResponseEntity.ok(empresaService.BuscarxId(id));
}
                    //buscarTodos//
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>>buscarTodos() {
        return ResponseEntity.ok(empresaService.BuscarAll());
    }
                        //actualizar//
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity>actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity) {
        return ResponseEntity.ok(empresaService.Actualizar(id, empresaEntity));
    }
                        //eliminar//
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity>eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.Borrar(id));
    }
}
