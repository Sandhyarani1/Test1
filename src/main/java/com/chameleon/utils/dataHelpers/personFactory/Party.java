package com.chameleon.utils.dataHelpers.personFactory;

import static com.chameleon.utils.TestReporter.logTrace;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private List<Person> persons = new ArrayList<>();

    public Party(int numberOfPeople) {
        logTrace("Entering Party#init with number of People");
        logTrace("Creating party with [" + numberOfPeople + "] party");

        for (int x = 0; x < numberOfPeople; x++) {
            logTrace("Generating Person [" + (x + 1) + "]");
            addPerson(new Person());

            logTrace("Setting Person [" + (x + 1) + "] Address, Phone and Email to primary Person");
            persons.get(x).getAllAddresses().get(0).setPrimary(true);
            persons.get(x).getAllAddresses().get(0).setStreetName(persons.get(0).primaryAddress().getStreetName());
            persons.get(x).getAllAddresses().get(0).setStreetNumber(persons.get(0).primaryAddress().getStreetNumber());
            persons.get(x).getAllAddresses().get(0).setCity(persons.get(0).primaryAddress().getCity());
            persons.get(x).getAllAddresses().get(0).setState(persons.get(0).primaryAddress().getState());
            persons.get(x).getAllAddresses().get(0).setStateAbbv(persons.get(0).primaryAddress().getStateAbbv());
            persons.get(x).getAllAddresses().get(0).setZipCode(persons.get(0).primaryAddress().getZipCode());
            persons.get(x).getAllPhones().get(0).setPrimary(true);
            persons.get(x).getAllEmails().get(0).setPrimary(true);
            logTrace("\n" + persons.get(x).toString().replace("<br/>", "\n"));
        }

        logTrace("Set first Person as Primary Person");
        persons.get(0).setPrimary(true);
        logTrace("Ensure first Person is older than 18");
        if (persons.get(0).getAge() <= 18) {
            persons.get(0).setAge(45);
            persons.get(0).setBirthDate("1970-01-14");
        }
        logTrace("Entering Party#init with number of Persons");
    }

    /**
     * Associate a new Person to the person using preset data
     *
     * @author Justin Phlegar
     * @version 11/28/2015 Justin Phlegar - original
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /**
     * Return the person marked as Primary
     *
     * @author Justin Phlegar
     * @version 11/28/2015 Justin Phlegar - original
     * @return the Party primary Person
     */
    public Person primaryPerson() {
        Person primaryPerson = null;

        for (Person person : persons) {
            if (person.isPrimary()) {
                primaryPerson = person;
            }
        }

        return primaryPerson;
    }

    /**
     * Return all People associated to the Party
     *
     * @author Justin Phlegar
     * @version 11/28/2015 Justin Phlegar - original
     * @return all People as an ArrayList
     */
    public List<Person> getAllPersons() {
        return persons;
    }

    /**
     * Return the number of Children currently in Party
     *
     * @author Justin Phlegar
     * @version 11/28/2015 Justin Phlegar - original
     * @return the number of children in Party
     */
    public int numberOfChildren() {
        int numberOfChildren = 0;
        for (Person person : persons) {
            if (person.isChild() && Integer.valueOf(person.getAge()) > 2
                    && Integer.valueOf(person.getAge()) < 18) {
                numberOfChildren++;
            }
        }
        return numberOfChildren;
    }

    public int numberOfInfants() {
        int numberOfInfant = 0;
        for (Person person : persons) {
            if (person.isChild() && Integer.valueOf(person.getAge()) <= 2) {
                numberOfInfant++;
            }
        }
        return numberOfInfant;
    }

    /**
     * Return the number of adults currently in Party
     *
     * @author Justin Phlegar
     * @version 11/28/2015 Justin Phlegar - original
     * @return the number of adults in Party
     */
    public int numberOfAdults() {
        int numberOfAdults = 0;
        for (Person person : persons) {
            if (!person.isChild()) {
                numberOfAdults++;
            }
        }
        return numberOfAdults;
    }

}
