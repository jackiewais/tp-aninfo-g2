# language: es
Característica: Asignar un empleado a un requerimiento

  Escenario: Empleado con cantidad de horas suficientes como para tomar la tarea
    Dado que el empleado se encuentra en estado "ACTIVO" con "100" horas disponibles
    Cuando cuando asigno requerimiento de "25" horas
    Entonces las horas restantes del empleado es de "75" horas


  Escenario: Empleado con horas insuficientes
    Dado que el empleado se encuentra en estado "ACTIVO" con "1" horas disponibles
    Cuando cuando asigno requerimiento de "15" horas
    Entonces la asignacion es rechazada y las horas se mantienen en "1"


  Escenario: Empleado de vacaciones
    Dado que el empleado se encuentra en estado "VACACIONES" con "30" horas disponibles
    Cuando cuando asigno requerimiento de "5" horas
    Entonces la asignacion es rechazada y las horas se mantienen en "30"

    
  Escenario: Empleado inactivo
    Dado que el empleado se encuentra en estado "INACTIVO" con "30" horas disponibles
    Cuando cuando asigno requerimiento de "5" horas
    Entonces la asignacion es rechazada y las horas se mantienen en "30"
