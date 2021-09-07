package me.arunav.spring.player.controller;

import me.arunav.spring.player.data.dao.PlayerDao;
import me.arunav.spring.player.data.vo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tennis")
public class TennisPlayerController {

    private final PlayerDao playerDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TennisPlayerController(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        logger.info("All players={}", playerDao.getAllPlayers());
        return playerDao.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable int id) {
        logger.info("All players={}", playerDao.getPlayerById(id));
        return playerDao.getPlayerById(id);
    }

    @PostMapping("/player")
    public String insertPlayer(@RequestBody Player player) {
        return playerDao.insertPlayer(player) > 0 ? "Player added Successfully" : "Player addition failed";
    }

    @PutMapping("/player")
    public String updatePlayer(@RequestBody Player player) {
        return playerDao.updatePlayer(player) > 0 ? "Player updated Successfully" : "Player update failed";
    }

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable int id) {
        return playerDao.deletePlayerById(id) > 0 ? "Player deleted Successfully" : "Player deletion failed";
    }
}
