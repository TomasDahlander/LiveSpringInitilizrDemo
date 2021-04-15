package repos;

import models.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 14:42 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
public class FriendDAO {

    public List<Friend> getAllFriends(){
        List<Friend> list = new ArrayList<>();
        list.add(new Friend(1,"Arne","Testgatan 1","0701111111"));
        list.add(new Friend(2,"Bengt","Testgatan 2","0702222222"));
        list.add(new Friend(3,"Clas","Testgatan 3","0703333333"));
        list.add(new Friend(4,"David","Testgatan 4","0704444444"));
        return list;
    }

    public Friend getFriend(){
        return new Friend(1,"Arne","Testgatan 1","0701111111");
    }
}

