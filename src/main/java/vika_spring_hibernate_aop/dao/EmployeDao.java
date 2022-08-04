package vika_spring_hibernate_aop.dao;

import vika_spring_hibernate_aop.entity.Employe;

import java.util.List;

public interface EmployeDao {
    public List<Employe>getAllEmployes();
    public void saveEmploye(Employe employe);
    public Employe getEmploye(int id);
    public void deleteEmploye(int id);
}
