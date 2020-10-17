# Java Advanced Features
This is the readme file for a summary of information contaiining in this directory.

- **ProducedConsumerController.java**

This contains a Producer Consumer simulation of how these two work without using 
Semaphores. Here, both the threads fill/empty the buffer and notify each other
that they are done.

This also contains a glowing example of generation of Anonymous classes. For more
reference, you can refer the [Java official documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)
and [this stackoverflow question](https://stackoverflow.com/questions/16880494/how-can-we-create-object-of-interface-in-java), 
both of which are interesting cases of how can we write a syntax which shows that 
an object of an interface is being created which actually creates an [anonymous class](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html).

This code also denotes the use of synchronized keyword, which signifies that the 
thread will not switch when it is inside this section.

wait() and notify() being used to communicate between the 2 threads.

- **[ProducerConsumerSemaphore.java](./ProducerConsumerSemaphore.java)**

Code which uses Sempahores to synchronize inter thread communication. 

- **[A Strategy for Defining Immutable Objects](./ImmutableClassCreator.java)**

Strategy for defining immutable objects in Java. String class is an immutable object. 
Referenced from the [official java docs](https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html).

- **[Enums](./SolarSystemAttendance.java)**

Create an Enum class taking an example. Implement basic methods to and their
signatures to access the values.

- Assertions

Checking for assertions are conditions of the system from which the application
or system is unrecoverable. So, we should not try to handle them or attempt
recovery.

## Contributions

Create a branch and submit your changes.  Create a PR for the changes.
Also, don't forget to add the context about the change here in README.md