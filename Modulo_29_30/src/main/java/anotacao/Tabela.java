package main.java.anotacao;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface Tabela {

    String value();
}