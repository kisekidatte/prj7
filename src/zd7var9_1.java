import java.util.*;
import java.io.*;

public class zd7var9_1 {
    public static void main(String[] args) throws IOException, EOFException {
        Scanner sc = new Scanner(System.in);
        try{
            //RAF1
            File f1 = new File("singgers.txt");
            if(f1.exists()) f1.delete();
            f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            rf.seek(0);

            System.out.println("Singer_1 " + rf.length());

            System.out.println("singers amount: ");
            int count = sc.nextInt();

            for(int i = 0; i < count; i++){
                System.out.println("Singer_name: ");
                String name = sc.next();
                rf.writeUTF(name);
                for(int j = 0; j < 20-name.length(); j++){
                    rf.writeByte(1);
                }
                System.out.println("Rating: ");
                int rating = sc.nextInt();
                rf.writeInt(rating);
                System.out.println("amount_of_albums: ");
                int amountofalbums = sc.nextInt();
                rf.writeInt(amountofalbums);
            }

            System.out.println("Singer_2 " + rf.length());

            //RAF2
            File f2 = new File("singersOut.txt");
            if(f2.exists()) f2.delete();
            f2.createNewFile();
            RandomAccessFile rf2 = new RandomAccessFile(f2, "rw");
            rf.seek(0);
            rf2.seek(0);
            System.out.println("Singer_3 " + rf2.length());

            int found = 0;
            for (int i = 0; i < count; i++){
                rf.seek(52*i);
                String name = rf.readUTF();
                rf.seek(52*i + 22);
                int rating = rf.readInt();
                rf.seek(52*i + 44);
                int amountofalbums = rf.readInt();
                if (amountofalbums>10){
                    rf2.writeUTF(name);
                    for(int j = 0; j < 20-name.length(); j++){
                        rf2.writeByte(1);
                    }
                    rf2.writeInt(rating);
                    rf2.writeInt(amountofalbums);
                    found++;
                }
            }

            System.out.println("Singer_4 " + rf2.length());
            System.out.println("Количество записей: " + found);
            rf2.seek(0);
            for(int i = 0; i < found; i++){
                rf2.seek(52*i);
                String name = rf2.readUTF();
                rf2.seek(52*i + 22);
                int rating = rf2.readInt();
                rf2.seek(52*i + 44);
                int amountofalbums = rf2.readInt();
                System.out.println("Singer name: " + name + " Rating: " + rating + " amount of albums: " + amountofalbums);
            }
            rf.close();
            rf2.close();
        } catch (EOFException eof) {
            System.out.println("EOF");
        } catch (IOException ioe) {
            System.out.println("IOE");
        }
    }
}