# WorkerProcessor
@Plugin annotation processor for Spigot plugins.

## Importing to your project
### Gradle
Put WorkerProcessor.jar to libs folder into your project and add these two lines into build.gradle file:
```gradle
compileOnly fileTree(include: ['*.jar'], dir: 'PATH_TO_LIBS_FOLDER')
annotationProcessor fileTree(include: ['*.jar'], dir: 'PATH_TO_LIBS_FOLDER')
```

### Maven
Put WorkerProcessor.jar to libs folder into your project and add this dependency registration into your pom.xml file:
```xml
<dependency>
  <groupId>cz.maku.mommons</groupId>
  <artifactId>WorkerProcessor</artifactId>
  <version>1.0.0</version>
  <scope>system</scope>
  <systemPath>${project.basedir}/PATH_TO_LIBS_FOLDER/WorkerProcessor.jar</systemPath>
</dependency>
```

### External jar
If you want to add WorkerProcessor.jar to your project without Gradle or Maven, steps depend on what IDE you have. Just find how to add annotation processor to your project in your IDE.

## Usage
Anyone who wrote a Minecraft plugin using BukkitAPI knows, that creating and maintaining plugin.yml is so boring and old way. With this annoation, you can forget about whole plugin.yml file :)
Just find your main class, which extends JavaPlugin, and annotate it using `@Plugin` like this:
```java
@Plugin(
    name = "TestPlugin",
    main = "cz.maku.test.TestPluginMain",
    authors = "itIsMaku"
)
```
There are many options to this annotation (* = required):
- String name *
- String description
- String main *
- String[] authors *
- String version
- String apiVersion
- String[] softDepends
- String[] depends
- String website

You might be asking yourself: "Where do I have to list my commands?!". Nowhere.
Just register the commands in onEnable with WorkerUtils class. This class is here, since the full framework is not released yet, however it will after the new year.
```java
WorkerUtils.registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command, String description, String usage, String... aliases);
WorkerUtils.registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command);
```
