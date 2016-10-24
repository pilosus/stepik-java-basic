package org.stepic.java.module5.animalSerialization;

import java.io.Serializable;
import java.io.*;
import java.util.Objects;

/**
 * Created by vitaly on 03/10/16.
 */
public class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public static byte[] mergeArrays(byte[] array1, byte[] array2) {
        byte[] result = new byte[array1.length + array2.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i < array1.length ? array1[i] : array2[i - array1.length];
        }
        return result;
    }

    public static byte[] serializeSize(int size) throws IOException {
        try (ByteArrayOutputStream oos = new ByteArrayOutputStream()) {
            oos.write(size);
            return oos.toByteArray();
        }
    }

    public static byte[] serializeAnimal(Animal animal) throws IOException {
        try(ByteArrayOutputStream b = new ByteArrayOutputStream()){
            try(ObjectOutputStream o = new ObjectOutputStream(b)){
                o.writeObject(animal);
            }
            return b.toByteArray();
        }
    }

    public static byte[] serializeAnimalArray(Animal[] animals) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (Animal animal: animals) {
            for (byte b : serializeAnimal(animal)) {
                os.write(b);
            }
        }
        return os.toByteArray();
    }

    /**
     * Serialize an array of Animal objects
     * @url http://stackoverflow.com/a/2836659/4241180
     * @param size - size of the objects array
     * @param animals - array of Animal objects of the length <code>size</code>
     * @return byte array
     */
    public static byte[] serializeAnimalObjects(int size, Animal[] animals)
        throws IOException {

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                oos.writeInt(size);
                for (Animal animal: animals) {
                    oos.writeObject(animal);
                }
                oos.flush();
            }
            return bos.toByteArray();
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int deserializedSize = (int) ois.readInt();
            Animal[] animals = new Animal[deserializedSize];
            for (int i = 0; i < deserializedSize; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        }
        catch (IOException | ClassNotFoundException | ClassCastException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
