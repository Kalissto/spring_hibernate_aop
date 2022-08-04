package vika_spring_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vika_spring_hibernate_aop.entity.Employe;

import java.util.List;
@Repository
public class EmployeDaoImpl implements EmployeDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Employe> getAllEmployes() {
        Session session=sessionFactory.getCurrentSession();
List<Employe> allUsers =session.createQuery(" from Employe ", Employe.class).getResultList();//получение списка работников через hibernate(имя класса(сущности Employe))
        //можно по другому->
      //  Query<Users> query=session.createQuery("from Employe ",Employe.class);
       // List<Users> allEmployes=query.getResultList();
        return allUsers;
    }

    @Override
    public void saveEmploye(Employe employe) {
Session session=sessionFactory.getCurrentSession();
session.saveOrUpdate(employe);
    }

    @Override
    public Employe getEmploye(int id) {
        Session session=sessionFactory.getCurrentSession();
        Employe employe =session.get(Employe.class,id);
        return employe;
    }

    @Override
    public void deleteEmploye(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Employe>query=session.createQuery("delete from Employe "
                +"where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();//вызываем этот метод для делит
    }

}
