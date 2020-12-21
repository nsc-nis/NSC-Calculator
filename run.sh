#!/bin/bash
directory=${PWD}

java --module-path $directory/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml -Djava.library.path=$directory/javafx-sdk-11.0.2/lib -Dfile.encoding=UTF-8 -classpath $directory/out/production/NSC_Calculator_v.1.4:$directory/javafx-sdk-11.0.2/lib/src.zip:$directory/javafx-sdk-11.0.2/lib/javafx-swt.jar:$directory/javafx-sdk-11.0.2/lib/javafx.web.jar:$directory/javafx-sdk-11.0.2/lib/javafx.base.jar:$directory/javafx-sdk-11.0.2/lib/javafx.fxml.jar:$directory/javafx-sdk-11.0.2/lib/javafx.media.jar:$directory/javafx-sdk-11.0.2/lib/javafx.swing.jar:$directory/javafx-sdk-11.0.2/lib/javafx.controls.jar:$directory/javafx-sdk-11.0.2/lib/javafx.graphics.jar at.nsc.main.Main

exit
