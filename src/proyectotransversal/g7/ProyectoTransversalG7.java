
package proyectotransversal.g7;

import java.time.LocalDate;
import proyectotransversal.g7.Modelo.Alumno;
import proyectotransversal.g7.Modelo.Cursada;
import proyectotransversal.g7.Modelo.Materia;


public class ProyectoTransversalG7 {

    public static void main(String[] args) {
	
	LocalDate date = LocalDate.of(2000, 11, 15);

	Alumno miAlumno = new Alumno(10, "Nicanor", "Suares", date , 42991424, true);
	System.out.println(miAlumno.toString());
	
	Materia miMateria = new Materia(3, "Programación 5", 3, true);
	System.out.println(miMateria.toString());
	
	Cursada miCurso = new Cursada(5, miMateria, miAlumno, 10);	
	System.out.println(miCurso.toString());
	
    }
    
}
