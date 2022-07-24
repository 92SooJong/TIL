import domain.Account;
import domain.Portfolio;
import domain.Stock;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            // 계좌A 생성
            Account account1 = new Account();
            account1.setAccountName("accountA");
            account1.setDeposit(10000);
            em.persist(account1);

            // 사용자 생성
            User user = new User();
            user.setUserName("SooJong");
            user.addAccount(account1); // 계좌 추가
            em.persist(user);

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
