ALES="xurbana00"
MARTIN="xkovacm01" # Vedoucí
JUNIT="junit-platform-console-standalone-1.11.4.jar"

.PHONY: all test clean zip

all: homework1 homework2

homework1:
	javac -cp .:${JUNIT} -d cls ija/ija2024/homework1/Homework1Test.java

homework2:
	javac -cp .:ijatool.jar:${JUNIT} -d build ija/ija2024/homework2/Homework2Test.java

test: test1 test2

test1: homework1
	java -ea -jar ./${JUNIT} execute --cp cls --scan-class-path

test2: homework2
	java -ea -jar ./${JUNIT} execute --cp build:ijatool.jar --scan-class-path

clean:
	rm -rf cls build ${ALES}.zip ${MARTIN}.zip

zip: zip1 zip2

zip1:
	zip ${ALES}.zip -r ija -x "*.DS_Store" -x "ija/ija2024/homework1/Homework1Test.java" -x "ija/ija2024/homework2/*" -x "ija/ija2024/homework1/readme.md" -x "ija/ija2024/homework1/doc/*"

zip2:
	zip ${MARTIN}.zip -r ija requirements.pdf -x "*.DS_Store" -x "ija/ija2024/homework2/Homework2Test.java" -x "ija/ija2024/homework2/Homework2.java" -x "ija/ija2024/homework1/*" -x "ija/ija2024/homework2/readme.md" -x "ija/ija2024/homework2/doc/*"
