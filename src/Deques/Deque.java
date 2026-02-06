/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deques;

/**
 *
 * @author ojeda
 */
public interface Deque {
    public int size();
    public boolean isEmpty();
    public void insertFirst(Object Data);
    public void insertLast(Object Data);
    public Object removeFirst();
    public Object removeLast();
    public Object first();
    public Object last();
}
