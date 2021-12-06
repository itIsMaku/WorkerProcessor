# WorkerProcessor
@Plugin annotation processor for Spigot plugins

## Importing to your project
### Gradle
Put WorkerProcessor.jar to libs folder into your project and add to build.gradle these two lines:
```gradle
compileOnly fileTree(include: ['*.jar'], dir: 'PATH_TO_LIBS_FOLDER')
annotationProcessor fileTree(include: ['*.jar'], dir: 'PATH_TO_LIBS_FOLDER')
```

### Maven
Put WorkerProcessor.jar to libs folder into your project and add 
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
If you want add WorkerProcessor.jar to your project without Gradle or Maven, steps depends on what IDE do you have. Just find how to add Annotation Processor to your project in your IDE.

## Usage
Everybody who wrote any plugin in BukkitAPI knows, that plugin.yml creating is so boring and old. With this annoation, you can forget plugin.yml file. :)
Just find your main class what extends JavaPlugin and annotated it with @Plugin like this:
```java
@Plugin(
        name = "TestPlugin",
        main = "cz.maku.test.TestPluginMain",
        authors = "itIsMaku"
)
```
There is many options in this annotation (* = required):
- String name *
- String description
- String main *
- String[] authors *
- String version
- String apiVersion
- String[] softDepends
- String[] depends
- String website

Maybe you ask.. where i need to write commands!? Nowhere.
Just register commands in onEnable with WorkerUtils class. There is this class, because full framework is not released yet, but will be on new year.
```java
WorkerUtils.registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command, String description, String usage, String... aliases);
WorkerUtils.registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command);
```
