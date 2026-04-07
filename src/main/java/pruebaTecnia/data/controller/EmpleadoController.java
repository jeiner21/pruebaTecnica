package pruebaTecnia.data.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pruebaTecnia.data.model.Empleado;
import pruebaTecnia.data.model.EmpleadoResponse;
import pruebaTecnia.data.service.EmpleadoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;

    @PostMapping
    public ResponseEntity<EmpleadoResponse> crearEmpleado(
            @Valid @RequestBody Empleado empleado) {

        return ResponseEntity.ok(service.guardarEmpleado(empleado));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listar() {
        return ResponseEntity.ok(service.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerEmpleadoConInfo(id));
    }
}
