/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author Mortadha
 */
public interface ISservice<T> {
    public void add(T t);
    public void update(int id,T t);
    public void delete(int id);
    public List<T> findAll();
}
