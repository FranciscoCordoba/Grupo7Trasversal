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
    
    public boolean agregarMateria(Materia materia) throws SQLException{
	
	boolean insert = true;
	
	String sql = "INSERT INTO materia (nombre, anio, activo)  VALUES (?, ?, ?)";
		
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
    
    public boolean borrarMateria(int id){
        
        boolean matBorrada = false;
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ?";
        try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);

	    if (ps.executeUpdate() != 0) {

		matBorrada = true;
	    }
	    ps.close();
            
            } catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Error de sintaxis ");
	}

	return matBorrada;
        
    }
    
    public boolean modificarMateria(Materia materia){
    
	String sql = "UPDATE materia SET nombre = ?, anio = ?, activo = ? WHERE nombre = ?";
	boolean modificar = false;
	
	try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, materia.getNombre());
	    ps.setInt(2, materia.getAnio());
	    ps.setBoolean(3, materia.isActivo());
	    ps.setString(4, materia.getNombre());
	    
	    if(ps.executeUpdate() != 0){
		modificar = true;
	    }
	    
	    ps.close();
	    
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, ex);
	}
	
	return modificar;
	
    }
    
    public Materia obtenerMateriaPorID(int id){

        Materia materia = null;

        try {

        String sql = "SELECT * FROM materia WHERE idMateria = ? AND activo = 1;";

        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, id);
	
	ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()){
	
	materia = new Materia();
        materia.setNombre(resultSet.getString("nombre"));
        materia.setAnio(resultSet.getInt("anio"));
        materia.setIdMateria(resultSet.getInt("idMateria"));
        materia.setActivo(resultSet.getBoolean("activo"));

        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la materia");
    }

    return materia;

    }

    public Materia obtenerMateriaPorNombre(String nombre){

        Materia materia = null;

        try {

        String sql = "SELECT * FROM materia WHERE nombre = ? AND activo = 1;";

        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, nombre);
        
	ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()){

	materia = new Materia();
        materia.setNombre(resultSet.getString("nombre"));
        materia.setAnio(resultSet.getInt("anio"));
        materia.setIdMateria(resultSet.getInt("idMateria"));
        materia.setActivo(resultSet.getBoolean("activo"));

        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la materia");
    }

    return materia;

    }
    
}
