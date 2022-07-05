/*
    InscripcionData
 */
package proyectotransversal.g7.Control;

import proyectotransversal.g7.Modelo.Alumno;
import proyectotransversal.g7.Modelo.Inscripcion;
import proyectotransversal.g7.Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class InscripcionData {
    
     private Connection con = null;
    
    private AlumnoData alumData;
    private MateriaData materiaData;

    public InscripcionData(Conexion conexion) {
       
            this.con = conexion.getConexion();
            this.alumData=new AlumnoData(conexion);
            this.materiaData=new MateriaData(conexion);
            
        
    }
    
    public boolean  guardarInscripcion(Inscripcion inscripcion) {
        boolean insc=false;
        try {
            String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES ( ? , ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setId(rs.getInt("idInscripcion"));
               // JOptionPane.showMessageDialog(null, "Se inscribió al alumno correctamente");
               insc=true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar Inscripción");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El alumno ya está inscripto en esta materia " + ex.getMessage());
        }
        return insc;
    }
    
    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList();
        try {
            String sql = "SELECT * FROM inscripcion;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
            Inscripcion inscripcion;
            while (resultSet.next()) {
                inscripcion = new Inscripcion();
                inscripcion.setId(resultSet.getInt("idInscripcion"));

                Alumno a = alumData.obtenerAlumnoXId(resultSet.getInt("idAlumno"));
                inscripcion.setAlumno(a);

                Materia m = materiaData.obtenerMateriaPorID(resultSet.getInt("idMateria"));
                inscripcion.setMateria(m);

                inscripcion.setNota(resultSet.getDouble("nota"));

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }

    public boolean actualizarNota(Alumno alu,Materia mat, double nota){
    boolean insc=false;
        try {
            String sql = "update inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, alu.getIdAlumno());
            ps.setDouble(3, mat.getIdMateria());

            if (ps.executeUpdate() != 0) {
		insc = true;
	    }
            
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar materia" + ex.getMessage());
        }
        return insc;
    }
    
    public List<Alumno> alumnosDeXMateria(Materia mat) {
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            String sql = "SELECT idAlumno FROM inscripcion WHERE idMateria = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mat.getIdMateria());
            
            ResultSet resultSet = ps.executeQuery();
            Alumno alumno;
            while (resultSet.next()) {
                if(mat.isActivo()){
                    alumno = new Alumno();

                    alumno = alumData.obtenerAlumnoXId(resultSet.getInt("idAlumno"));

                    alumnos.add(alumno);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los alumnos de la materia: " + ex.getMessage());
        }

        return alumnos;
    }

    public ArrayList<Materia> obtenerMateriaXAlumno(Alumno alumno){
    
    ArrayList<Materia> materias = new ArrayList();
    
        try {
	    
            String sql = "SELECT idMateria FROM inscripcion WHERE idAlumno = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, alumno.getIdAlumno());
            
            ResultSet resultSet = ps.executeQuery();
            Materia materia;
	    
            while (resultSet.next()) {
                if(alumno.isActivo()){
                    materia = new Materia();
                    materia = materiaData.obtenerMateriaPorID(resultSet.getInt("idMateria"));
                    materias.add(materia);		    
                }
            }
	    
            ps.close();
	    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las materias a través del alumno ingresado: " + ex.getMessage());
        }

        return materias;  
    
}
    
    public List<Materia> matNoInscriptas(int id){
        
        ArrayList <Materia> materias = new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            Materia materia;
            
            while (rs.next()) {  
                
                materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setActivo(rs.getBoolean("activo"));
                
                materias.add(materia);
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al mostrar materias " + ex);
        }
        
        return materias;
    
    }
    
    public boolean borrarInscripcionDeUnAlumno(int idAlumno, int idMateria){
        boolean insc= false;
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno=? and idMateria = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ps.setInt(2,idMateria);
           
             if (ps.executeUpdate() != 0) {
		insc = true;
	    }
            ps.close();

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se pudo borrar la inscripcion " + ex.getMessage());
        }
        return insc;
    }
    
}
