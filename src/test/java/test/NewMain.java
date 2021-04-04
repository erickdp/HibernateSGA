package test;

import java.util.List;
import mx.gm.dao.AlumnoDAO;
import mx.gm.dao.ContactoDAO;
import mx.gm.dao.CursoDAO;
import mx.gm.domain.Alumno;
import mx.gm.domain.Contacto;
import mx.gm.domain.Domicilio;

public class NewMain {

    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        CursoDAO cursoDao = new CursoDAO();
        ContactoDAO contactoDAO = new ContactoDAO();
        List<?> objetos = alumnoDao.listar();

        System.out.println("-----------------------Lista de Alumnos Actual: ");
        for (Object alumno : objetos) {
            System.out.println(alumno);
        }
        System.out.println("------------------------------------------------");

        System.out.println("-----------------------Lista de Cursos Actual: ");
        objetos = cursoDao.listar();
        for (Object curso : objetos) {
            System.out.println(curso);
        }
        System.out.println("------------------------------------------------");

        System.out.println("-----------------------Buscar el alumno con mail e@mail.com ");
        Contacto contactoBuscar = new Contacto();
        contactoBuscar.setEmail("e@mail.com");

        Alumno alumnoBuscar = contactoDAO.buscarAlumnoPorEmail(contactoBuscar);

        System.out.println(alumnoBuscar);
        System.out.println("------------------------------------------------");

//        System.out.println("Persistir un Alumno en la BBDD-------");
//        Alumno alumnoPersistir = persistirObjeto();
//        alumnoDao.insertar(alumnoPersistir);
//        System.out.println("-----------------------------------------");

//        System.out.println("-----------------------Lista de Alumnos Actual: ");
//        objetos = alumnoDao.listar();
//        for (Object alumno : objetos) {
//            System.out.println(alumno);
//        }
//        System.out.println("------------------------------------------------");

    }

    public static Alumno persistirObjeto() {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Palmeras");
        domicilio.setNoCalle("25-5toD");
        domicilio.setPais("Colombia");

        Contacto contacto = new Contacto();
        contacto.setEmail("r@mail.com");
        contacto.setTelefono("1234567893");

        Alumno alumno = new Alumno();
        alumno.setNombre("Robert");
        alumno.setApellido("Tapia");

        alumno.setContacto(contacto);
        alumno.setDomicilio(domicilio);

        return alumno;
    }

}
