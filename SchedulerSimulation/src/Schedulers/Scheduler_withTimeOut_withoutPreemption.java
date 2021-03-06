package Schedulers;

import Processes.process;

import java.util.List;

/**
 * Scheduler_withoutPreemption_withTimeout is a subclass of Scheduler_with_Timeout.
 * This class extends Scheduler_with_Timeout to not include preemption in the handling of events
 * Algorithms that are subclasses of this are RR.
 */
public abstract class Scheduler_withTimeOut_withoutPreemption extends Scheduler_with_TimeOut {

    /**
     *Constructor for scheduler without preemption and with out time out
     */
    public Scheduler_withTimeOut_withoutPreemption(List<process> masterList){
        super(masterList);
    }


    /**
     * arriveReadyQ does not take into account preemption
     */
    public void arriveReadyQ(process P){
        //Determine scheduler cost for this event
        if(this.ReadyProcesses.isEmpty() && this.getActiveProcess() == null){
            //There is no scheduler cost for this event.
            this.updateNextSCost(0);
        }
        else {
            this.updateNextSCost(SCostIn);
        }

        if(this.getActiveProcess() != null){
            //if there is a running process, increment it's CPUTime
            //Also increment CPU ActiveTime
            this.ActiveProcess.updateCPU (this.getNextEvent()- this.getTime());
            this.updateActiveTime(this.getNextEvent() - this.getTime());

            //add P into the ReadyQ
            this.ReadyProcesses.add(P);
        }
        else {
            //if there is no running process, make P the new running process
            this.updateActiveProcess(P);

            //Update idol time because the CPU is back to being active
            this.updateIdolTime(this.getNextEvent() - this.getStartIdleTime());
        }
        //Update NextBlock, NextSchedExit, and NextTimeout because of overhead or because the active process has changed
        this.updateNextBlock();
        this.updateNextSchedExit();
        this.updateNextTimeOut();

        //Start Ps ready time
        P.StartReadyTime = this.getNextEvent() + this.getNextSCost();
    }

}
