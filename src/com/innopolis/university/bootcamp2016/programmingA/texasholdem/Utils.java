package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jessie on 19.07.2016.
 */
public class Utils {

    public static int nextId(List<? extends Object> list, int index){
        return (index + 1)%list.size();
    }


    /**
     * WARNING: Modifies passed list
     *
     * @param linkedList
     * @return
     */
    public static Player passTurn(LinkedList<Player> linkedList){
        linkedList.add(linkedList.removeFirst());
        return  linkedList.getFirst();
    }
}
