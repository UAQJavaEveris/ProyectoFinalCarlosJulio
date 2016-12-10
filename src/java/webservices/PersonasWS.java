/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import dao.PersonasDAO;
import pojos.Personas;
import java.util.List;

/**
 *
 * @author Julio
 */
@WebService(serviceName = "PersonasWS")
public class PersonasWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertar")
    public String insertar(@WebParam(name = "idPersona") int idPersona, @WebParam(name = "nombre") String nombre, @WebParam(name = "nacionalidad") String nacionalidad, @WebParam(name = "bio") String bio, @WebParam(name = "frase") String frase) {
        //TODO write your implementation code here:
        Personas p = new Personas(idPersona,nombre,nacionalidad,bio,frase);
        PersonasDAO personasDAO = new PersonasDAO();
        personasDAO.ingresarPersona(p);
        return "<p>Nueva Persona Ingresada</p>";
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscar")
    public String buscar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        PersonasDAO personasDAO = new PersonasDAO();
        return personasDAO.consultarPersona(id);
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") int id) {
        PersonasDAO personasDAO = new PersonasDAO();
        return personasDAO.deletePersona(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualiza")
    public String actualiza(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "nacio") String nacio, @WebParam(name = "bio") String bio, @WebParam(name = "frase") String frase) {
        Personas p = new Personas(id,nombre,nacio,bio,frase);
        PersonasDAO personasDAO = new PersonasDAO();
        personasDAO.updatePersona(id,p);
        return "<p>Persona Actualizada</p>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consulta")
    public List<Personas> consulta() {
        PersonasDAO personasDAO = new PersonasDAO();
        List<Personas> list = personasDAO.verPersonas();
        return list;
    }





}
