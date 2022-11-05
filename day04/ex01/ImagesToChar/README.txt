ex01
ImagesToChar - project folder

1) Создаем папку target
mkdir target

2)
javac -d target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/Convert.java

3) Копируем resources в target
cp -rf ./src/resources ./target

4) Создаем JAR архив
jar cfm ./target/images_to_chars.jar ./src/manifest.txt -C ./target .

5) Устанавливаем права
chmod 777 ./target/images_to_chars.jar

6) Запуск программы где:
1. символ белого цвета
2. символ черного цвета
java -jar ./target/images_to_chars.jar . 0

P. S. нам не нужно указывать путь к изображению т.к. оно уже в архиве

7) Отчистка target
rm -rf target

