package ReadyQueue;

import Processes.process;

public class SRT_Q extends ReadyQ {

    public SRT_Q(){
        super();
        PriQ = new MinHeap<process>(100, Comparators.By_SRT);
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
}
