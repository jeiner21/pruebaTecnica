package pruebaTecnia.data.service;

import lombok.RequiredArgsConstructor;
import pruebaTecnia.data.model.Empleado;
import pruebaTecnia.data.model.EmpleadoResponse;
import pruebaTecnia.data.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository repository;

    // GUARDAR EMPLEADO
    public EmpleadoResponse guardarEmpleado(Empleado empleado) {

        // Validar mayor de edad
        Period edad = Period.between(empleado.getFechaNacimiento(), LocalDate.now());

        if (edad.getYears() < 18) {
            throw new RuntimeException("El empleado debe ser mayor de edad");
        }

        // Guardar en BD
        Empleado saved = repository.save(empleado);

        return construirRespuesta(saved);
    }

    // LISTAR
    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }

    // OBTENER POR ID
    public EmpleadoResponse obtenerEmpleadoConInfo(Long id) {

        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        return construirRespuesta(empleado);
    }

    private EmpleadoResponse construirRespuesta(Empleado empleado) {

        Period edad = Period.between(empleado.getFechaNacimiento(), LocalDate.now());

        String edadTexto = edad.getYears() + " años, "
                + edad.getMonths() + " meses, "
                + edad.getDays() + " días";

        Period vinculacion = Period.between(empleado.getFechaVinculacion(), LocalDate.now());

        String tiempoTexto = vinculacion.getYears() + " años, "
                + vinculacion.getMonths() + " meses";

        return new EmpleadoResponse(empleado, edadTexto, tiempoTexto);
    }
}