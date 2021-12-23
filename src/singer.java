import java.io.Serializable;

public class singer implements Serializable {
    String name;
    int rating;
    int amountofalbums;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", amount_of_albums=" + amountofalbums +
                '}';
    }
}