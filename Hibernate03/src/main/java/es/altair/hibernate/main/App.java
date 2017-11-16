package es.altair.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import es.altair.hibernate.bean.CorreoElectronico;
import es.altair.hibernate.bean.Profesor;
import es.altair.hibernate.dao.ProfesorDAO;
import es.altair.hibernate.dao.ProfesorDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
        ProfesorDAO profDAO = new ProfesorDAOImplHibernate();
        
        Profesor p = new Profesor(3300, "Juan", "JJ", "UU");
        
        Set<CorreoElectronico> correoElectronicos = new HashSet<CorreoElectronico>();
        correoElectronicos.add(new CorreoElectronico(5000, "5000@5000.es", p));
        correoElectronicos.add(new CorreoElectronico(5001, "5001@5001.es", p));
        correoElectronicos.add(new CorreoElectronico(5002, "5002@5002.es", p));
        
        p.setCorreosElectronico(correoElectronicos);
        
        profDAO.guardar(p);
    }
}
