package pruebas;

import java.util.List;



import dao.SubjectDAO;
import dao.SubjectDAOImplement;
import model.Subject;



public class PruebaSubject {
	public static void main(String[] args) {
		SubjectDAO subject= new SubjectDAOImplement();
		List<Subject>lista = subject.findAll();
		for(Subject e:lista) {
			System.out.println(e.getIdsubject());
			System.out.println(e.getSubjectName());
			System.out.println(e.getCredits());
		}
	}
}
