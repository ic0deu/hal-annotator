package i.c0d.eu.hal.annotation.processor;


import i.c0d.eu.hal.annotation.HalEmbedded;
import i.c0d.eu.hal.annotation.HalLink;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Iterator;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"i.c0d.eu.hal.annotation.HalLink", "i.c0d.eu.hal.annotation.HalEmbedded" })
public class HalAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("In Processor");
        if(annotations.size() == 0)
            return false;

        Set<? extends Element> linkElements = roundEnv.getElementsAnnotatedWith(HalLink.class);
        Set<? extends Element> embeddedElements = roundEnv.getElementsAnnotatedWith(HalEmbedded.class);

        if (linkElements.size() > 0) {
            Iterator<? extends Element> linkElementsIterator = linkElements.iterator();
            Element linkElement = null;
            if (linkElementsIterator.hasNext()) {
                linkElement = linkElementsIterator.next();
            }
            if (linkElementsIterator.hasNext()) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Too many @HalLink annotation (max=1)", linkElementsIterator.next());
                System.out.println("Too many @HalLink annotation (max=1)");
            }
            if (linkElement != null && !(linkElement.asType().toString().equals("i.c0d.eu.hal.LinkElement")
                    || linkElement.asType().toString().equals("java.util.Set<i.c0d.eu.hal.LinkElement>"))) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Invalid type for @HalLink annotation (valid types are: i.c0d.eu.hal.LinkElement or java.util.Set<i.c0d.eu.hal.LinkElement>)", linkElement);
            }
        }
        if (embeddedElements.size() > 1) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Too many @HalEmbedded annotation (max=1)", embeddedElements.iterator().next());
        }

        return false;
    }
}

