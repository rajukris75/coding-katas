package com.github.sparsick.coding.kata.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
class Game {
    
    private List<BowlingFrame> bowlingFrames = new ArrayList<>();
    
    

    int roll(String allRolls) {
        for (int i = 0; i < allRolls.length(); i++) {
           
            String frame = pickRollsFor(allRolls, i);
            
            BowlingFrame bowlingFrame = new BowlingFrame(frame);
            
            if(!bowlingFrames.isEmpty()) {
                BowlingFrame lastFrame = bowlingFrames.remove(bowlingFrames.size()-1);
                lastFrame.nextFrame(bowlingFrame);
                bowlingFrames.add(lastFrame);
            }
            
            
            bowlingFrames.add(bowlingFrame);
            if(!bowlingFrame.isStrike()) {
                i++;
            }
            
        }
        
        return bowlingFrames.subList(0, 10).stream().mapToInt(bowlingFrame -> bowlingFrame.totalSum()).sum();
    }

    private String pickRollsFor(String allRolls, int i) {
        char firstRoll = allRolls.charAt(i);
        String frame = Character.toString(firstRoll);
        if(firstRoll != 'X' && i < allRolls.length() -1) {
            char secondRoll = allRolls.charAt(i + 1);
            frame = frame.concat(Character.toString(secondRoll));
        }
        return frame;
    }

}
