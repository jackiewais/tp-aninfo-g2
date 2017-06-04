package fiuba;

import fiuba.enums.UrgenciaEnum;

import java.util.Date;

public class Requerimiento {

    private Long id;
    private Integer porcentaje;
    private Date fechaCreacion;
    private Double tiempoEstimado; //En horas
    private String solicitante;
    private UrgenciaEnum urgencia;
    private String descripción;
    private Empleado empleadoAsignado;

    private static Long numeracionId = 1L; //Usado para asignar Ids

    public Requerimiento(Double tiempoEstimado, String solicitante, String descripción){
        this.id = ++numeracionId;
        this.porcentaje = 0;
        this.fechaCreacion = new Date();
        this.tiempoEstimado = tiempoEstimado;
        this.solicitante = solicitante;
        this.urgencia = UrgenciaEnum.URG_MEDIA; //por defecto todos se crean con urgencia media
        this.descripción = descripción;
    }

    public boolean asignarEmpleado(Empleado empleado){
        try{
            empleado.restarHorasDisponibles(tiempoEstimado);
            this.empleadoAsignado = empleado;
            return true;
        }catch (EmpleadoNoDisponibleException e){
            return false;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Double tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public UrgenciaEnum getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(UrgenciaEnum urgencia) {
        this.urgencia = urgencia;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public void setEmpleadoAsignado(Empleado empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
    }

}
