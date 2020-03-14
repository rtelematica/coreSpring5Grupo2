package org.certificatic.spring.data.practicaI.mongodb._config;

import java.io.IOException;

import org.certificatic.spring.data.practicaI.mongodb.document.Department;
import org.certificatic.spring.data.practicaI.mongodb.document.Person;
import org.certificatic.spring.data.practicaI.mongodb.document.Staff;
import org.certificatic.spring.data.practicaI.mongodb.repositories.DepartmentRepository;
import org.certificatic.spring.data.practicaI.mongodb.repositories.StaffRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

//Clase de configuración @Configuration
@Configuration
//Component Scan de paquete base Spring data practicaI MongoDB
@ComponentScan(basePackages = "org.certificatic.spring.data.practicaI.mongodb")

//Habilitar repositorios Spring Data MongoDB
@EnableMongoRepositories(basePackages = 
			"org.certificatic.spring.data.practicaI.mongodb.repositories")

//Manejo transaccional unicamente funciona con MongoDB 4+

//Opcional Importa el recurso "classpath:/spring/data/mongodb/mongodb-application-context.xml" para 
//realizar configuracion por XML
public class SpringDataMongodbConfiguration {

	// Define Bean com.mongodb.MongoClient.MongoClient utilizando EmbeddedMongoFactoryBean (cliente MongoDB en memoria)
	@Bean
	public MongoClient mongoDbInMemoryClient() throws IOException {
		EmbeddedMongoFactoryBean embeddedMongo = new EmbeddedMongoFactoryBean();
		embeddedMongo.setBindIp("localhost");
		MongoClient mongoClient = embeddedMongo.getObject();
		return mongoClient;
	}
	
	// Opcional define Bean com.mongodb.MongoClient.MongoClient de forma tradicional en "localhost"
	@Bean
	@Profile("produccion")
	public MongoClient mongoClient() throws IOException {
		MongoClient mongoClient = new MongoClient("localhost");
		return mongoClient;
	}

	// Define Bean MongoDbFactory utilizando la clase concreta SimpleMongoDbFactory
	// MongoDbFactory no es necesario si se configura MongoTemplate mediante MongoClient
	@Bean
	public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
		return new SimpleMongoDbFactory(mongoClient, "testdb");
	}
	
	// Define Bean MongoTemplate
	@Bean
	@Profile("produccion")
	public MongoTemplate mongoTemplateProd(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "testdb");
	}
	
	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}

	// En caso de utilizar MongoDB 4+ y que el manejo transaccional esté habilitado,
	// define Bean MongoTransactionManager
	
	// Analiza los documentos MongoDB definidos

	@Bean
	@Profile("init-database")
	@DependsOn({ "staffRepository", "departmentRepository" })
	public ApplicationListener<ContextRefreshedEvent> startupBean(
			StaffRepository staffRepository,
			DepartmentRepository departmentRepository) {

		return new ApplicationListener<ContextRefreshedEvent>() {

			@SuppressWarnings("unused")
			@Override
			public void onApplicationEvent(ContextRefreshedEvent event) {

				// Staff
				Staff deanJones = staffRepository.save(createStaffJohnJones()); // almacena Staff JohnJones
				Staff deanMartin = staffRepository.save(createStaffMatthewMartin()); // almacena Staff MatthewMartin
				Staff profBrown = staffRepository.save(createStaffJamesBrown()); // almacena Staff JamesBrown
				Staff profMiller = staffRepository.save(createStaffJudyMiller()); // almacena Staff JudyMiller
				Staff profDavis = staffRepository.save(createStaffJamesDavis()); // almacena Staff JamesDavis
				Staff profMoore = staffRepository.save(createStaffAllisonMoore()); // almacena Staff AllisonMoore
				Staff profThomas = staffRepository.save(createStaffTomThomas()); // almacena Staff TomThomas
				Staff profGreen = staffRepository.save(createStaffGrahamGreen()); // almacena Staff GrahamGreen
				Staff profWhite = staffRepository.save(createStaffWhitneyWhite()); // almacena Staff WhitneyWhite
				Staff profBlack = staffRepository.save(createStaffJackBlack()); // almacena Staff JackBlack
				Staff profKing = staffRepository.save(createStaffQueenKing()); // almacena Staff QueenKing
				staffRepository.save(new Staff(12, new Person("Burger", "King")));

				// Departments
				Department humanities = departmentRepository.save(
						createDepartmentHumanities(deanJones)); // almacena Department DepartmentHumanities con deanJones como jefe de depto
				
				Department naturalSciences = departmentRepository.save(
						createDepartmentNaturalSciences(deanMartin)); // almacena Department DepartmentNaturalSciences con deanMartin como jefe de depto
				
				Department socialSciences = departmentRepository.save(
						createDepartmentSocialSciences(deanJones)); // almacena Department DepartmentSocialSciences con deanJones como jefe de depto

			}

			private Department createDepartmentSocialSciences(Staff deanJones) {
				return new Department(300, "Social Sciences", deanJones);
			}

			private Department createDepartmentNaturalSciences(Staff deanMartin) {
				return new Department(200, "Natural Sciences", deanMartin);
			}

			private Department createDepartmentHumanities(Staff deanJones) {
				return new Department(100, "Humanities", deanJones);
			}

			private Staff createStaffQueenKing() {
				return new Staff(11, new Person("Queen", "King"));
			}

			private Staff createStaffJackBlack() {
				return new Staff(10, new Person("Jack", "Black"));
			}

			private Staff createStaffWhitneyWhite() {
				return new Staff(9, new Person("Whitney", "White"));
			}

			private Staff createStaffGrahamGreen() {
				return new Staff(8, new Person("Graham", "Green"));
			}

			private Staff createStaffTomThomas() {
				return new Staff(7, new Person("Tom", "Thomas"));
			}

			private Staff createStaffAllisonMoore() {
				return new Staff(6, new Person("Allison", "Moore"));
			}

			private Staff createStaffJamesDavis() {
				return new Staff(5, new Person("James", "Davis"));
			}

			private Staff createStaffJudyMiller() {
				return new Staff(4, new Person("Judy", "Miller"));
			}

			private Staff createStaffJamesBrown() {
				return new Staff(3, new Person("James", "Brown"));
			}

			private Staff createStaffMatthewMartin() {
				return new Staff(2, new Person("Matthew", "Martin"));
			}

			private Staff createStaffJohnJones() {
				return new Staff(1, new Person("John", "Jones"));
			}
		};
	}
}
