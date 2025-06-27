import java.io.*;
import java.util.Scanner;
public class NotesApp
{
    private static final String FILE_NAME = "notes.txt";
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Write Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Existing Notes Manager.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
    private static void writeNote(Scanner scanner)
    {
        System.out.println("Enter your note: ");
        String note = scanner.nextLine();
        try(FileWriter writer = new FileWriter(FILE_NAME, true))
        {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved.");
        } catch (IOException e)
        {
            System.out.println("An error occured while saving the note.");
            e.printStackTrace();
        }
    }
    private static void viewNotes()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            System.out.println("\nYour Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e)
        {
            System.out.println("An error occured while reading the notes.");
            e.printStackTrace();
        }
    }
}