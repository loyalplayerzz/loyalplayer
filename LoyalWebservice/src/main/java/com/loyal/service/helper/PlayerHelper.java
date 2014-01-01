package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.PlayersDAO;
import com.loyal.persistence.dao.PlayersLevelDAO;
import com.loyal.persistence.dao.PlayersLoyalpointsDAO;
import com.loyal.service.pojo.Player;

public class PlayerHelper {
	
	@Autowired
	public PlayersDAO playersDAO;
	
	@Autowired
	public PlayersLevelDAO playersLevelDAO;
	
	@Autowired
	public PlayersLoyalpointsDAO playersLoyalPointsDAO;

	public PlayersDAO getPlayersDAO() {
		return playersDAO;
	}

	public void setPlayersDAO(PlayersDAO playersDAO) {
		this.playersDAO = playersDAO;
	}

	public PlayersLevelDAO getPlayersLevelDAO() {
		return playersLevelDAO;
	}

	public void setPlayersLevelDAO(PlayersLevelDAO playersLevelDAO) {
		this.playersLevelDAO = playersLevelDAO;
	}

	public PlayersLoyalpointsDAO getPlayersLoyalPointsDAO() {
		return playersLoyalPointsDAO;
	}

	public void setPlayersLoyalPointsDAO(PlayersLoyalpointsDAO playersLoyalPointsDAO) {
		this.playersLoyalPointsDAO = playersLoyalPointsDAO;
	}
	
	
	public Player getPlayerDetails(String userID){
		
		return new Player();
	}
	
	public Player createPlayer(Player player){
		
		return new Player();
	}
	
	public List<Player> retrieveAllPlayers(Integer limit){
		return new ArrayList<Player>();
	}

}
