package pruebaTecnia.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String tipoDocumento;

    @NotBlank
    private String numeroDocumento;

    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private LocalDate fechaVinculacion;

    @NotBlank
    private String cargo;

    @NotNull
    private Double salario;
}