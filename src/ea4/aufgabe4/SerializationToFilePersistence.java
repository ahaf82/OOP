package ea4.aufgabe4;

import java.io.*;

interface AddressBook extends Serializable {
    void addPerson(Person person);

    void print();
}

class Person implements Serializable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ArrayListAddressBook implements AddressBook {
    private java.util.ArrayList<Person> persons;

    public ArrayListAddressBook(int initialCapacity) {
        initialCapacity = initialCapacity < 1 ? 1 : initialCapacity;
        persons = new java.util.ArrayList<Person>(initialCapacity);
    }

    @Override
    public void addPerson(Person person) {
        persons.add((Person) person);
    }

    @Override
    public void print() {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}

interface FullPersistence {
    AddressBook loadBook(String name) throws AddressBookException;

    void storeBook(AddressBook book, String name) throws AddressBookException;
}

class AddressBookException extends Exception {
    AddressBookException(String message) {
        super(message);
    }
}

class SerializationToFilePersistence implements FullPersistence {
    private final String path = System.getProperty("user.home") + "/Neu/";

    private String getFullName(String name) {
        return path + name;
    }

    @Override
    public AddressBook loadBook(String name) throws AddressBookException {
        try {
            InputStream is = new FileInputStream(getFullName(name));
            ObjectInputStream ois = new ObjectInputStream(is);
            AddressBook adressAusgabe = (AddressBook) ois.readObject();
            ois.close();
            return adressAusgabe;
        } catch (IOException | ClassNotFoundException e) {
            throw new AddressBookException(e.getMessage());
        }
    }

    @Override
    public void storeBook(AddressBook book, String name) throws AddressBookException {
        try {
            File directory = new File(path);
            if (directory.mkdir()) {
                System.out.println("Directory created...");
            }
            OutputStream os = new FileOutputStream(getFullName(name));
            ObjectOutputStream oos = new ObjectOutputStream((os));
            oos.writeObject(book);
            oos.close();
        } catch (IOException e) {
            throw new AddressBookException(e.getMessage());
        }
    }
}

class TestAddressBook {
    public static void main(String[] args){

        ArrayListAddressBook Liste = new ArrayListAddressBook(5);
        SerializationToFilePersistence TestBook = new SerializationToFilePersistence();

        Liste.addPerson(new Person("Armin"));
        Liste.addPerson(new Person("Sepp"));
        Liste.addPerson(new Person("Test"));

        try {
            TestBook.storeBook(Liste, "Adressen");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        try {
            AddressBook addressAusgabe = TestBook.loadBook("Adressen");
            addressAusgabe.print();
        } catch (AddressBookException e) {
            e.printStackTrace();
        }

    }
}
