**Ant doesn�t ship with any built-in idea of where source code or resources might be in a project; 
you have to supply this information.

**convention over configuration

** This will give list of artifactIds
mvn archetype:generate > output.txt

http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
http://docs.codehaus.org/display/MAVENUSER/Archetypes+List
http://books.sonatype.com/mvnex-book/reference/web-sect-creating-project.html

(1)Create java webapp project
mvn archetype:generate -DgroupId=org.akash.simpleweb -DartifactId=simple-webapp 
 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

(2)add java folder in "${basedir}/src/main/"

(3)create .classpath and .project file by
mvn eclipse:clean eclipse:eclipse

(4)add maven-compiler-plugin to pom.xml
   add maven-jetty-plugin to pom.xml
   
(5)create new package and create a servlet class


(6)Create simple java project
mvn archetype:generate -DgroupId=org.akash.mavenbook -DartifactId=simple-core -Dpackage=org.akash.mavenbook 
 -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeGroupId=org.apache.maven.archetypes 
  -DinteractiveMode=false
  
===============================================


RequestDispatcher => include() and forward()

sendRedirect()

(Q) How context path is defined?
