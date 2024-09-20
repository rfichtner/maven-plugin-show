# Modernizer

Run the build with Java 7 
    `mvn verify`  

Change the Java Version to 8 and run again
    `mvn verify`  

Migrate from Joda-time to JSR-310
    `mvn dependency:analyze`

Slim up and lose Joda-time dependency

Change the Java Version to 11 and run again
    `mvn verify`  


