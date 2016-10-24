package org.stepic.java.module5.animalSerialization;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vitaly on 03/10/16.
 */
public class AnimalTest {
    @Test
    public void deserializeAnimalArray() throws Exception {
        Animal[] inputAnimals = new Animal[3];
        inputAnimals[0] = new Animal("Dog");
        inputAnimals[1] = new Animal("Cat");
        inputAnimals[2] = new Animal("Cow");

        Animal[] deserializedAnimals = Animal.deserializeAnimalArray(
                Animal.serializeAnimalObjects(inputAnimals.length, inputAnimals));

        for (int i = 0; i < deserializedAnimals.length; i++) {
            assertEquals(deserializedAnimals[i], inputAnimals[i]);
        }
    }

}