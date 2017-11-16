package es.altair.hibernate.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.altair.hibernate.bean.CorreoElectronico;
import es.altair.hibernate.bean.Profesor;
import es.altair.hibernate.dao.ProfesorDAO;
import es.altair.hibernate.dao.ProfesorDAOImplHibernate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ProfesorDAO profDAO = new ProfesorDAOImplHibernate();
        
        Profesor p = new Profesor(4300, "Pepe", "pp", "EE");
        
        List<CorreoElectronico> correoElectronicos = new ArrayList<CorreoElectronico>();
        correoElectronicos.add(new CorreoElectronico(6001, "6001@6001.es", p));
        correoElectronicos.add(new CorreoElectronico(6000, "6000@6000.es", p));
        correoElectronicos.add(new CorreoElectronico(6002, "6002@6002.es", p));
        
        p.setCorreosElectronico(correoElectronicos);
        
        profDAO.guardar(p);
    }
}
