JFLAGS = -g
JC = javac

all:	src/Mappings.class src/Mono.class

src/Mappings.class:	src/Mappings.java
	$(JC) $(JFLAGS) src/Mappings.java

src/Mono.class:	src/Mono.java
	$(JC) $(JFLAGS) src/Mono.java

clean:	
	$(RM) src/*.class
