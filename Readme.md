To run:

```bash
mvn clean install
mvn spring-boot run
```



The bug is in 

`src/main/java/com/example/webpos/biz/PosServiceImp.java`

You can test it by removing the comments from the method `init()`.