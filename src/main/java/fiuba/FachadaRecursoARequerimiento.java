package fiuba;

public class FachadaRecursoARequerimiento {

    public boolean asignarEmpleadoARequerimiento(Empleado empleado, Requerimiento requerimiento){
        try{
            empleado.restarHorasDisponibles(requerimiento.getTiempoEstimado());
            requerimiento.setEmpleadoAsignado(empleado);
            return true;
        }catch (EmpleadoNoDisponibleException e){
            return false;
        }
    }


}
