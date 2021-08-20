package net.deile;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Users> getAll(){
        String sql = "select * from users";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);

        List<Users> list = new ArrayList<>();
        for(Map<String,Object> rows:userList){
            Users user = new Users();
            user.setUser_id((long)rows.get("user_id"));
            user.setUser_name((String)rows.get("user_name"));
            list.add(user);
        }

        return list;
    }
}
