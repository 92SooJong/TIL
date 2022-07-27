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

            Parent parent = new Parent();
            parent.setId1("myId1");
            parent.setId2("myId2");
            parent.setName("soojong");
            em.persist(parent);

            ParentId parentId = new ParentId("myId1", "myId2");
            Parent findParent = em.find(Parent.class, parentId);

            System.out.println("findParent.getId1() = " + findParent.getId1());
            System.out.println("findParent.getId2() = " + findParent.getId2());
            System.out.println("findParent.getName() = " + findParent.getName());

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
