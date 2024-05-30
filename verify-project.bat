@REM Verify the project's main class and test sources
mvn -q clean & mvn -q compile & mvn -q package & java -cp target\jdk.primitives-1.0-SNAPSHOT.jar prim.App & mvn test -Dtest=AppTest
@REM The snippet below was for a standalone test
java -jar "C:\Users\ZBOOK 14U G6\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.11.0-M2\junit-jupiter-api-5.11.0-M2.jar" --class-path target --select-class prim.test.AppTest
@REM 25/169
@REM 0.555E-3
@REM 1024/255
@REM 5-6
