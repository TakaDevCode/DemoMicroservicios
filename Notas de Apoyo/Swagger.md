### @Tag

Agrupa todos los endpoints del controller bajo un nombre y descripción en la UI de Swagger.

Example

@Tag(name = "Pacientes",description = "Gestión de pacientes")

public class nombreclase{}

### @Operation

Describe qué hace un endpoint específico. Aparece como título del endpoint en Swagger UI.

Example

@Operation(
summary = "Buscar paciente por ID",
description = "Retorna un paciente según su ID"
)

public void metodo(){}

### @Parameter

Documenta un parámetro de tipo @PathVariable, @RequestParam o @RequestHeader.

Example

public ResponseEntity buscar(
@Parameter(description = "ID del paciente")
@PathVariable Long id) { }

### @ApiResponses
Contenedor para agrupar múltiples @ApiResponse en un solo método.

Example

@ApiResponses(value = {
@ApiResponse(responseCode = "200",
description = "OK"),
@ApiResponse(responseCode = "404",
description = "No encontrado")
})

public void metodo(){}
