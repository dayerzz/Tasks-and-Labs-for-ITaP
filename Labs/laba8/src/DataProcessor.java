import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataProcessor {
}
// Эта аннотация предназначена для использования на методах, которые выполняют обработку данных.
// @Retention(RetentionPolicy.RUNTIME) указывает, что аннотация будет доступна во время выполнения
// программы, что позволяет использовать ее в рефлексии. @Target(ElementType.METHOD) ограничивает
// использование аннотации только методами.