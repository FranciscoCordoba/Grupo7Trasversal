
package proyectotransversal.g7;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectotransversal.g7.Control.AlumnoData;
import proyectotransversal.g7.Control.Conexion;
import proyectotransversal.g7.Control.MateriaData;
import proyectotransversal.g7.Modelo.Alumno;
import proyectotransversal.g7.Modelo.Cursada;
import proyectotransversal.g7.Modelo.Materia;


public class ProyectoTransversalG7 {

    public static void main(String[] args) {
	
	LocalDate date = LocalDate.of(2000, 11, 15);

	Alumno miAlumno = new Alumno("Nicanor", "Suares", date , 42991424, true);
	System.out.println(miAlumno.toString());
	
	Materia miMateria = new Materia("Programación 5", 3, true);
	System.out.println(miMateria.toString());
	
	//Cursada miCurso = new Cursada(5, miMateria, miAlumno, 10);	
	//System.out.println(miCurso.toString());
	
	Conexion con = new Conexion();
	
	MateriaData md = new MateriaData(con);
	
	//md.agregarMateria(miMateria);
	
	AlumnoData ad = new AlumnoData(con);
	
	ad.agregarAlumno(miAlumno);
	
	//System.out.println(ad.obtenerAlumnos());
	
	//System.out.println(md.obtenerMaterias());
        
        
        // Borrar materia por ID
       md.borrarMateria(9);
       
       //md.modificarMateria(miMateria);
       
       //System.out.println(ad.obtenerAlumnoXId(4));
       
//       ad.borrarAlumno(4);
       System.out.println(ad.obtenerAlumnoXId(50));
       System.out.println(md.obtenerMateriaPorID(9));
       System.out.println(md.obtenerMateriaPorNombre("Web 1"));

    }
    
}
