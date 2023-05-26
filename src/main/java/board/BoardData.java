/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package board;

import java.util.ArrayList;
import java.util.List;
import model.boardData.Board;
import model.boardData.BoardDAO;
import observer.Observer;
import observer.Subject;

/**
 *
 * @author LG
 */

//게시물 리스트 데이터를 보관하고 업데이트 현황 서브젝트
public class BoardData implements Subject {
    private List<Observer> observers;
    private List<Board> boards;

    public BoardData() {
        observers = new ArrayList<Observer>();
        boards = new BoardDAO().findAll();
    }
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update();
        }
    }
    
    public List<Board> getUser(){
        return this.boards;
    }

    public void setStatus(List<Board> boards) {
        this.boards = boards;
        notifyObserver();
    }
}
