package chat.llamas.cardlogic.game.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigInteger;

import chat.llamas.cardlogic.domain.game.PlayerInterface;
public class PersonDao {
	   @PersistenceContext
	   private EntityManager em;

	   public PlayerInterface read(BigInteger id) {
	      return em.find(PlayerInterface.class, id);
	   }
	   
	   public void create(PlayerInterface player) {
		   
	   }
	   
	   public void update(PlayerInterface player) {
		   
	   }
	   
	   public void delete(PlayerInterface player) {
		   
	   }
}
