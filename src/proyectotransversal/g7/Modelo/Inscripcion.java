
package proyectotransversal.g7.Modelo;


public class Inscripcion {
    
    private int idAlumno;
    private Materia materia;
    private Alumno alumno;
    private double nota;

    public Inscripcion(int id, Materia materia, Alumno alumno, double nota) {
        this.idAlumno = id;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(Materia materia, Alumno alumno, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion() {
    }

    public int getId() {
        return idAlumno;
    }

    public void setId(int id) {
        this.idAlumno = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cursada{" + "id=" + idAlumno + ", materia=" + materia + ", alumno=" + alumno + ", nota=" + nota + '}';
    }
    
    
    
}
