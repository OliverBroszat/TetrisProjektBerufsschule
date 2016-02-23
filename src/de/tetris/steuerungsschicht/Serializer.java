package de.tetris.steuerungsschicht;

import java.io.Serializable;

public abstract class Serializer implements Serializable{
	public abstract void serialize(Block[][] serializeField);
	public abstract Block[][] deSerialize();
}
