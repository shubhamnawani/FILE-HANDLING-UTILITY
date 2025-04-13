import java.io.*;
import java.util.*;

public class FileHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1. Write");
            System.out.println("2. Read");
            System.out.println("3. Modify");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                try {
                    FileWriter fw = new FileWriter("sample.txt");
                    System.out.println("Enter text:");
                    String text = sc.nextLine();
                    fw.write(text);
                    fw.close();
                    System.out.println("Written.");
                } catch (Exception e) {
                    System.out.println("Error writing.");
                }
            } else if (ch == 2) {
                try {
                    FileReader fr = new FileReader("sample.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                } catch (Exception e) {
                    System.out.println("Error reading.");
                }
            } else if (ch == 3) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
                    ArrayList<String> lines = new ArrayList<>();
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                    br.close();

                    for (int i = 0; i < lines.size(); i++) {
                        System.out.println((i + 1) + ": " + lines.get(i));
                    }

                    System.out.print("Line to change: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num > 0 && num <= lines.size()) {
                        System.out.print("New text: ");
                        String newtext = sc.nextLine();
                        lines.set(num - 1, newtext);
                        BufferedWriter bw = new BufferedWriter(new FileWriter("sample.txt"));
                        for (String l : lines) {
                            bw.write(l);
                            bw.newLine();
                        }
                        bw.close();
                        System.out.println("Modified.");
                    } else {
                        System.out.println("Invalid line number.");
                    }
                } catch (Exception e) {
                    System.out.println("Error modifying.");
                }
            } else if (ch == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Wrong choice.");
            }
        }

        sc.close();
    }
}
