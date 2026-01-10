package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

public abstract class StudentDAOImplementation implements StudentDAO {

    @Repository
    public class studentDAOImplementation implements StudentDAO {

        //Camp pentru EntityManager (va fi utilizat pentru interactiunea cu baze de date)
        private EntityManager entityManager;

        //Injectare EntityManager prin constructor (practica recomandata pentru testabilitate si modularitate)
        @Autowired
        public studentDAOImplementation(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        //Implementare metodei save pentru salvarea unui obiect Student in baza de date
        @Override
        @Transactional
        public void save(Student theStudent) {
            entityManager.persist(theStudent);
            }

        }
    }
