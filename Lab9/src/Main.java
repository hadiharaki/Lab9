import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {

	public static void main(String[] args) {
String filePath="C:/Users/user/Desktop/Lab9.txt";

readmethod2(filePath);
List<String> wordsToDelete = Arrays.asList("@");
String replacement = ".";

filterFile3(filePath, wordsToDelete, replacement);
System.out.println("after replacement");
readmethod2(filePath);
}

static void writeToFile(String filePath) {
try {
File f=new File(filePath);
FileWriter fw=new FileWriter(f,true);
fw.write("he she it this");
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
static void readmethod1(String filePath) {
try {
Path p = Paths.get(filePath);
 List<String> lines = Files.readAllLines(p,StandardCharsets.UTF_8);
lines.forEach(System.out::println);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
	}
}

static void readmethod2(String filePath) {
try {
File f = new File(filePath);
Scanner sc;
sc = new Scanner(f, StandardCharsets.UTF_8.name());
while (sc.hasNextLine())
System.out.println(sc.nextLine());
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}}

static void readmethod3(String filePath) {
try {
FileReader fReader;
fReader = new FileReader(filePath);
BufferedReader reader= new BufferedReader(fReader);
String line;
try {
while ((line=reader.readLine())!=null)
System.out.println(line);
} catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
     }
 } catch (FileNotFoundException e) {
 // TODO Auto-generated catch block
     e.printStackTrace();
 }
   }

 static void readmethod4(String filePath) {
 try {
Path p = Paths.get(filePath);
 Stream<String> lines = Files.lines(p);
 lines.forEach(a->System.out.println(a));
  } catch (IOException e) {
 // TODO Auto-generated catch block
  e.printStackTrace();
  }
    }
static void read_and_replace(String filePath,String replaced,String replacewith) {
try {
	Path p=Paths.get(filePath);
	List<String> lines = Files.readAllLines(p,StandardCharsets.UTF_8);
	lines.forEach(l->{
	String newStr=l.replaceAll(replaced,replacewith);
	System.out.println(newStr);
	});
  } catch (IOException e) {
     // TODO Auto-generated catch block
  e.printStackTrace();
  
}
}	
public static void filterFile(String filePath, String[] wordsToDelete) {
    try {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        // Replace all occurrences of the words to delete in each line
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (String word : wordsToDelete) {
                line = line.replaceAll(word, "");
            }
            lines.set(i, line);
        }

        // Write the modified lines back to the file
        Files.write(path, lines, StandardCharsets.UTF_8);
        System.out.println("Filtering complete!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void filterFile2(String filePath, List<String> wordsToDelete, String replacement) {
    try {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        List<String> newLines = new ArrayList<>();

        for (String line : lines) {
            for (String word : wordsToDelete) {
                line = line.replaceAll(word, replacement);
            }
            newLines.add(line);
        }

        Files.write(path, newLines, StandardCharsets.UTF_8);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void filterFile3(String filePath, List<String> wordsToDelete, String replacement) {
    try {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        List<String> newLines = lines.stream()
                .map(line -> {
                    for (String word : wordsToDelete) {
                        line = line.replaceAll(word, replacement);
                    }
                    return line;
                })
                .collect(Collectors.toList());

        Files.write(path, newLines, StandardCharsets.UTF_8);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void filterFile4(String filePath, List<String> wordsToDelete, String replacement) {
    try {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        List<String> newLines = lines.stream()
                .map(line -> {
                    String newLine = line;
                    for (String word : wordsToDelete) {
                        newLine = Arrays.stream(newLine.split(","))
                                .filter(w -> !w.equals(word))
                                .collect(Collectors.joining(" "));
                    }
                    return newLine;
                })
                .collect(Collectors.toList());

        Files.write(path, newLines, StandardCharsets.UTF_8);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

