#!/bin/bash
directory=${PWD}

"$directory/jdk-13.0.2/bin/java" --module-path "$directory/javafx-sdk-11.0.2/lib/" --add-modules javafx.controls,javafx.fxml --add-modules javafx.base,javafx.graphics --add-reads javafx.base=ALL-UNNAMED --add-reads javafx.graphics=ALL-UNNAMED -Djava.library.path="$directory/javafx-sdk-11.0.2/lib -javaagent:$directory/idea-IC-193.5662.53/lib/idea_rt.jar=39843:/home/nsc/idea-IC-193.5662.53/bin/usr/lib/jvm/usr/lib/jvm -Dfile.encoding=UTF-8" -classpath "$directory/NSC Calculator/out/production/NSC Calculator v.1.3/at/nsc:$directory/javafx-sdk-11.0.2/lib/src.zip:$directory/javafx-sdk-11.0.2/lib/javafx-swt.jar:$directory/javafx-sdk-11.0.2/lib/javafx.web.jar:/usr/lib/jvm/javafx-sdk-11.0.2/lib/javafx.base.jar:$directory/javafx-sdk-11.0.2/lib/javafx.fxml.jar:$directory/javafx-sdk-11.0.2/lib/javafx.media.jar:$directory/javafx-sdk-11.0.2/lib/javafx.swing.jar:$directory/javafx-sdk-11.0.2/lib/javafx.controls.jar:$directory/javafx-sdk-11.0.2/lib/javafx.graphics.jar" Main.class
#-javaagent:/home/nsc/idea-IC-193.5662.53/lib/idea_rt.jar=39843:/home/nsc/idea-IC-193.5662.53/bin/usr/lib/jvm/usr/lib/jvm
exit
