package com.loyal.calculate;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.GameRoundSummaryDAO;
import com.loyal.persistence.dao.LoyalpointsDAO;
import com.loyal.persistence.dao.PlayersDAO;
import com.loyal.persistence.dao.PlayersLoyalpointsDAO;
import com.loyal.persistence.dto.GameRoundSummaryDTO;
import com.loyal.persistence.dto.LoyalpointsDTO;
import com.loyal.persistence.dto.PlayersLoyalpointsDTO;



/**
 * 1) Find from configuration table for how many rows you need to run the job. Lets suppose it is 200
2) Find from configuration table from which ID you need to run the job. Lets suppose 400
3) Run the job for number of rows found in  step 1) and from the the id greater then found in step 2
    so if last time you had run the job till ID 400 then you will in this transaction from ID 401 till next 200 rows.
    lets suppose to you find 175 rows (it can be anything from 0 to 200). Store the last id value in variable
    called lastIDProcessed, lets suppose it is 575 (400+175)

4) For each row find the player id and see if there are more rows for that player if yes then sum the total 
     number of rows found to find total bet. If player already exist then update the his loyalty points with time
    stamp else create new player with loyalty points and time stamp. 
   Alternatively do group by query (on userid) in step 3 for next 200 rows and then run the step 4 for each
   unique user

5) Do Step 4 for each row but remember if player id has already dealt with then we should just ignore the row
    since player can have multiple rows it means that we might find row for player for which we have already done
the calculation, this problem may be avoided by selecting rows with group by on userid and then run the logic
for each unique userid.(described as alternate method in Step 4)
6) Update the configuration table with lastIDProcessed
 *
 *
 * NOTE: Pseudo code for calculation of loyalty points as I understood(all this to be done in 1 transaction). It is important
to remember that this algo cannot be run on multiple servers else it will cause problems.
 *
 */
public class PlayerLoyalPointsCalculation {
	
	@Autowired
	public GameRoundSummaryDAO gameRoundSummaryDAO;
	
	public GameRoundSummaryDAO getGameRoundSummaryDAO() {
		return gameRoundSummaryDAO;
	}

	public void setGameRoundSummaryDAO(GameRoundSummaryDAO gameRoundSummaryDAO) {
		this.gameRoundSummaryDAO = gameRoundSummaryDAO;
	}
	
	@Autowired
	public PlayersDAO playersDAO;

	public PlayersDAO getPlayersDAO() {
		return playersDAO;
	}

	public void setPlayersDAO(PlayersDAO playersDAO) {
		this.playersDAO = playersDAO;
	}
	
	@Autowired
	public PlayersLoyalpointsDAO playerLoyalPointsDAO;

	public PlayersLoyalpointsDAO getPlayerLoyalPointsDAO() {
		return playerLoyalPointsDAO;
	}

	public void setPlayerLoyalPointsDAO(PlayersLoyalpointsDAO playerLoyalPointsDAO) {
		this.playerLoyalPointsDAO = playerLoyalPointsDAO;
	}
	
	@Autowired
	public LoyalpointsDAO loyalPointsDAO;

	public LoyalpointsDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public boolean calculateLoyaltyPoints(){
		boolean success = false;
		int lastID = 0;
		// Retrieve start ID from which Config table needs to 
		int noOfRows = retrieveConfigurationBasedOnParam("noOfRows", "ConfigTableName");
		int startID = retrieveConfigurationBasedOnParam("startID", "ConfigTableName");
		int playerID = 0;
		Double betAmt = 0.0;
		int existingPlayerID = 0;
		//Map<Integer, Integer> totalBetMap = new HashMap<Integer, Integer>();
		for(int i = startID; i< startID+noOfRows; i++){
			// Get PlayerID for that instance
			
			GameRoundSummaryDTO gameRoundDTO = gameRoundSummaryDAO.findById(startID);
			playerID = Integer.valueOf(gameRoundDTO.getPlayerId());
			
			// Get Total Bet for that instance
			betAmt = gameRoundDTO.getTotalBet();
			
			// Retrieve PlayerID from existing table to variable existingPlayerID
			if(playersDAO.findById(playerID) != null){
				//totalBetMap.put(playerID, totalBetMap.get(playerID)+betAmt);
				//TODO update the player with existing betAmt+newbetAmt
				PlayersLoyalpointsDTO playersLoyalPointsDTO = (PlayersLoyalpointsDTO) playerLoyalPointsDAO.findByPlayerId(playerID);
				LoyalpointsDTO loyalPointsDTO = loyalPointsDAO.findById(playersLoyalPointsDTO.getLoyalpointsId());
				//loyalPointsDTO.setBet(playersDTO.setloyalPointsDTO.getBet()+Integer.valueOf(betAmt););
				
			} else {
				//totalBetMap.put(playerID, betAmt);
				//TODO update player with only newBetAmt
			}
			lastID = i;
		}
		
		//Store LastID
		storeConfigurationBasedParam("lastID", "configTable", String.valueOf(lastID));
		
		// On successful update
		success = true;
		
		// if all operation is completed finish with success true status
		return success;
	}
	
	private boolean storeConfigurationBasedParam(String parameterRequested, String configTable, String value){
		int paramValue = 600;
		return true;
	}
	
	private int retrieveConfigurationBasedOnParam(String parameterRequested, String configTable){
		//Sample param retrieved for noOfRows to be updated
		int paramValue = 200;
		
		//Sample param to get start ID
		paramValue = 400;
		
		return paramValue;
	}

}
