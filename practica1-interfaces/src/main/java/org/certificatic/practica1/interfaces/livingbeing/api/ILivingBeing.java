package org.certificatic.practica1.interfaces.livingbeing.api;

public interface ILivingBeing {

	void born();

	void grow();

	abstract void breed();

	abstract void die();

	default void lifeCycle() {
		born();

		grow();

		breed();

		die();
	}

}
