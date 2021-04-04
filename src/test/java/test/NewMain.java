package test;

import mx.gm.dao.AlumnoDAO;

public class NewMain {

    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        alumnoDao.listar();
    }
    
}
