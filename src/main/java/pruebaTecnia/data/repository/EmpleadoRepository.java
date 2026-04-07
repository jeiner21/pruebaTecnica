package pruebaTecnia.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebaTecnia.data.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}