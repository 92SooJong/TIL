import domain.*;

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

            ParentId id1 = new ParentId("myId1","myId2");
            ParentId id2 = new ParentId("myId1","myId2");

            System.out.println("id1.equals(id2) = " + id1.equals(id2));
            System.out.println("id1.hashCode() = " + id1.hashCode());
            System.out.println("id2.hashCode() = " + id2.hashCode());


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
