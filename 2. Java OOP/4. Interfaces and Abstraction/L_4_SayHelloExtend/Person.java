package L_4_SayHelloExtend;

public interface Person {
    String getName();
    default String sayHello(){
        return "Hello";
    };
}
