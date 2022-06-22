package proyectotransversal.g7.Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectotransversal.g7.Modelo.Materia;

public class MateriaData {

    private Connection con = null;

    public MateriaData(Conexion conexion) {

	con = conexion.getConexion();

    }
    
    public boolean agregarMateria(Materia materia){
	
	boolean insert = true;
	
	String sql = "INSERT INTO materia (nombre, anio, activo)  VALUES (?, ?, ?)";
	
	try{
	
	    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    ps.setString(1, materia.getNombre());
	    ps.setInt(2, materia.getAnio());
	    ps.setBoolean(3, materia.isActivo());
	    
	    ps.executeUpdate();
	    
	    ResultSet rs = ps.getGeneratedKeys();
	    
	    if(rs.next()){
		materia.setIdMateria(rs.getInt(1));
	        //JOptionPane.showMessageDialog(null, "La materia " + materia.getNombre() + " ha sido agregada correctamente");
	    } else {
		insert = false;
		// JOptionPane.showMessageDialog(null, "Error al intentar agregar la materia");
	    }
	
	    ps.close();
	    
	}catch(SQLException ex){
	    insert = false;
	    if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
		JOptionPane.showMessageDialog(null, "Ya existe una materia con ese nombre");
	    } else {
		JOptionPane.showMessageDialog(null, "Error de sintaxis" + ex);
	    }
	}
	
	return insert;
	
    }
    
    public ArrayList<Materia> obtenerMaterias(){
	
	ArrayList<Materia> materias = new ArrayList<>();
	
	try {
	    
	    String sql = "SELECT * FROM materia WHERE activo = 1;";
	    
	    PreparedStatement ps = con.prepareStatement(sql);

    	    ResultSet resultSet = ps.executeQuery();
	    Materia materia;
	    
	    while(resultSet.next()){
		materia = new Materia();
		
		materia.setNombre(resultSet.getString("nombre"));
		materia.setAnio(resultSet.getInt("anio"));
		materia.setIdMateria(resultSet.getInt("idMateria"));
		materia.setActivo(resultSet.getBoolean("activo"));
		
		materias.add(materia);
		
	    }
	    
	    ps.close();	   	    
	    
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Error al obtener las materias");
	}
	
	return materias;
	
    }

}
