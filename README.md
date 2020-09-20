

![Database model many to many @saidmlx](https://saidmorales.com/assets/images/2020-09-20-jpa-relationships/database-one-to-one.PNG)

Script de base de datos escrito en H2

```sql
DROP TABLE IF  EXISTS USERS_TASKS;
DROP TABLE IF  EXISTS TASKS;
DROP TABLE IF  EXISTS USERS; 


CREATE TABLE USERS(ID bigint auto_increment, NAME VARCHAR(255) null);
INSERT INTO USERS (NAME) VALUES ('Melissa');
INSERT INTO USERS (NAME) VALUES ('Fernando');
 
CREATE TABLE TASKS(ID bigint auto_increment, DESCRIPTION VARCHAR(255) null, PRIORITY bigint null);
INSERT INTO TASKS (DESCRIPTION, PRIORITY) VALUES ('Wake up',1);
INSERT INTO TASKS (DESCRIPTION, PRIORITY) VALUES ('Take a shower',2);


CREATE TABLE USERS_TASKS(ID_USER bigint null, ID_TASK bigint null );
INSERT INTO USERS_TASKS (ID_USER,ID_TASK) VALUES (1,1);
INSERT INTO USERS_TASKS (ID_USER,ID_TASK) VALUES (2,1);
```

Modelo de __*User*__
```java
@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	/* aqui van los geters and seters*/
}

```

Modelo de __*Task*__
```java
@Entity
@Table(name = "TASKS")
public class Task  implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRIORITY")
	private long priority;
	
	/* aqui van los geters and seters*/
}

```

Ahora para agregar la relación hay que modificar las dos clases. 

Para __*User*__ agregamos lo siguiente.

```java
    @ManyToMany(mappedBy = "users")
	Set<Task> tasks= new HashSet<>();
```	

Para __*Task*__ agregamos lo siguiente.

```java
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "USERS_TASKS",
			joinColumns = @JoinColumn(name = "ID_TASK"),
			inverseJoinColumns = @JoinColumn(name = "ID_USER")
			)
	@JsonIgnore
	Set<User> users = new HashSet<>();
```


Aqui el resultado 


