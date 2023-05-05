import java.io.*;
import java.nio.file.FileSystems;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = new File(FileSystems.getDefault().getPath("./").toAbsolutePath().getParent() + "/outputFile");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        firstPart(dir);
        secondPart(dir);
        thirdPart(dir);
    }

    public static void firstPart(File dir) throws IOException {

        File file = new File(dir.getPath() + "/" + "первое задание.txt");
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < 15; i++) {
            fileWriter.write(((Integer)(int)(Math.random() * 500)).toString() + ' ');
        }

        fileWriter.close();

        Scanner scanner = new Scanner(file);
        String[] numbersLine = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }

        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);

        FileWriter fileWriter1 = new FileWriter(file);

        fileWriter1.write(Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

        fileWriter1.close();
    }

    public static void secondPart(File dir) throws IOException {
        File file = new File(dir.getPath() + "/" + "secondPart.java");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedReader reader = new BufferedReader(new FileReader(FileSystems.getDefault().getPath("./").toAbsolutePath().getParent() + "/" + "src" + "/" + "Example.java"));
        while (reader.ready()) {
            String data = reader.readLine();
            if(!data.contains("class")) {
                data = data.replace("public","private");
            }

            fileWriter.write(data);
            fileWriter.write(System.getProperty( "line.separator" ));
        }
        fileWriter.close();
    }

    public static void thirdPart(File dir) throws IOException {
        File file = new File(dir.getPath() + "/" + "thirdPart.java");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedReader reader = new BufferedReader(new FileReader(FileSystems.getDefault().getPath("./").toAbsolutePath().getParent() + "/" + "src" + "/" + "Example.java"));
        while (reader.ready()) {
            String data = reader.readLine();
            char[] dataArray = data.toCharArray();
            String[] reversedArray = new String[dataArray.length];
            int j = 0;
            for(int i = dataArray.length - 1; i >= 0; i--){
                reversedArray[j] = String.valueOf(dataArray[i]);
                j++;
            }
            data = String.join("",reversedArray);
            fileWriter.write(data);
            fileWriter.write(System.getProperty( "line.separator" ));
        }
        fileWriter.close();
    }
}