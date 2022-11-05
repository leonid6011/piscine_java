ex02
ImagesToChar - project folder

1) Создаем папку target
mkdir target

2) Создаем папку lib
mkdir lib

3) Кладем JAR файлы в lib

2) Компилируем
javac -cp lib/JColor-5.2.0.jar:lib/jcommander-1.82.jar -d target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/Convert.java

3) Копируем resources в target
cp -rf ./src/resources ./target

4) Переходим в target
cd target

5) Распаковываем JAR архивы
jar xf ../lib/JColor-5.2.0.jar
jar xf ../lib/jcommander-1.82.jar

6) Возвращаемся в корень
cd ..

4) Создаем JAR архив
jar cfm ./target/images_to_chars.jar ./src/manifest.txt -C ./target .

5) Устанавливаем права
chmod 777 ./target/images_to_chars.jar

6) Запуск программы где:
1. символ белого цвета становится зеленым
2. символ черного цвета становится красным
java -jar target/images_to_chars.jar --white=RED --black=GREEN

P. S. нам не нужно указывать путь к изображению т.к. оно уже в архиве

7) Отчистка target
rm -rf target


fast test:

mkdir target
cd target
jar xf ../lib/JColor-5.2.0.jar
jar xf ../lib/jcommander-1.82.jar
cd ..
javac -cp lib/JColor-5.2.0.jar:lib/jcommander-1.82.jar -d target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/Convert.java
cp -rf ./src/resources ./target
jar cfm ./target/images_to_chars.jar ./src/manifest.txt -C ./target .
chmod 777 ./target/images_to_chars.jar
java -jar target/images_to_chars.jar --white=RED --black=GREEN


