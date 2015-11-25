package nl.hanze.distrans.sessionbean;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.hanze.distrans.entity.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DisTransSB implements DisTransSBLocal {
    @PersistenceContext(unitName = "PUb1")
    private EntityManager em1;

    @PersistenceContext(unitName = "PUb2")
    private EntityManager em2;
    
    @Override
    public boolean from1To2(int amount) {
        T1 t1=em1.find(T1.class, 1);
        t1.setT1number(t1.getT1number()-amount);
        em1.merge(t1);
        T2 t2=em2.find(T2.class, 1);
        t2.setT2number(t2.getT2number()+amount);
        em2.merge(t2);
        return true;
    }
}

