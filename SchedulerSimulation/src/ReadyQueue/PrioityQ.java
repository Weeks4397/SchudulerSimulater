package ReadyQueue;

import Processes.process;

import java.util.Comparator;

/**
 * subclass of ReadyQ
 * The PriorityQ class uses the minheap to enable dynamic priority functionality for algorithms where dynamic priority is needed
 * These algorithms currently include SJF, SRT, and LWC.
 */
public abstract class PrioityQ extends ReadyQ {


    public PrioityQ(){
        super();
    }
    @Override
    public process peek() {
        process peekVal = null;
        peekVal =PriQ.peek();
        return peekVal;
    }

    @Override
    public process poll() {
        process pollVal = null;
        pollVal = PriQ.poll();
        return pollVal;
    }

    @Override
    public void add(process elem) {
        PriQ.add(elem);
    }

    @Override
    public Boolean isEmpty() {
        return PriQ.isEmpty();
    }

    @Override
    public int size(){return PriQ.size();}

}
