import Dao.AddressDao;
import Dao.EmployeeDao;
import Dao.PhoneNumberDao;
import com.github.javafaker.Faker;
import entities.Address;
import entities.Employee;
import entities.PhoneNumber;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

public class App {
    private static EmployeeDao employeeDao;
    private static AddressDao addressDao;
    private static PhoneNumberDao phoneNumberDao;

    public static void main(String[] args) {
        Faker faker = new Faker();

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        initialDao(entityManager);

        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setMobNumber(faker.number().randomNumber());
        phoneNumber1.setTelNumber(faker.number().randomNumber());

        PhoneNumber phoneNumber2 = new PhoneNumber();
        phoneNumber2.setMobNumber(faker.number().randomNumber());
        phoneNumber2.setTelNumber(faker.number().randomNumber());

        PhoneNumber phoneNumber3 = new PhoneNumber();
        phoneNumber3.setMobNumber(faker.number().randomNumber());
        phoneNumber3.setTelNumber(faker.number().randomNumber());

        PhoneNumber phoneNumber4 = new PhoneNumber();
        phoneNumber4.setMobNumber(faker.number().randomNumber());
        phoneNumber4.setTelNumber(faker.number().randomNumber());

        PhoneNumber phoneNumber5 = new PhoneNumber();
        phoneNumber5.setMobNumber(faker.number().randomNumber());
        phoneNumber5.setTelNumber(faker.number().randomNumber());

        PhoneNumber phoneNumber6 = new PhoneNumber();
        phoneNumber6.setMobNumber(faker.number().randomNumber());
        phoneNumber6.setTelNumber(faker.number().randomNumber());

        phoneNumberDao.save(phoneNumber1);
        phoneNumberDao.save(phoneNumber2);
        phoneNumberDao.save(phoneNumber3);
        phoneNumberDao.save(phoneNumber4);
        phoneNumberDao.save(phoneNumber5);
        phoneNumberDao.save(phoneNumber6);

        Set<PhoneNumber> phoneNumberList1 = new HashSet<>();
        phoneNumberList1.add(phoneNumber1);
        phoneNumberList1.add(phoneNumber2);


        Address address1 = new Address();
        address1.setCity(faker.address().city());
        address1.setPostalCode(faker.number().numberBetween(1000000000L,9999999999L));
        address1.setPostalAddress(faker.address().fullAddress());
        address1.setPhoneNumbers(phoneNumberList1);

        Set<PhoneNumber> phoneNumberList2 = new HashSet<>();
        phoneNumberList2.add(phoneNumber3);
        phoneNumberList2.add(phoneNumber4);

        Address address2 = new Address();
        address2.setCity(faker.address().city());
        address2.setPostalCode(faker.number().numberBetween(1000000000L,9999999999L));
        address2.setPostalAddress(faker.address().fullAddress());
        address2.setPhoneNumbers(phoneNumberList2);

        Set<PhoneNumber> phoneNumberList3 = new HashSet<>();
        phoneNumberList3.add(phoneNumber5);
        phoneNumberList3.add(phoneNumber6);

        Address address3 = new Address();
        address3.setCity(faker.address().city());
        address3.setPostalCode(faker.number().numberBetween(1000000000L,9999999999L));
        address3.setPostalAddress(faker.address().fullAddress());
        address3.setPhoneNumbers(phoneNumberList3);

        Set<Address> addressList1 = new HashSet<>();
        addressList1.add(address1);
        addressList1.add(address2);

        Employee employee1 = new Employee();
        employee1.setFullName(faker.name().fullName());
        employee1.setEmpCode(faker.number().randomNumber());
        employee1.setSalary(314.69);
        employee1.setAddresses(addressList1);

        Set<Address> addressList2 = new HashSet<>();
        addressList2.add(address3);

        Employee employee2 = new Employee();
        employee2.setFullName(faker.name().fullName());
        employee2.setEmpCode(faker.number().randomNumber());
        employee2.setSalary(302.32);
        employee2.setAddresses(addressList2);

        address1.setEmployee(employee1);
        address2.setEmployee(employee1);
        address3.setEmployee(employee2);


        addressDao.save(address1);
        addressDao.save(address2);
        addressDao.save(address3);

        employeeDao.save(employee1);
        employeeDao.save(employee2);


//        employeeDao.remove(employeeDao.loadById(1L));


        //query
        Query maxSalary=entityManager.createQuery("select max(salary) from Employee");
        System.out.println(maxSalary.getSingleResult());



        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();

    }

    public static void initialDao(EntityManager entityManager){
        employeeDao = new EmployeeDao(entityManager);
        addressDao = new AddressDao(entityManager);
        phoneNumberDao = new PhoneNumberDao(entityManager);
    }
}
