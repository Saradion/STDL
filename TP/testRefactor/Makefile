EGGJAR=../../Egg/eggc-5.4.3.jar
JDIR=/usr/bin
TESTDIR=../tests
JAVAC=$(JDIR)/javac $(JOPTS)
JAVA=$(JDIR)/java
JAR=$(JDIR)/jar
JAVADOC=$(JDIR)/javadoc

all : legg compile exec

legg :
	$(JAVA) -jar $(EGGJAR) Block.egg && \
	mv egg src

compile :
	cd src/egg && \
	$(JAVAC) -classpath ../../$(EGGJAR):. *.java && \
	cd .. && \
        $(JAVAC) -classpath ../$(EGGJAR):. Main.java

exec :
	cd src && \
	$(JAVA) -classpath ../$(EGGJAR):. Main $(TESTDIR)/test1.tst

clean :
	rm src/Main.class && \
	rm -rf egg && \
	rm -rf src/egg

