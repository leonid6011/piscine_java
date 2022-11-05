ImagesToChar - project folder

1) Создаем папку target
mkdir target

2) Компиляция исходного кода в папку target. (из .java в .class)
javac src/java/edu/school21/printer/*/*.java -d target

3) Запуск программы где:
1. символ белого цвета
2. символ черного цвета
3. путь для .bmp файла 
java -cp target edu/school21/printer/app/Program . 0 it.bmp

4) Отчистка target
rm -rf target

