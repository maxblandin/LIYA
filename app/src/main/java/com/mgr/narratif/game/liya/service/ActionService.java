package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;

public class ActionService {

    public static ResultatDes verifierResult (Action action, ResultatDes result){
        boolean isMatch = false;
        for(ResultatDes rd : action.getSuite().keySet()){
            if(rd == result){
                isMatch = true;
            }
        }

        if(!isMatch){
            switch (result){
                case REUSSITE_CRITIQUE:
                    result = ResultatDes.REUSSITE;
                    break;
                case ECHEC_CRITIQUE:
                    result = ResultatDes.ECHEC;
                    break;
            }
        }
        return result;
    }
}