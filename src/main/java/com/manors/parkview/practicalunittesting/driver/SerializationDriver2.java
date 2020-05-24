package com.manors.parkview.practicalunittesting.driver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import com.manors.parkview.practicalunittesting.util.DemoSingletonSer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializationDriver2 {
    static DemoSingletonSer instanceOne = DemoSingletonSer.getInstance();
    static final Logger logger = LoggerFactory.getLogger(SerializationDriver.class);
    static ObjectInput in; 


    public static void main(String[] args) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("demoserialization.ser"))){
            // Serialize to file
            out.writeObject(instanceOne);

            // Chenge structure after serialize
            instanceOne.setNumber(30);

            // De-serialize from file
            in = new ObjectInputStream(new FileInputStream("demoserialization.ser"));
            DemoSingletonSer instanceTwo = (DemoSingletonSer) in.readObject();

            String message = String.format("InstanceOne data after serialization and modification: %d", instanceOne.getNumber());
            logger.info(message);

            message = String.format("InstanceTwo data de-serialized of intanceOne: %d", instanceTwo.getNumber());
            logger.info(message);
            
        } catch(IOException ie){
            logger.error("Error while serializing/deserializing object", ie);
        } catch(ClassNotFoundException ce){
            logger.error("Unexpected error class not found occurred", ce);
        } finally {
            if (in !=  null){
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("Unable to close ObjectInput object", e);
                }
            }
        }
    }
}