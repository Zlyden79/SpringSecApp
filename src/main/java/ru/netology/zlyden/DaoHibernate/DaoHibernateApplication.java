package ru.netology.zlyden.DaoHibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.zlyden.DaoHibernate.domain.Human;
import ru.netology.zlyden.DaoHibernate.domain.Person;

@SpringBootApplication
public class DaoHibernateApplication {

   	public static void main(String[] args) {
        DaoHibernateApplication dha = new DaoHibernateApplication();
        SpringApplication.run(DaoHibernateApplication.class, args);
    }

}
