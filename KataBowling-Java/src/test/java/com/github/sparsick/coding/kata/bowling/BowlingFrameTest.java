package com.github.sparsick.coding.kata.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 */
public class BowlingFrameTest {

    @Test
    public void totalSum_failToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame("11");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(2);
    }


    @Test
    public void totalSum_secondFailToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame("22");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(4);
    }
    
    @Test
    public void totalSum_failToKnockAllWithAMissAsFirstRoll(){
        BowlingFrame frameUnderTest = new BowlingFrame("-1");
        
        int totalSum = frameUnderTest.totalSum();
        
        assertThat(totalSum).isEqualTo(1);
    }

    @Test
    public void totalSum_failToKnockAllWithTwoMissedRoll(){
        BowlingFrame frameUnderTest = new BowlingFrame("--");
        
        int totalSum = frameUnderTest.totalSum();
        
        assertThat(totalSum).isEqualTo(0);
    }
    
    @Test
    public void totalSum_strike(){
        BowlingFrame frameUnderTest = new BowlingFrame("X");
        
        frameUnderTest.nextFrame(new BowlingFrame("11"));
        int totalSum = frameUnderTest.totalSum();
        
        assertThat(totalSum).isEqualTo(12);
    }

}
