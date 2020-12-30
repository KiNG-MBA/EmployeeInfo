package Dao;

import entities.PhoneNumber;

import javax.persistence.EntityManager;

public class PhoneNumberDao extends JpaDaoImpl {
    public PhoneNumberDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<PhoneNumber> getEntityClass() {
        return PhoneNumber.class;
    }
}
