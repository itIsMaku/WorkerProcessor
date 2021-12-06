package cz.maku.worker;

import cz.maku.mommons.worker.annotation.Plugin;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

@SupportedAnnotationTypes("cz.maku.mommons.worker.annotation.Plugin")
public class WorkerProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Plugin.class)) {
            if (element.getKind().equals(ElementKind.CLASS)) {
                Plugin pluginAnnotation = element.getAnnotation(Plugin.class);
                try {
                    FileObject pluginFile = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", "plugin.yml");
                    BufferedWriter writer = new BufferedWriter(pluginFile.openWriter());
                    writer.write("main: " + pluginAnnotation.main()); writer.newLine();
                    writer.write("name: " + pluginAnnotation.name());writer.newLine();
                    writer.write("version: " + pluginAnnotation.version());writer.newLine();
                    writer.write("authors: " + Arrays.toString(pluginAnnotation.authors()));writer.newLine();
                    writer.write("api-version: " + pluginAnnotation.apiVersion());writer.newLine();
                    writer.write("description: " + pluginAnnotation.description());writer.newLine();
                    writer.write("website: " + pluginAnnotation.website());writer.newLine();
                    writer.write("depend: " + Arrays.toString(pluginAnnotation.depends()));writer.newLine();
                    writer.write("softdepend: " + Arrays.toString(pluginAnnotation.softDepends()));
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }
}