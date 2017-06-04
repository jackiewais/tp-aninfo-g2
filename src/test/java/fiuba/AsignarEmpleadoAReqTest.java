package fiuba;

import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import fiuba.enums.EstadoEmpleadoEnum;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AsignarEmpleadoAReqTest {

    private Empleado empleado;
    private Requerimiento requerimiento;
    private boolean resultadoExitoso;
    private String ubicacionDefecto = "Central";
    private String solicitanteDefecto = "Juan";
    private String descripcionDefecto = "Requermiento Ejemplo";

    @Dado("^que el empleado se encuentra en estado \"(.*?)\" con \"(.*?)\" horas disponibles$")
    public void que_el_empleado_se_encuentra_en_estado_con_horas_disponibles(EstadoEmpleadoEnum estado, Double horasDisponibles) throws Throwable {
        empleado = new Empleado(horasDisponibles,ubicacionDefecto);
        empleado.setEstado(estado);
    }


    @Cuando("^cuando asigno requerimiento de \"(.*?)\" horas$")
    public void cuando_asigno_requeriminto_de_horas(Double horasRequerimiento) throws Throwable {
        requerimiento = new Requerimiento(horasRequerimiento,solicitanteDefecto,descripcionDefecto);
        resultadoExitoso = requerimiento.asignarEmpleado(empleado);
    }


    @Entonces("^las horas restantes del empleado es de \"(.*?)\" horas$")
    public void las_horas_restantes_del_empleado_es_de_horas(Double horasFinales) throws Throwable {
        assertTrue(resultadoExitoso);
        assertEquals(requerimiento.getEmpleadoAsignado(), empleado);
        assertEquals(horasFinales,empleado.getHorasDisponibles());
    }

    @Entonces("^la asignacion es rechazada y las horas se mantienen en \"(.*?)\"$")
    public void la_asignacion_es_rechazada_y_las_horas_se_mantienen(Double horasDisponibles) throws Throwable {
        assertFalse(resultadoExitoso);
        assertNull(requerimiento.getEmpleadoAsignado());
        assertEquals(horasDisponibles, empleado.getHorasDisponibles());
    }

}
