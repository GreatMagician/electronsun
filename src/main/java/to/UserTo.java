package to;

/**
 * Created by Александр on 09.02.2017.
 */
public class UserTo {

    private final Long id;

    private  final String nickName;

    private final boolean enabled;


    public UserTo(Long id, String nickName, boolean enabled) {
        this.id = id;
        this.nickName = nickName;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
