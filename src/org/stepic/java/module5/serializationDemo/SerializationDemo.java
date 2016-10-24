package org.stepic.java.module5.serializationDemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Created by vitaly on 03/10/16.
 */
public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        Client originalClient = new Client();
        originalClient.setID(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(originalClient);
        }

        Client deserializedClient;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            deserializedClient = (Client) ois.readObject();
        }

        System.out.printf("%-15s %-30s\n", "ID", deserializedClient.getID());
        System.out.printf("%-15s %-30s\n", "Name", deserializedClient.getName());
        System.out.printf("%-15s %-30s\n", "Date of Birth", deserializedClient.getBirthDate());
        System.out.printf("%-15s %-30s\n", "Age", deserializedClient.getAgeInYears());
    }

    public static class Client implements Serializable {
        private long id;
        private String name;
        private LocalDate birthDate;
        private transient int ageInYears;

        public long getID() { return id; }

        public void setID(long id) { this.id = id; }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public LocalDate getBirthDate() { return birthDate; }

        public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

        public int getAgeInYears() {
            if (ageInYears == 0) {
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }

    }
}
