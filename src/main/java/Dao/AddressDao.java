package Dao;

import entities.Address;

import javax.persistence.EntityManager;

public class AddressDao extends JpaDaoImpl {
    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
