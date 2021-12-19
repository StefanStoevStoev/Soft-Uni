package L_3_SayHello;

public interface Person {
    String getName();
    default String sayHello(){
        return "Hello";
    };
}
