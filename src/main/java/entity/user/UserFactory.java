package entity.user;

public class UserFactory {

    public User createUser(String username, String tagline, String region, String puuId) throws Exception {
        return new User(username, tagline, region, puuId);
    }
}
