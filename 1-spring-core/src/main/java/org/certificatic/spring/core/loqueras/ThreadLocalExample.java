package org.certificatic.spring.core.loqueras;

import lombok.Data;
import lombok.SneakyThrows;

public class ThreadLocalExample {

	public static void main(String[] args) {

		final Person p = new Person();

		new Thread(new Runnable() {

			@Override
			@SneakyThrows
			public void run() {
				p.name.set("Ivan");
				Thread.sleep(2000);

				System.out.println(Thread.currentThread().getName() + " " + p.name.get());
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			@SneakyThrows
			public void run() {
				Thread.sleep(500);
				p.name.set("Pepe");

				System.out.println(Thread.currentThread().getName() + " " + p.name.get());

			}
		}).start();
	}
}

@Data
class Person {
	public ThreadLocal<String> name = new ThreadLocal<>();
}