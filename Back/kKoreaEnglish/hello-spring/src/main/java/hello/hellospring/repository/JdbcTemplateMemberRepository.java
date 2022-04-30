package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.apache.catalina.mapper.Mapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    //생성자가 하나일 경우에는 @Autowired를 생랄할 수 있다.
    public JdbcTemplateMemberRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jdbcTemplate.query("select * from member where id = ?", );
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

//    private RowMapper<Mapper> memberRowMapper(ResultSet rs, int rowNum) throws SQLException {
//
//        Member member = new Member();
//        member.setId(rs.getLong("id"));
//        member.setName(rs.getString("name"));
//
//        return member;
//    }


}
