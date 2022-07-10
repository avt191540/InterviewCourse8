import javax.naming.NameNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1 = new User("Andrey", 20);
        User user2 = new User("Mihail", 21);
        User user3 = new User("Boris", 18);
        User user4 = new User("Igor", 19);
        User user5 = new User("Igor", 19);
        User user6 = new User("Nik", 21);
        User user7 = new User("Bob", 20);
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);

        System.out.println(findOldUser(users));
        System.out.println(findOldUserByStream(users));
    }
    private static User findOldUser(List<User> users) {
        System.out.println(users);
        Set<User> userSet = new HashSet<>(users);
        System.out.println(userSet);
        List<User> userAfterSet = new ArrayList<>(userSet);
        System.out.println(userAfterSet);
        Comparator<User> comp = Comparator.comparing(User::getAge).thenComparing(User::getName);
        Collections.sort(userAfterSet,comp);
        System.out.println(userAfterSet);
//        System.out.println(userAfterSet.get(userAfterSet.size() - 1));

        return userAfterSet.get(userAfterSet.size() - 1);
    }

    private static User findOldUserByStream(List<User> users) {
        return users.stream().distinct().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName))
                .skip(users.size() - 2).findFirst().orElseThrow();
    }

}