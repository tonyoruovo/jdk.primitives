# jdk.primitives

**jdk.primitives** is a Java library that provides primitive alternatives for generic-based types such as collections, functions, concurrent types, atomic types, streams, and more. This project aims to reduce the performance overhead caused by autoboxing and unboxing by offering specialized implementations for primitive data types.

## Features

- **Primitive Collections**: Alternatives to `java.util.Collection` and its subtypes for primitive types.
- **Primitive Streams**: Specialized streams for primitive types, reducing the need for boxing.
- **Enhanced Functional Interfaces**: Extensions of `java.util.function` for primitive types, including `PrimitiveFunction`, `PrimitivePredicate`, `PrimitiveConsumer`, and more.
- **Concurrent Utilities**: Primitive-based concurrent collections and utilities inspired by `java.util.concurrent`.
- **Atomic Types**: Primitive-based atomic types for thread-safe operations.
- **Sorting Utilities**: Array sorting utilities tailored for primitive types.
- **Support for All Primitives**: Includes support for `double`, `long`, `int`, `float`, `char`, `short`, `byte`, and `boolean`.

## Getting Started

### Prerequisites

- **Java 22** or higher is required to use this library.
- **Maven** is used for building and managing dependencies.

### Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>prim.base</groupId>
    <artifactId>jdk.primitives</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Building the Project

To build the project, run the following command:

```bash
mvn clean install
```

### Running the Project

To verify the project, use the provided batch script:

```bash
verify-project.bat
```

This script performs the following steps:
1. Cleans the project.
2. Compiles the source code.
3. Packages the project into a JAR file.
4. Runs the main class (`prim.Main`).
5. Executes unit tests.

## Usage

### Primitive Collections

The library provides specialized collections for primitive types. For example:

```java
PrimitiveCollection.OfInt intCollection = new PrimitiveCollection.OfInt();
intCollection.add(10);
intCollection.add(20);
System.out.println(intCollection.size()); // Output: 2
```

### Primitive Streams

Work with primitive streams to avoid boxing overhead:

```java
PrimitiveStream.OfDouble doubleStream = PrimitiveStream.of(1.1, 2.2, 3.3);
doubleStream.forEach(System.out::println);
```

### Functional Interfaces

Use enhanced functional interfaces for primitive types:

```java
PrimitivePredicate.OfInt isEven = value -> value % 2 == 0;
System.out.println(isEven.test(4)); // Output: true
```

## Project Structure

```
jdk.primitives/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── jdk/
│   │   │   │   ├── prim/
│   │   │   │   ├── util/
│   │   │   │   ├── util/concurrent/
│   │   │   │   ├── util/function/
│   │   │   │   ├── util/map/
│   │   │   │   ├── util/sort/
│   │   │   │   ├── util/stream/
│   │   │   │   ├── internal/
│   │   │   │   └── module-info.java
├── pom.xml
├── verify-project.bat
└── .gitignore
```

## Documentation

### Module Overview

The `jdk.primitives` module provides primitive alternatives for the following Java packages:

- **`java.lang`**: Includes alternatives for `Iterable`, `ThreadLocal`, and more.
- **`java.util`**: Includes alternatives for `Collection`, `Map`, `Iterator`, `Optional`, and more.
- **`java.util.concurrent`**: Includes alternatives for concurrent collections and utilities.
- **`java.util.concurrent.atomic`**: Includes alternatives for atomic types.
- **`java.util.function`**: Includes enhanced functional interfaces for primitive types.
- **`java.util.stream`**: Includes specialized streams and collectors for primitive types.

For more details, refer to the [module-info.java](src/main/java/module-info.java) file.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

## Author

- **Oruovo E. Anthony**  
  - Email: [tonyoruovo@gmail.com](mailto:tonyoruovo@gmail.com)  
  - GitHub: [tonyoruovo](https://github.com/tonyoruovo)

## Acknowledgments

- Inspired by the need to optimize Java applications by reducing the overhead of autoboxing and unboxing.
- Special thanks to the Java community for their contributions and feedback.

---
For more information, visit the [GitHub repository](https://github.com/tonyoruovo/jdk.primitives).
