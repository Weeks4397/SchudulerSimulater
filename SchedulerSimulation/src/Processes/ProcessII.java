package Processes;
import Generators.*;

/**
 * Processes of type II
 */
public class ProcessII extends process{

    /**
     * processGenerator object for type 2 processes
     */
    private ProccessIIGenerator PG2 = new ProccessIIGenerator();

    /**
     * Constructor for a type 2 process
     */
    public ProcessII() {
        super();
        this.Type = 2;
        this.RunTime = PG2.getprocessRunTime();
        this.NextBlockInstant =Integer.MAX_VALUE;
        this.NextBlockResource = null;
        this.NextBlockTime = 0;
        this.genBlockRecord();

    }

    /**
     * generate the block record
     * processes of type 2 never block
     */
    public void genBlockRecord(){
            this.BlockRecord = null;
    }

    /**
     * creates a clone of this process
     * @return the cloned process
     */
    public process cloneProcess() {
        ProcessII PII = new ProcessII();
        PII.updateStartBlockWaitTime(this.StartBlockWaitTime);
        PII.setCPU(this.CPUTime);
        PII.updateRunTime(this.RunTime);
        PII.updateType(this.Type);
        PII.updateNextBlockInstant(this.NextBlockInstant);
        PII.updateNextBlockResource(this.NextBlockResource);
        PII.updateNextBlockTime(this.NextBlockTime);
        PII.updateArrivalTime(this.ArrivalTime);
        PII.updateStartReadyTime(this.StartReadyTime);
        PII.updateTotalReadyTime(this.TotalReadyTime);
        PII.updateCurrentReadyTime(this.CurrentReadyTime);
        PII.setLastEventTime(this.LastEventTime);
        PII.updateFinishTime(this.FinishTime);
        PII.updateBlockServiceTime(this.BlockServiceTime);
        PII.updateBlockWaitTime(this.BlockWaitTime);
        PII.updateServiceStartTime(this.ServiceStartTime);
        PII.updateStringID(this.StringID);
        PII.updatetSchedInstant_Count(this.SchedInstant_Count);
        PII.updateTimeOut_Count(this.TimeOut_Count);
        PII.updatePreempt_Count(this.Preempt_Count);

        return PII;
    }

}
