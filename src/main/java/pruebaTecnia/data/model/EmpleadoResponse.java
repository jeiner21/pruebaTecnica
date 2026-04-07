package pruebaTecnia.data.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoResponse {

    private Empleado empleado;
    private String edad;
    private String tiempoViEnculacion;
}
