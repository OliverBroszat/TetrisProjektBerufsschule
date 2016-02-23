package de.tetris.steuerungsschicht;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicSerializer extends Serializer {

	@Override
	public void serialize(Block[][] serializeField) {
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("Serialzi.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(serializeField);
	         out.close();
	         fileOut.close();

	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

	@Override
	public Block[][] deSerialize() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Serialzi.ser")))
	      {

	         return ((Block[][]) in.readObject());
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return null;
	      }
	}

}
