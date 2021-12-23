import java.io.*;
import java.util.*;

public class zd7var9_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try{
            Scanner sc = new Scanner(System.in);
            File f = new File("singers.txt");
            if(f.exists()) f.delete();
            f.createNewFile();
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            System.out.println("singers amount: ");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++) {
                singer singerr = new singer();
                System.out.println("Singer_Name: ");
                singerr.name = sc.nextLine();
                System.out.println("rating: ");
                singerr.rating = sc.nextInt();
                System.out.println("amount_of_albums: ");
                singerr.amountofalbums = sc.nextInt();
                sc.nextLine();
                oos.writeObject(singerr);
            }
            fis = new FileInputStream(f);
            oin = new ObjectInputStream(fis);
            singer t = null;
            for (int i = 0; i<count; i++) {
                t = (singer) oin.readObject();
                if (t.amountofalbums>10){
                    System.out.println(t);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            fis.close();
            oin.close();
        }


    }
}