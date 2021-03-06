package pojos;
// Generated 9/12/2016 10:49:00 PM by Hibernate Tools 4.3.1



/**
 * Personas generated by hbm2java
 */
public class Personas  implements java.io.Serializable {


     private Integer idPersona;
     private String nombre;
     private String nacionalidad;
     private String bio;
     private String frase;

    public Personas() {
    }

    public Personas(String nombre, String nacionalidad, String bio, String frase) {
       this.nombre = nombre;
       this.nacionalidad = nacionalidad;
       this.bio = bio;
       this.frase = frase;
    }

    public Personas(Integer idPersona, String nombre, String nacionalidad, String bio, String frase) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.bio = bio;
        this.frase = frase;
    }
   
    public Integer getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getBio() {
        return this.bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getFrase() {
        return this.frase;
    }
    
    public void setFrase(String frase) {
        this.frase = frase;
    }




}


