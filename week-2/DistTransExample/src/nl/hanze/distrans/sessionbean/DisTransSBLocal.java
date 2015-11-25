/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hanze.distrans.sessionbean;

import javax.ejb.Local;

/**
 *
 * @author zech
 */
@Local
public interface DisTransSBLocal {
    public boolean from1To2(int amount);
}
