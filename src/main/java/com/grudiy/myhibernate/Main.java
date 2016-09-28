package com.grudiy.myhibernate;

import com.grudiy.myhibernate.dao.CustomerDao;
import com.grudiy.myhibernate.entity.Customer;

/**
 * Created by grudiy on 27.09.2016.
 */


public class Main {

    public static void main(String[] args) {
        Customer c3 = new Customer();
        c3.setCustomerId(3);
        c3.setCustomerName("John");
        c3.setCustomerLastName("Doe");
        c3.setCountry("Transilvania");

        System.out.println("writing user to DB...");
        CustomerDao.create(c3);

        int myId = 3;
        System.out.println("Finding customer number" + myId + " :" );
        CustomerDao.findById(myId);

        //Customer temp = findCustomerById(1);

    }
}
