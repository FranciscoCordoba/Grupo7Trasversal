
package proyectotransversal.g7;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectotransversal.g7.Control.AlumnoData;
import proyectotransversal.g7.Control.Conexion;
import proyectotransversal.g7.Control.InscripcionData;
import proyectotransversal.g7.Control.MateriaData;
import proyectotransversal.g7.Modelo.Alumno;
import proyectotransversal.g7.Modelo.Inscripcion;
import proyectotransversal.g7.Modelo.Materia;


public class ProyectoTransversalG7 {

    public static void main(String[] args) {
	
	LocalDate date = LocalDate.of(2000, 11, 15);

	Alumno miAlumno = new Alumno(4, "Nicanor", "Suares", date , 42991424, true);
	System.out.println(miAlumno.toString());
	
	Materia miMateria = new Materia(9, "Programación 5", 3, true);
	System.out.println(miMateria.toString());

	Conexion con = new Conexion();
	
	MateriaData md = new MateriaData(con);
	
	AlumnoData ad = new AlumnoData(con);
       
        InscripcionData id = new InscripcionData(con);
       
        //id.guardarInscripcion(ins);
       
        System.out.println(id.obtenerInscripciones());

        id.actualizarNota(miAlumno, miMateria, 9);
    
    }
    
}
