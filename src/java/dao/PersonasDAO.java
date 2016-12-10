/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Julio
 */
import pojos.Personas;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
public class PersonasDAO {
    public void ingresarPersona(Personas p){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(p);
            tx.commit();
            sesion.close();
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo ingresar la persona");
        }
    }
    public String consultarPersona(int idPersona){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Personas p = (Personas)sesion.get(Personas.class, idPersona);
        sesion.close();
        if(p!=null){
            return "<p>Codigo:</p>"+p.getIdPersona()+
                    "<br><p>Nombre:</p>"+p.getNombre()+
                    "<br><p>Nacionalidad:</p>"+p.getNacionalidad()+
                    "<br><p>Biografia:</p>"+p.getBio()+
                    "<br><p>Area:</p>"+p.getFrase();
        }else{
            return "El persona no existe";
        }
    }
    public String deletePersona(int idPersona){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Personas p = (Personas)sesion.get(Personas.class, idPersona);
            sesion.delete(p);
            tx.commit();
            sesion.close();
            return "<p>Se ha eliminado a "+p.getNombre()+"</p>";
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar");
        }
    }
    public String updatePersona(int idPersona,Personas persona){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Personas p = (Personas)sesion.get(Personas.class, idPersona);
            p.setNombre(persona.getNombre());
            p.setNacionalidad(persona.getNacionalidad());
            p.setBio(persona.getBio());
            p.setFrase(persona.getFrase());
            sesion.update(p);
            tx.commit();
            sesion.close();
            return "<p>Se ha actualizado a "+p.getIdPersona()+"</p>";
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo actualizar");
        }
    }
    public List<Personas> verPersonas(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Personas");
        List<Personas> lista = query.list();
        sesion.close();
        return lista;
    }
}
