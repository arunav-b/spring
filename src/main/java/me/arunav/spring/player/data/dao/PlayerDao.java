package me.arunav.spring.player.data.dao;

import me.arunav.spring.player.data.vo.Player;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {

    private final JdbcTemplate jdbcTemplate;

    public PlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Player.class));
    }

    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new PlayerMapper(), playerId);
    }

    public int insertPlayer(Player player) {
        String sql = "INSERT INTO PLAYER VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, player.getId(), player.getName(), player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()), player.getTitles());
    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE PLAYER SET NAME=?, NATIONALITY=?, BIRTH_DATE=?, TITLES=? WHERE ID=?";
        return jdbcTemplate.update(sql, player.getName(), player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()), player.getTitles(), player.getId());
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE FROM PLAYER WHERE ID=?";
        return jdbcTemplate.update(sql, id);
    }

    private static final class PlayerMapper implements RowMapper<Player> {

        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("ID"));
            player.setName(rs.getString("NAME"));
            player.setNationality(rs.getString("NATIONALITY"));
            player.setBirthDate(rs.getDate("BIRTH_DATE"));
            player.setTitles(rs.getInt("TITLES"));
            return player;
        }
    }
}
