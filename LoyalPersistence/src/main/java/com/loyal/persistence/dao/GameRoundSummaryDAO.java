package com.loyal.persistence.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.persistence.dto.GameRoundSummaryDTO;

/**
 * A data access object (DAO) providing persistence and search support for
 * GameRoundSummaryDTO entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.test.hibernate.GameRoundSummaryDTO
 * @author MyEclipse Persistence Tools
 */
public class GameRoundSummaryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GameRoundSummaryDAO.class);
	// property constants
	public static final String PLAYER_ID = "playerId";
	public static final String PROVIDER = "provider";
	public static final String GAME_ID = "gameId";
	public static final String GAME_ROUNDS = "gameRounds";
	public static final String TOTAL_BET = "totalBet";
	public static final String TOTAL_WIN = "totalWin";

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(GameRoundSummaryDTO transientInstance) {
		log.debug("saving GameRoundSummaryDTO instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GameRoundSummaryDTO persistentInstance) {
		log.debug("deleting GameRoundSummaryDTO instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GameRoundSummaryDTO findById(java.lang.Integer id) {
		log.debug("getting GameRoundSummaryDTO instance with id: " + id);
		try {
			GameRoundSummaryDTO instance = (GameRoundSummaryDTO) getSession()
					.get("com.test.hibernate.GameRoundSummaryDTO", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<GameRoundSummaryDTO> findByExample(GameRoundSummaryDTO instance) {
		log.debug("finding GameRoundSummaryDTO instance by example");
		try {
			List<GameRoundSummaryDTO> results = (List<GameRoundSummaryDTO>) getSession()
					.createCriteria("com.test.hibernate.GameRoundSummaryDTO")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding GameRoundSummaryDTO instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from GameRoundSummaryDTO as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<GameRoundSummaryDTO> findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	public List<GameRoundSummaryDTO> findByProvider(Object provider) {
		return findByProperty(PROVIDER, provider);
	}

	public List<GameRoundSummaryDTO> findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	public List<GameRoundSummaryDTO> findByGameRounds(Object gameRounds) {
		return findByProperty(GAME_ROUNDS, gameRounds);
	}

	public List<GameRoundSummaryDTO> findByTotalBet(Object totalBet) {
		return findByProperty(TOTAL_BET, totalBet);
	}

	public List<GameRoundSummaryDTO> findByTotalWin(Object totalWin) {
		return findByProperty(TOTAL_WIN, totalWin);
	}

	public List findAll() {
		log.debug("finding all GameRoundSummaryDTO instances");
		try {
			String queryString = "from GameRoundSummaryDTO";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameRoundSummaryDTO merge(GameRoundSummaryDTO detachedInstance) {
		log.debug("merging GameRoundSummaryDTO instance");
		try {
			GameRoundSummaryDTO result = (GameRoundSummaryDTO) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameRoundSummaryDTO instance) {
		log.debug("attaching dirty GameRoundSummaryDTO instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GameRoundSummaryDTO instance) {
		log.debug("attaching clean GameRoundSummaryDTO instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}