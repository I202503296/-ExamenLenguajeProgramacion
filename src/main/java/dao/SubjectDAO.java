package dao;

import java.util.List;

import model.Subject;

public interface SubjectDAO {
	public void registrar(Subject subject );
	public void editar (Subject subject);
	public void eliminar (int id);
	public Subject find(int id);
	public List<Subject>findAll();
	
}
