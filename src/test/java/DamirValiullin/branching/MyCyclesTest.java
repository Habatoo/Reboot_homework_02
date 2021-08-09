package DamirValiullin.branching;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import DamirValiullin.branching.MyCycles;
import DamirValiullin.common.Utils;

import static org.mockito.ArgumentMatchers.anyString;

public class MyCyclesTest
{
    Utils utilsMock;
    MyCycles myCycles;

    @BeforeEach
    public  void init(){
        utilsMock = Mockito.mock(Utils.class);
        myCycles = new MyCycles(utilsMock);
    }

    /**
     * Проверка количества обращений к {@link Utils}
     */
    @Test
    public void cycleForExample_Test()
    {
        final int iterations = 2;

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);

        myCycles.cycleForExample(iterations, "Hello!");

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
    }

    /**
     * Проверка количества обращений к {@link Utils}
     */
    @Test
    public void cycleWhileExample_Test()
    {
        final int iterations = 3;

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);

        myCycles.cycleWhileExample(iterations, "Hello!");

        Mockito.verify(utilsMock, Mockito.times(iterations)).utilFunc1(anyString());
    }

    /**
     * Проверка количества обращений к {@link Utils}
     */
    @Test
    public void cycleDoWhileExample_Test()
    {
        final int from = 3;
        final int to = 2;

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);

        myCycles.cycleDoWhileExample(from, to, "Hello!");

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
    }

}
