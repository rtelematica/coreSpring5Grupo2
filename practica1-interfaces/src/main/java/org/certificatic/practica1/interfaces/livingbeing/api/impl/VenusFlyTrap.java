package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.IBugEater;

import lombok.ToString;

@ToString(callSuper = true)
public class VenusFlyTrap extends Plant implements IBugEater {

	// Implementar
	public VenusFlyTrap() {
		this.setSubType(VenusFlyTrap.class.getSimpleName());
	}

	@Override
	public void born() {
		System.out.println("born like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	@Override
	public void grow() {
		System.out.println("grow like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	@Override
	public void breed() {
		System.out.println("breed like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	@Override
	public void die() {
		System.out.println("die like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	@Override
	public void eatBug() {
		System.out.println("eating bug like a " + this.getType() + " (" + this.getSubType() + ")");
	}
}
