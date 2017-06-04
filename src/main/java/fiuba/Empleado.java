package fiuba;

import fiuba.enums.EstadoEmpleadoEnum;

public class Empleado {

    private Double horasDisponibles;
    private EstadoEmpleadoEnum estado;
    private String ubicacion;


    public Empleado (Double horasDisponibles, String ubicacion){
        this.horasDisponibles = horasDisponibles;
        this.ubicacion = ubicacion;
        this.estado = EstadoEmpleadoEnum.ACTIVO;
    }

    public boolean tieneDisponibilidad(Double cantidadDeHoras){
        return ((this.estado == EstadoEmpleadoEnum.ACTIVO) && (horasDisponibles >= cantidadDeHoras));
    }

    public void restarHorasDisponibles(Double cantidadDeHoras){
        if (tieneDisponibilidad(cantidadDeHoras)){
            this.horasDisponibles -= cantidadDeHoras;
        }else {
            throw new EmpleadoNoDisponibleException();
        }
    }

    public Double getHorasDisponibles() {
        return horasDisponibles;
    }

    public void setHorasDisponibles(Double horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }

    public EstadoEmpleadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleadoEnum estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
